package com.example;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class SpringDataTest {
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
     *
     */
    public void accountIsEntityTest(){

    }

    /**
     *
     */
    public void messageIsEntityTest(){

    }
    /**
     * After retrieving the AccountRepository bean, it should exhibit the functionality of a JPARepository
     * for an "Account" entity.
     */
    @Test
    public void accountRepositoryIsRepositoryTest() throws ReflectiveOperationException {
        AccountRepository repository = applicationContext.getBean(AccountRepository.class);
        Method[] repositoryMethods = repository.getClass().getMethods();
        Method saveMethod = null;
        Method findAllMethod = null;
        String expectedUsername = "ted";
        String expectedPassword = "password123";
        Account testAccount = new Account(expectedUsername, expectedPassword);
        for(Method m : repositoryMethods){
            System.out.println(m.getName());
            if(m.getName().equals("save") && m.getParameterCount() == 1){
                saveMethod = m;
            }else if(m.getName().equals("findAll") && m.getParameterCount() == 0){
                findAllMethod = m;
            }
        }
        if(saveMethod == null || findAllMethod == null){
            Assertions.fail("The save / findAll methods were not found. Ensure that AccountRepository properly " +
                    "extends JPARepository.");
        }
        List<Account> accountList1 = (List<Account>) findAllMethod.invoke(repository, new Object[]{});
        System.out.println(accountList1);
        Assertions.assertTrue(accountList1.size() == 4, "There should be no accounts in the " +
                "JPARepository on startup.");
        Account actualAccount = (Account) saveMethod.invoke(repository, testAccount);
        Assertions.assertEquals(actualAccount.getUsername(), expectedUsername);
        List<Account> accountList2 = (List<Account>) findAllMethod.invoke(repository, new Object[]{});
        Assertions.assertTrue(accountList2.size() > 4, "The account should be addable to the " +
                "JPARepository.");
    }
    /**
     * After retrieving the MessageRepository bean, it should exhibit the functionality of a JPARepository
     * for a "Message" entity.
     */
    @Test
    public void messageRepositoryIsRepositoryTest() throws ReflectiveOperationException{
        MessageRepository repository = applicationContext.getBean(MessageRepository.class);
        Method[] repositoryMethods = repository.getClass().getMethods();
        Method saveMethod = null;
        Method findAllMethod = null;
        String expectedUsername = "ted";
        String expectedPassword = "password123";
        Account testAccount = new Account(expectedUsername, expectedPassword);
        for(Method m : repositoryMethods){
            System.out.println(m.getName());
            if(m.getName().equals("save") && m.getParameterCount() == 1){
                saveMethod = m;
            }else if(m.getName().equals("findAll") && m.getParameterCount() == 0){
                findAllMethod = m;
            }
        }
        if(saveMethod == null || findAllMethod == null){
            Assertions.fail("The save / findAll methods were not found. Ensure that AccountRepository properly " +
                    "extends JPARepository.");
        }
        List<Account> accountList1 = (List<Account>) findAllMethod.invoke(repository, new Object[]{});
        System.out.println(accountList1);
        Assertions.assertTrue(accountList1.size() == 4, "There should be no accounts in the " +
                "JPARepository on startup.");
        Account actualAccount = (Account) saveMethod.invoke(repository, testAccount);
        Assertions.assertEquals(actualAccount.getUsername(), expectedUsername);
        List<Account> accountList2 = (List<Account>) findAllMethod.invoke(repository, new Object[]{});
        Assertions.assertTrue(accountList2.size() > 4, "The account should be addable to the " +
                "JPARepository.");
    }

}
