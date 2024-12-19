package CPIT251_Group5;
import java.util.Scanner;

/**
 *
 * @author rnoo
 */
public class Helper1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Repository repository = new Repository();
        FeedbackService feedbackService = new FeedbackService();
        Troubleshooting troubleshootingService = new Troubleshooting();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View All Guides");
            System.out.println("2. Add Guide");
            System.out.println("3. Update Guide");
            System.out.println("4. Submit Feedback");
            System.out.println("5. View Feedback");
            System.out.println("6. Troubleshooting");
            System.out.println("7. Search Feedback");
            System.out.println("8. Search Guides");
            System.out.println("9. Search Troubleshooting");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    repository.getAllGuides().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter Guide ID: ");
                    int guideID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    repository.addGuide(guideID, title, category, status);
                    break;
                case 3:
                    System.out.print("Enter Guide ID to Update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter New Status: ");
                    String newStatus = scanner.nextLine();
                    repository.updateGuide(updateID, newTitle, newCategory, newStatus);
                    break;
                case 4:
                    System.out.print("Enter Guide ID for Feedback: ");
                    int feedbackID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Feedback: ");
                    String feedback = scanner.nextLine();
                    feedbackService.submitFeedback(feedbackID, feedback);
                    break;
                case 5:
                    feedbackService.viewFeedback();
                    break;
                case 6:
                    System.out.print("Enter Issue Type (1: Printer, 2: Password, 3: Network): ");
                    int issueType = scanner.nextInt();
                    troubleshootingService.troubleshoot(issueType);
                    break;
                case 7:
                    System.out.print("Enter keyword to search in feedback: ");
                    String feedbackKeyword = scanner.nextLine();
                    feedbackService.searchFeedback(feedbackKeyword);
                    break;
                case 8:
                    System.out.print("Enter keyword to search in guides: ");
                    String guideKeyword = scanner.nextLine();
                    repository.searchGuides(guideKeyword);
                    break;
                case 9:
                    System.out.print("Enter keyword to search in troubleshooting: ");
                    String troubleshootingKeyword = scanner.nextLine();
                    troubleshootingService.searchTroubleshooting(troubleshootingKeyword);
                    break;
                case 10:
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