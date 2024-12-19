
package CPIT251_Group5;


import org.junit.Test;
import static org.junit.Assert.*;

public class GuideTest {
    //Hadeel Alomari 2206020 
    @Test
    public void testGuideConstructorAndGetters() {
        // Create a sample guide
        int guideID = 1;
        String title = "Test Guide";
        String category = "Category A";
        String status = "Draft";

        Guide guide = new Guide(guideID, title, category, status);

        // Validate guide properties using getters
        assertEquals(guideID, guide.getGuideID());
        assertEquals(title, guide.getTitle());
        assertEquals(category, guide.getCategory());
        assertEquals(status, guide.getStatus());
    }

    @Test
    public void testToString() {
        // Create a sample guide
        int guideID = 1;
        String title = "Test Guide";
        String category = "Category A";
        String status = "Draft";

        Guide guide = new Guide(guideID, title, category, status);

        // Check the toString representation
        String expectedOutput = "Guide ID: 1, Title: Test Guide, Category: Category A, Status: Draft";
        assertEquals(expectedOutput, guide.toString());
    }
}
