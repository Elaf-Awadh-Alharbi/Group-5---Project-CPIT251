/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cpit251.project.group5;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class GuideTest {
 public GuideTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Running setup for the test class...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleaning up after all tests...");
    }

    @Before
    public void setUp() {
        System.out.println("Setting up before each test...");
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after each test...");
    }

    
    @Test
    public void testGetGuideID() {
        System.out.println("Running test for getGuideID...");
        Guide instance = new Guide(1, "Java Guide", "Programming", "Available");
        int expResult = 1;
        int result = instance.getGuideID();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetTitle() {
        System.out.println("Running test for getTitle...");
        Guide instance = new Guide(2, "Python Guide", "Programming", "Archived");
        String expResult = "Python Guide";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testGetCategory() {
        System.out.println("Running test for getCategory...");
        Guide instance = new Guide(3, "Spring Boot Guide", "Framework", "Available");
        String expResult = "Framework";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetStatus() {
        System.out.println("Running test for getStatus...");
        Guide instance = new Guide(4, "Docker Guide", "DevOps", "Deprecated");
        String expResult = "Deprecated";
        String result = instance.getStatus();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testToString() {
        System.out.println("Running test for toString...");
        Guide instance = new Guide(5, "Kubernetes Guide", "Containerization", "Available");
        String expResult = "Guide ID: 5, Title: Kubernetes Guide, Category: Containerization, Status: Available";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}

