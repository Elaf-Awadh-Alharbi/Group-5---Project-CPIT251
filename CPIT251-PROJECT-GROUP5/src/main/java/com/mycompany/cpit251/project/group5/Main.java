package com.mycompany.cpit251.project.group5;

import java.util.Scanner;

/**
 *
 * GROUP 5
 */
public class Main {

    public static void main(String[] args) {
        Repository repository = new Repository();
        SearchService searchService = new SearchService(repository);
        FeedbackService feedbackService = new FeedbackService();
        Troubleshooting troubleshootingService = new Troubleshooting();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View All Guides");
            System.out.println("2. Search Guides");
            System.out.println("3. Submit Feedback");
            System.out.println("4. Troubleshooting");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAll Guides:");
                    repository.getAllGuides().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("\nEnter a keyword to search: ");
                    String keyword = scanner.nextLine();
                    System.out.println("\nSearch Results:");
                    searchService.searchByKeyword(keyword).forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("\nEnter Guide ID for feedback: ");
                    int guideID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter your feedback: ");
                    String feedback = scanner.nextLine();
                    feedbackService.submitFeedback(guideID, feedback);
                    break;

                case 4:
                    System.out.println("\nTroubleshooting Options:");
                    System.out.println("1. Printer Issues");
                    System.out.println("2. Password Reset");
                    System.out.println("3. Network Issues");
                    System.out.print("Choose an issue type: ");
                    int issueType = scanner.nextInt();
                    troubleshootingService.troubleshoot(issueType);
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

}
