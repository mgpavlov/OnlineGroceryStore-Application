package org.softuni.onlinegrocery.configuration;

import org.softuni.onlinegrocery.web.interceptors.FaviconInterceptor;

import org.softuni.onlinegrocery.web.interceptors.GreetingInterceptor;
import org.softuni.onlinegrocery.web.interceptors.TitleInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final TitleInterceptor titleInterceptor;
    private final FaviconInterceptor faviconInterceptor;
    private final GreetingInterceptor greetingInterceptor;

    @Autowired
    public WebMvcConfiguration(TitleInterceptor titleInterceptor, FaviconInterceptor faviconInterceptor, GreetingInterceptor greetingInterceptor) {
        this.titleInterceptor = titleInterceptor;
        this.faviconInterceptor = faviconInterceptor;
        this.greetingInterceptor = greetingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.titleInterceptor);
        registry.addInterceptor(this.faviconInterceptor);
        registry.addInterceptor(this.greetingInterceptor);
    }
}
