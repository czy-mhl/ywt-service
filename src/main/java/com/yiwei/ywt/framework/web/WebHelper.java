package com.yiwei.ywt.framework.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Web相关简单的帮助类. <p />
 *
 * Created by czy on 15/8/4.
 */
public abstract class WebHelper {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebHelper.class);

    // \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
    // 字符串在编译时会被转码一次,所以是 "\\b"
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
    private final static String PHONE_REGEX = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            +"|windows (phone|ce)|blackberry"
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            +"|laystation portable)|nokia|fennec|htc[-_]"
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    private final static String TABLET_REGEX = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            +"|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    public final static Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    public final static Pattern TABLET_PATTERN = Pattern.compile(TABLET_REGEX);

    /**
     * 获取Web工程的相对根路径.带斜杠.
     * @param request
     * @return
     */
    public static String getBasePath(HttpServletRequest request) {
        return getServerPath(request) + request.getContextPath() + "/";
    }

    public static String getServerPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

    public static String getRequestURI(HttpServletRequest request) {
        return getRequestURI(request.getRequestURI(), request);
    }

    public static String getRequestURI(String uri, HttpServletRequest request) {
        return getRequestURI(uri, request.getContextPath());
    }

    public static String getRequestURI(String uri, String contextPath) {
        // 去除相对路径
        uri = StringUtils.isBlank(contextPath) ? uri : uri.replace(contextPath, "");
        // 去除链接后缀
        int suffixIndex = uri.lastIndexOf(".");
        if (suffixIndex > -1) {
            uri = uri.substring(0, suffixIndex);
        }
        return uri;
    }

    public static String getRequestURIWithSuffix(HttpServletRequest request, boolean isIncludeContextPath) {
        String uri = request.getRequestURI();
        if (!isIncludeContextPath) {
            uri = StringUtils.isBlank(request.getContextPath()) ? uri : uri.replace(request.getContextPath(), "");
        }
        return uri;
    }

    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException ignored) {
                }
                if (null != inet) {
                    ip = inet.getHostAddress();
                }
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.contains(",")) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

    //将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
    public static long ipV4ToLong(String strIp){
        if (StringUtils.isBlank(strIp) || strIp.contains(":") || strIp.split("\\.").length != 4) {
            return 0L;
        }
        long[] ip = new long[4];
        //先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        //将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1+1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2+1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3+1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    //将十进制整数形式转换成127.0.0.1形式的ip地址
    public static String longToIPV4(long longIp){
        StringBuilder sb = new StringBuilder("");
        //直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        //将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        //将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        //将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    /**
     * 判断请求是否为移动设备访问的请求.
     *
     * @param request   用户请求
     * @return  如果是则返回True
     */
    public static boolean isMobileDeviceRequest(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT");
        userAgent = StringUtils.isBlank(userAgent) ? request.getHeader("User-Agent") : userAgent;
        // 如果找不到信息，则认为不是移动端访问
        return StringUtils.isNotBlank(userAgent) && (PHONE_PATTERN.matcher(userAgent.toLowerCase()).find() || TABLET_PATTERN.matcher(userAgent.toLowerCase()).find());
    }

    /**
     * 是否为Ajax请求.
     *
     * @param request   用户请求
     * @return  如果是则返回True
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }

    /**
     * 响应一个json请求.
     *
     * @param jsonObject    要响应的json对象
     * @param response      服务器响应对象
     * @throws IOException  服务器响应I/O异常
     */
    public static void responseJSON(Object jsonObject, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        if (null == jsonObject) {
            response.getWriter().println("{}");
        } else {
            response.getWriter().println(new ObjectMapper().writeValueAsString(jsonObject));
        }
        response.getWriter().flush();
    }

    /**
     * 响应一个HTML文本请求.
     *
     * @param text          HTML文本信息
     * @param response      服务器响应对象
     * @throws IOException  服务器响应I/O异常
     */
    public static void responseHTMLText(String text, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(text);
        response.getWriter().flush();
    }

    public static Map<String, String> getRequestParameterMap(HttpServletRequest request) {
        Enumeration<String> em = request.getParameterNames();
        Map<String, String> parameterMap = new HashMap<>();
        while (em.hasMoreElements()) {
            String key = em.nextElement();
            String value = request.getParameter(key);
            parameterMap.put(key, value);
        }
        return parameterMap;
    }

    public static String getRefererURI(HttpServletRequest request) {
        return request.getHeader("Referer");
    }

    /**
     * 获取session中的值，将他转换成为你想要转换的对象. <p />
     * 如果session中的值为空，那么返回Null
     * 如果session中的值不是需要转换的对象类型的实例，那么返回Null
     * 如果session中的值在最终转换的时候产生了错误，那么返回Null，并输出日志
     *
     * @param session               用户WEB的会话对象
     * @param sessionKey            会话中的Key值
     * @param sessionObjectClass    需要最终转换的值的类型
     * @param <T>                   返回对象的类型
     * @return  返回转换好的实例
     */
    public static <T> T getSessionAttribute(HttpSession session, String sessionKey, Class<T> sessionObjectClass) {
        Object obj = session.getAttribute(sessionKey);
        if (null == obj) {
            return null;
        }
        if (!sessionObjectClass.isInstance(obj)) {
            return null;
        }
        try {
            return sessionObjectClass.cast(obj);
        } catch (Exception e) {
            LOGGER.error("Convert session attribute[" + sessionKey + "] object to class[" + sessionObjectClass.getName() + "]", e);
            return null;
        }
    }
}
