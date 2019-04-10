package com.yiwei.ywt.framework.utils;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Created by czy on 2017/1/21.
 */
public class SfXmlUtils {

    public static Object fromXmlString(Digester digester,String xml){
        InputStream in_withcode = null;
        try {
            in_withcode   =   new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        try {
            return digester.parse(in_withcode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fromObjectToString(JAXBContext context, Object object){
//        JAXBContext context = JAXBContext.newInstance(object);    // 获取上下文对象
        try {
            Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进
//            marshaller.marshal(object, System.out);   // 打印到控制台
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(object, baos);
            String xmlObj = new String(baos.toByteArray());         // 生成XML字符串

//            Pattern p = Pattern.compile("<?(.*)?>");
//            Matcher m = p.matcher(xmlObj);
//            StringBuilder sb = new StringBuilder();
//            while(m.find()){
//                sb.append(m.group(1));
//            }
//            xmlObj = sb.toString();

//            String[] arrStr = xmlObj.split("\"?");
//            StringBuilder sb = new StringBuilder();
//            for(int i = 1 ; i<arrStr.length ; i++){
//                sb.append(arrStr[i]);
//            }
//            String xml = sb.toString();
            xmlObj = xmlObj.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>","");
            System.out.println(xmlObj);
            return xmlObj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }


}
