package com.mycompany.cpit251.project.group5;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

// elaf 2105887


public class FeedbackServiceTest {

    private FeedbackService feedbackService;
    private File tempFile;

    @BeforeEach
    public void setUp(){
        
        feedbackService = new FeedbackService();
        
        tempFile = new File("feedback.txt");
    }

    @Test
    public void testSubmitFeedback() throws IOException {
        
        int guideID = 101;
        String feedbackContent = "Great guide, very informative!";


        feedbackService.submitFeedback(guideID, feedbackContent);

       
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            String line = reader.readLine();
            assertNotNull(line, "File should contain feedback.");
            assertTrue(line.contains("Guide ID: " + guideID), "Feedback does not contain the correct Guide ID.");
            assertTrue(line.contains(feedbackContent), "Feedback does not contain the correct content.");
        }
    }

    @Test
    public void testSubmitFeedbackErrorHandling() {
        
        tempFile.setReadOnly();

        int guideID = 102;
        String feedbackContent = "Poor experience, needs improvement!";
        feedbackService.submitFeedback(guideID, feedbackContent);
        assertTrue(tempFile.exists(), "File should still exist even if it is read-only.");
    }

    @AfterEach
    public void tearDown() {
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }
}

