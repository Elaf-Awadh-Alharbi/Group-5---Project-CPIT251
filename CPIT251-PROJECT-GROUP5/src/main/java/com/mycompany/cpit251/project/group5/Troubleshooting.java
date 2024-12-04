/**
 * @author Sereen Abdullah 2205753
 * 
 * 
 */
 


package com.mycompany.cpit251.project.group5;

import java.util.Scanner;

public class Troubleshooting {
    public void troubleshoot(int issueType) {
        switch (issueType) {
            case 1: 
                System.out.println("\nPrinter Troubleshooting Steps:");
                System.out.println("Step 1: Check the printer cables and power connection.");
                System.out.println("Step 2: Ensure the printer is turned on and connected to the network.");
                System.out.println("Step 3: Verify the printer's drivers are installed and up-to-date.");
                System.out.println("Step 4: Check the printer queue for pending or stuck print jobs.");
                System.out.println("Step 5: Restart the printer and computer if necessary.");
                System.out.println("If the problem persists, contact technical support or refer to the printer's manual.");
                break;

            case 2: 
                System.out.println("\nPassword Reset Steps:");
                System.out.println("Step 1: Open the password reset page on your system.");
                System.out.println("Step 2: Enter your employee ID and associated credentials.");
                System.out.println("Step 3: Follow the prompts to verify your identity (e.g., OTP or email verification).");
                System.out.println("Step 4: Create a new password following the security guidelines.");
                System.out.println("Step 5: Save the changes and test the new password by logging in.");
                System.out.println("If you encounter any issues, contact IT support for assistance.");
                break;

            case 3: 
                System.out.println("\nNetwork Troubleshooting Steps:");
                System.out.println("Step 1: Ensure the network cable is securely connected to your computer.");
                System.out.println("Step 2: Check if the network icon on the taskbar indicates connectivity.");
                System.out.println("Step 3: Restart the router or modem if necessary.");
                System.out.println("Step 4: Run the network diagnostic tool (available in your system's settings).");
                System.out.println("Step 5: Verify your network settings, such as IP address and DNS.");
                System.out.println("If the issue persists, contact your network administrator or ISP.");
                break;

            default:
                System.out.println("Invalid issue type. Please select a valid option.");
        }
    }
}