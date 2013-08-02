package com.dragos.hibernatetutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class TestSuite {

    @Autowired
    @Qualifier("userManagerImpl")
    private UserManager userManager;

    @Before
    public void setUp(){
        userManager.deleteAllUsers();
    }

    @After
    public void tearDown(){
        userManager.deleteAllUsers();
    }


    @Test
    public void testInsertAndGet() throws Exception{
        User user = new User();
        user.setUsername("johndoe");
        user.setName("John Doe");

        userManager.insertUser(user);

        System.out.println("User inserted!");

        user = userManager.getUser("johndoe");

        System.out.println("\nUser fetched by username!"
                + "\nId: " + user.getId()
                + "\nUsername: " + user.getUsername()
                + "\nName: " + user.getName());

    }
}
