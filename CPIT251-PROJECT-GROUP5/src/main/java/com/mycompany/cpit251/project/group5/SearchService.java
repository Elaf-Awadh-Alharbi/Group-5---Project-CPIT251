
package com.mycompany.cpit251.project.group5;

/**
 *
 * @author Hadeel Alomari 2206020
 */
import java.util.ArrayList;
import java.util.List;

public class SearchService {
    private Repository repository;

    public SearchService(Repository repository) {
        this.repository = repository;
    }

  public List<Guide> searchByKeyword(String keyword) {
    List<Guide> results = new ArrayList<>();
      for (Guide guide : repository.getAllGuides()) {
    
    if (guide.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        results.add(guide);
    }
}
    return results;
}

}
