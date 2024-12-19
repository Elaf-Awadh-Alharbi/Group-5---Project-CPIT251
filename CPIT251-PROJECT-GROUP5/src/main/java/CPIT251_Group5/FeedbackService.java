package CPIT251_Group5;

//Elaf Awadh Alharbi 2105887

import java.io.*;

public class FeedbackService {
    
    private final String FEEDBACK_FILE = "feedback.txt";

    public void submitFeedback(int guideID, String feedbackContent) {
        try (FileWriter writer = new FileWriter(FEEDBACK_FILE, true)) {
            writer.write("Guide ID: " + guideID + " - Feedback: " + feedbackContent + "\n");
            System.out.println("Feedback submitted successfully!");
        } catch (IOException e) {
            System.out.println("Error submitting feedback.");
            e.printStackTrace();
        }
    }

    public void viewFeedback() {
        System.out.println("\n--- Feedback Entries ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FEEDBACK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading feedback.");
            e.printStackTrace();
        }
    }

    public void searchFeedback(String keyword) {
        System.out.println("\n--- Search Results for Keyword: " + keyword + " ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FEEDBACK_FILE))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No feedback found containing the keyword.");
            }
        } catch (IOException e) {
            System.out.println("Error searching feedback.");
            e.printStackTrace();
        }
    }
}
