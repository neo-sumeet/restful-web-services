package com.ss.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world-i18n")
    public String helloWordI18n(){
        return messageSource.getMessage("good.morning.msg",null, LocaleContextHolder.getLocale());
    }
}
