
package CPIT251_Group5;



import org.junit.Test;
import java.io.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
//Elaf Awadh Alharbi 
public class FeedbackServiceTest {
    
    @Test
    public void testSubmitFeedback() throws IOException {
        FeedbackService feedbackService = new FeedbackService();
        String testFeedback = "Test feedback content.";
        feedbackService.submitFeedback(1, testFeedback);

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String lastLine = null, line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            assertNotNull(lastLine);
            assertTrue(lastLine.contains(testFeedback));
        }
    }

    @Test
    public void testSearchFeedback() {
        FeedbackService feedbackService = new FeedbackService();
        String keyword = "test";
        feedbackService.searchFeedback(keyword);

        // Manually check the console for the presence of feedback containing "test".
    }
}