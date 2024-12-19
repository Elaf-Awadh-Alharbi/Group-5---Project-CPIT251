package CPIT251_Group5;

// Rana Alsaggaf 2209314
import java.io.*;
import java.util.*;

public class Troubleshooting {

    private final String TROUBLESHOOTING_FILE = "troubleshooting.txt";
    private Map<Integer, List<String>> troubleshootingSteps;

    public Troubleshooting() {
        troubleshootingSteps = new HashMap<>();
        loadTroubleshootingSteps();
    }

    private void loadTroubleshootingSteps() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TROUBLESHOOTING_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                int issueType = Integer.parseInt(parts[0].trim());
                List<String> steps = Arrays.asList(parts[1].split("\\|"));
                troubleshootingSteps.put(issueType, steps);
            }
            System.out.println("Troubleshooting steps loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading troubleshooting steps.");
            e.printStackTrace();
        }
    }

    public void troubleshoot(int issueType) {
        if (troubleshootingSteps.containsKey(issueType)) {
            System.out.println("\nTroubleshooting Steps:");
            for (String step : troubleshootingSteps.get(issueType)) {
                System.out.println("- " + step.trim());
            }
        } else {
            System.out.println("Invalid issue type.");
        }
    }

    public void searchTroubleshooting(String keyword) {
        System.out.println("\n--- Search Results for Keyword: " + keyword + " ---");
        boolean found = false;
        for (List<String> steps : troubleshootingSteps.values()) {
            for (String step : steps) {
                if (step.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("- " + step.trim());
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No troubleshooting steps found containing the keyword.");
        }
    }
}
