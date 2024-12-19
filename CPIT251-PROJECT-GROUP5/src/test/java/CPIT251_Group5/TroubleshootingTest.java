package CPIT251_Group5;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

// Rana Alsaggaf
public class TroubleshootingTest {

    private Troubleshooting troubleshooting;

    @Before
    public void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("troubleshooting.txt"))) {
            writer.write("1:Restart printer|Check connection\n");
            writer.write("2:Reset password|Contact support\n");
        }
        troubleshooting = new Troubleshooting();
    }

    @Test
    public void testTroubleshootingSteps() {
        troubleshooting.troubleshoot(1);
        troubleshooting.troubleshoot(2);

    }

    @Test
    public void testSearchTroubleshooting() {
        troubleshooting.searchTroubleshooting("password");

    }
}
