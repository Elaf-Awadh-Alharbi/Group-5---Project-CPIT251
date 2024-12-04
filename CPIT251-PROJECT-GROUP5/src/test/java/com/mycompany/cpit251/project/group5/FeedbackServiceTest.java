package com.mycompany.cpit251.project.group5;

//elaf 2105887

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackServiceTest {

    private FeedbackService feedbackService;
    private File tempFile;

    @BeforeEach
    public void setUp(){
        // Initialize the FeedbackService object before each test
        feedbackService = new FeedbackService();
        // Create a temporary file to simulate feedback.txt
        tempFile = new File("feedback.txt");
    }

    @Test
    public void testSubmitFeedback() throws IOException {
        // Arrange: Prepare test inputs
        int guideID = 101;
        String feedbackContent = "Great guide, very informative!";

        // Act: Call the method to submit feedback
        feedbackService.submitFeedback(guideID, feedbackContent);

        // Assert: Verify that feedback is written correctly to the file
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

