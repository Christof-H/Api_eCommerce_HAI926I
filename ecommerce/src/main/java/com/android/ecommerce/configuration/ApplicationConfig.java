package com.android.ecommerce.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {
	
	@Bean(name = "errorMessageSource")
	public MessageSource errorMessageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("errormessage");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean(name = "validationMessageSource")
	public MessageSource validationMessageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("validationmessage");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}

}
