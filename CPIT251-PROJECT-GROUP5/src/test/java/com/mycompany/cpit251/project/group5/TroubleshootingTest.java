package com.mycompany.cpit251.project.group5;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TroubleshootingTest{

    private Troubleshooting troubleshooting;

    @BeforeEach
    public void setUp() {
        troubleshooting = new Troubleshooting();
    }

    @Test
    public void testTroubleshoot_PrinterIssues() {
        try {
            troubleshooting.troubleshoot(1); 
        } catch (Exception e) {

            assertTrue("No exception should be thrown", false);
        }
    }

    @Test
    public void testTroubleshoot_PasswordReset() {
        try {
            troubleshooting.troubleshoot(2); 
        } catch (Exception e) {
            assertTrue("No exception should be thrown", false);
        }
    }

    @Test
    public void testTroubleshoot_NetworkIssues() {
        try {
            troubleshooting.troubleshoot(3); 
        } catch (Exception e) {
            assertTrue("No exception should be thrown", false);
        }
    }

    @Test
    public void testTroubleshoot_InvalidOption() {
        try {
            troubleshooting.troubleshoot(999); 
        } catch (Exception e) {
            assertTrue("No exception should be thrown for invalid input", false);
        }
    }   
}

