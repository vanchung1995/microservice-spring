package com.chungvv3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/i18n")
public class MessageI18nController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String helloWorld() {
        Locale locale = LocaleContextHolder.getLocale();
        String helloMsg = messageSource.getMessage("morning.message", null, "Default Message", locale);
        return helloMsg;
    }
}
