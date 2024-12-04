/*
 * @author
 * 
 * 
 */
package com.mycompany.cpit251.project.group5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {

    private SearchService searchService;
    private Repository repository;
   
    
    @BeforeEach
    public void setUp() {
        
        repository = new Repository();
        searchService = new SearchService(repository);
    }
    @Test
    public void testSearchByKeyword_FoundResults() {
        
        List<Guide> results = searchService.searchByKeyword("Password");
        assertEquals(1, results.size(), "The search did not return the correct number of guides.");
        assertTrue(results.stream().anyMatch(guide -> guide.getTitle().equals("How to Reset Password")),
                "Expected guide not found in search results.");
    }
    @Test
    public void testSearchByKeyword_NoResults() {
       
        List<Guide> results = searchService.searchByKeyword("Bluetooth");
        assertTrue(results.isEmpty(), "The search should return no results for 'Bluetooth'.");
    }
    
    @Test
    public void testSearchByKeyword_EmptyKeyword() {
        List<Guide> results = searchService.searchByKeyword("");
        assertEquals(3, results.size(), "The search should return all guides for an empty keyword.");
    }
    
    @Test
    public void testSearchByKeyword_CaseInsensitive() {
      
        List<Guide> results = searchService.searchByKeyword("NETWORK");
        assertEquals(1, results.size(), "The search should be case-insensitive.");
        assertTrue(results.stream().anyMatch(guide -> guide.getTitle().equals("Network Connection Issues")),
                "Expected guide not found in search results.");
    }

    @Test
    public void testSearchByKeyword_MultipleMatches() {
        List<Guide> results = searchService.searchByKeyword("Issues");

        assertEquals(2, results.size(), "The search did not return the correct number of guides.");
        assertTrue(results.stream().anyMatch(guide -> guide.getTitle().equals("Troubleshooting Printer Issues")),
                "Expected guide not found in search results.");
        assertTrue(results.stream().anyMatch(guide -> guide.getTitle().equals("Network Connection Issues")),
                "Expected guide not found in search results.");
    }

    @Test
    public void testSearchByKeyword_EmptyRepository() {
        repository = new Repository() {
            @Override
            public List<Guide> getAllGuides() {
                return List.of(); 
            }
        };
        searchService = new SearchService(repository);
        List<Guide> results = searchService.searchByKeyword("Password");
        assertTrue(results.isEmpty(), "The search should return no results when the repository is empty.");
    }
}
