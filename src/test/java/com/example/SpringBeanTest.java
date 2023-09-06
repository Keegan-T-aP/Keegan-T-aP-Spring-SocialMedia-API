package com.example;

import com.example.controller.SocialMediaController;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import com.example.service.AccountService;
import com.example.service.MessageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class SpringBeanTest {
    ApplicationContext applicationContext;

    /**
     * Retrieve the applicationContext for your app by starting it up.
     */
    @BeforeEach
    public void setUp(){
        String[] args = new String[] {};
        applicationContext = SpringApplication.run(SocialMediaApp.class, args);
    }
    /**
     * Reset the applicationContext after each test.
     */
    @AfterEach
    public void tearDown(){
        SpringApplication.exit(applicationContext);
    }

    /**
     * Retrieve the SocialMediaController as a bean.
     * The SocialMediaController must be a bean in order for this test to pass.
     */
    @Test
    public void getSocialMediaControllerBean(){
        SocialMediaController bean = applicationContext.getBean(SocialMediaController.class);
        Assertions.assertNotNull(bean);
    }
    /**
     * Retrieve the AccountService as a bean.
     * The AccountService must be a bean in order for this test to pass.
     */
    @Test
    public void getAccountServiceBean(){
        AccountService bean = applicationContext.getBean(AccountService.class);
        Assertions.assertNotNull(bean);
    }
    /**
     * Retrieve the MessageService as a bean.
     * The MessageService must be a bean in order for this test to pass.
     */
    @Test
    public void getMessageServiceBean(){
        MessageService bean = applicationContext.getBean(MessageService.class);
        Assertions.assertNotNull(bean);
    }
    /**
     * Retrieve the AccountRepository as a bean.
     * The AccountRepository must be a bean in order for this test to pass.
     */
    @Test
    public void getAccountRepositoryBean(){
        AccountRepository bean = applicationContext.getBean(AccountRepository.class);
        Assertions.assertNotNull(bean);
    }
    /**
     * Retrieve the MessageRepository as a bean.
     * The MessageRepository must be a bean in order for this test to pass.
     */
    @Test
    public void getMessageRepositoryBean(){
        MessageRepository bean = applicationContext.getBean(MessageRepository.class);
        Assertions.assertNotNull(bean);
    }
}