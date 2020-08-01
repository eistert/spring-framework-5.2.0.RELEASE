package com.imooc;

import com.imooc.controller.WelcomeController;
import com.imooc.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ComponentScan("com.imooc")
public class Entrance {

	// xml
	public static void main1(String[] args) {
		System.out.println("Hello World!");

		// 获取bean 容器实例
		String xmlPath = "//Users/eistert/Desktop/eistert/Java_self_developed_framework/spring-framework-5.2.0.RELEASE/springdemo/src/main/resources/spring/spring-config.xml";
		FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(xmlPath);

		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");

		welcomeService.sayHello("强大的spring框架");

	}

	// annotation
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}

//		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeServiceImpl");
//		welcomeService.sayHello("强大的spring框架");

		WelcomeController welcomeController = (WelcomeController) applicationContext.getBean("welcomeController");
		welcomeController.handleRequest();
	}
}
