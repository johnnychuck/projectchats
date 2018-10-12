package com.moonteam.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.moonteam.project.dao")
@ComponentScan(basePackages = {"com.moonteam.project"})
public class ProjectChatApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectChatApplication.class);
    }

	public static void main(String[] args){
		// 命令行启用
		new SpringApplicationBuilder(ProjectChatApplication.class).bannerMode(Banner.Mode.OFF).run(args);
	}
	
	@Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet);
        registration.addUrlMappings("*.do");
        return registration;
    }
}
