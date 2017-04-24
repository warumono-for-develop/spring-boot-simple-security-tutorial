package com.warumono.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/regist").setViewName("regist");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/crossroads").setViewName("crossroads");
		registry.addViewController("/success").setViewName("success");
		registry.addViewController("/failure").setViewName("excepted/failure");
		registry.addViewController("/denied").setViewName("excepted/denied");
		registry.addViewController("/invalid").setViewName("excepted/invalid");
		registry.addViewController("/admin").setViewName("authenticated/admin");
		registry.addViewController("/staff").setViewName("authenticated/staff");
	}
}
