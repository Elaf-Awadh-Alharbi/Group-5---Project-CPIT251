/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cpit251.project.group5;
/*
fay mohammed
*/
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepositoryTest {

    private Repository repository;

    public RepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up the test class...");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleaning up after all tests...");
    }

    @Before
    public void setUp() {
        System.out.println("Setting up before each test...");
        repository = new Repository();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after each test...");
    }

    // Test for getAllGuides
    @Test
    public void testGetAllGuides_NotNull() {
        System.out.println("Running test: testGetAllGuides_NotNull...");
        List<Guide> result = repository.getAllGuides();
        assertNotNull("The list of guides should not be null", result);
    }

    @Test
    public void testGetAllGuides_Size() {
        System.out.println("Running test: testGetAllGuides_Size...");
        List<Guide> result = repository.getAllGuides();
        assertEquals("The number of guides should match the initialized size", 3, result.size());
    }

    @Test
    public void testGetAllGuides_FirstGuideID() {
        System.out.println("Running test: testGetAllGuides_FirstGuideID...");
        List<Guide> result = repository.getAllGuides();
        assertEquals("First guide ID should match", 1, result.get(0).getGuideID());
    }

    @Test
    public void testGetAllGuides_FirstGuideTitle() {
        System.out.println("Running test: testGetAllGuides_FirstGuideTitle...");
        List<Guide> result = repository.getAllGuides();
        assertEquals("First guide title should match", "Troubleshooting Printer Issues", result.get(0).getTitle());
    }

    @Test
    public void testGetAllGuides_FirstGuideCategory() {
        System.out.println("Running test: testGetAllGuides_FirstGuideCategory...");
        List<Guide> result = repository.getAllGuides();
        assertEquals("First guide category should match", "Hardware", result.get(0).getCategory());
    }

    @Test
    public void testGetAllGuides_FirstGuideStatus() {
        System.out.println("Running test: testGetAllGuides_FirstGuideStatus...");
        List<Guide> result = repository.getAllGuides();
        assertEquals("First guide status should match", "Pending", result.get(0).getStatus());
    }

    // Tests for getGuideByID
    @Test
    public void testGetGuideByID_Existing_NotNull() {
        System.out.println("Running test: testGetGuideByID_Existing_NotNull...");
        int guideID = 2;
        Guide result = repository.getGuideByID(guideID);
        assertNotNull("Guide with ID 2 should exist", result);
    }

    @Test
    public void testGetGuideByID_Existing_IDMatch() {
        System.out.println("Running test: testGetGuideByID_Existing_IDMatch...");
        int guideID = 2;
        Guide result = repository.getGuideByID(guideID);
        assertEquals("Guide ID should match", 2, result.getGuideID());
    }

    @Test
    public void testGetGuideByID_Existing_TitleMatch() {
        System.out.println("Running test: testGetGuideByID_Existing_TitleMatch...");
        int guideID = 2;
        Guide result = repository.getGuideByID(guideID);
        assertEquals("Guide title should match", "How to Reset Password", result.getTitle());
    }

    @Test
    public void testGetGuideByID_Existing_CategoryMatch() {
        System.out.println("Running test: testGetGuideByID_Existing_CategoryMatch...");
        int guideID = 2;
        Guide result = repository.getGuideByID(guideID);
        assertEquals("Guide category should match", "Account Management", result.getCategory());
    }

    @Test
    public void testGetGuideByID_Existing_StatusMatch() {
        System.out.println("Running test: testGetGuideByID_Existing_StatusMatch...");
        int guideID = 2;
        Guide result = repository.getGuideByID(guideID);
        assertEquals("Guide status should match", "Approved", result.getStatus());
    }

    @Test
    public void testGetGuideByID_NonExisting_Null() {
        System.out.println("Running test: testGetGuideByID_NonExisting_Null...");
        int guideID = 99;
        Guide result = repository.getGuideByID(guideID);
        assertNull("Guide with ID 99 should not exist", result);
    }
}