
//by fay mohammed 2006728

package CPIT251_Group5;

import java.io.*;
import java.util.*;

public class Repository {

    private List<Guide> guides;
    private final String GUIDE_FILE = "guides.txt";

    public Repository() {
        guides = new ArrayList<>();
        loadGuides();
    }

    private void loadGuides() {
        try (BufferedReader reader = new BufferedReader(new FileReader(GUIDE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int guideID = Integer.parseInt(parts[0].trim());
                String title = parts[1].trim();
                String category = parts[2].trim();
                String status = parts[3].trim();
                guides.add(new Guide(guideID, title, category, status));
            }
            System.out.println("Guides loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading guides.");
            e.printStackTrace();
        }
    }

    public List<Guide> getAllGuides() {
        return guides;
    }

    public void addGuide(int guideID, String title, String category, String status) {
        Guide guide = new Guide(guideID, title, category, status);
        guides.add(guide);
        saveGuides();
        System.out.println("Guide added successfully!");
    }

    public void updateGuide(int guideID, String newTitle, String newCategory, String newStatus) {
        for (Guide guide : guides) {
            if (guide.getGuideID() == guideID) {
                // Update the guide's properties directly
                guides.remove(guide);
                guides.add(new Guide(guideID, newTitle, newCategory, newStatus));
                saveGuides(); // Save updated guides to the file
                System.out.println("Guide updated successfully!");
                return;
            }
        }
        System.out.println("Guide not found.");
    }

    public void searchGuides(String keyword) {
        System.out.println("\n--- Search Results for Keyword: " + keyword + " ---");
        boolean found = false;
        for (Guide guide : guides) {
            if (guide.toString().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(guide);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No guides found containing the keyword.");
        }
    }

    private void saveGuides() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(GUIDE_FILE))) {
            for (Guide guide : guides) {
                writer.write(guide.getGuideID() + ";" + guide.getTitle() + ";" + guide.getCategory() + ";" + guide.getStatus() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving guides.");
            e.printStackTrace();
        }
    }
}