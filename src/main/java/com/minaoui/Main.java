package com.minaoui;

import com.minaoui.config.PersistenceJPAConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("List of beans:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
