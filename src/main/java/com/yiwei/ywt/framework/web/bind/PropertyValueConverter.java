package com.yiwei.ywt.framework.web.bind;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * 属性值转换器. <p />
 *
 * Created by czy on 2016/3/3.
 */
public class PropertyValueConverter implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder webDataBinder) {

    }

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // 日期转换
        binder.registerCustomEditor(Date.class, new MultipleDateEditor("yyyy-MM-dd HH:mm:ss", new String[] { "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm", "yyyy-MM-dd" }, true));
    }
}
