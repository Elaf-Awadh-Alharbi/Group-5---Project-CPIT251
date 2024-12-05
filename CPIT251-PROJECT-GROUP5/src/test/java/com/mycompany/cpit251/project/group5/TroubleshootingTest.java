package com.mycompany.cpit251.project.group5;

//elaf 2105887

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TroubleshootingTest {

    private Troubleshooting troubleshooting;

    @Before
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
