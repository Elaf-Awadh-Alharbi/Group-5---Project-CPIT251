
package CPIT251_Group5;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// made by Fay mohammed
public class RepositoryTest {

    private Repository repository;

    @Before
    public void setUp() {
        repository = new Repository();
        repository.addGuide(1, "Test Guide 1", "Category A", "Draft");
        repository.addGuide(2, "Test Guide 2", "Category B", "Published");
    }

    @Test
    public void testAddGuide() {
        int initialSize = repository.getAllGuides().size();
        repository.addGuide(3, "New Guide", "Category C", "Draft");
        assertEquals(initialSize + 1, repository.getAllGuides().size());
    }

    @Test
    public void testUpdateGuide() {
        
        repository.addGuide(1, "Sample Guide", "Category A", "Draft");

      
        repository.updateGuide(1, "Updated Guide", "Category Z", "Final");

       
        Guide updatedGuide = repository.getAllGuides()
                .stream()
                .filter(g -> g.getGuideID() == 1)
                .findFirst()
                .orElse(null);

        
        assertNotNull(updatedGuide);
        assertEquals("Updated Guide", updatedGuide.getTitle());
        assertEquals("Category Z", updatedGuide.getCategory());
        assertEquals("Final", updatedGuide.getStatus());
    }

    @Test
    public void testSearchGuides() {
        repository.searchGuides("Test");

        
    }
}