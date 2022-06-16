package se.kth.iv1350.processsale.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.model.Amount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TotalRevenueViewTest {

    private TotalRevenueView instance;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    public void setUpStreams() {
        originalSysOut = System.out;
        printoutBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printoutBuffer));
    }

    @AfterEach
    public void cleanUpStreams() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testDoShowTotalIncome() {
        instance = new TotalRevenueView();

        Amount totalIncome = new Amount(228);
        instance.doShowTotalIncome(totalIncome);

        String printout = printoutBuffer.toString();
        String expectedOutputTotalIncome = "228 SEK";
        assertTrue(printout.contains(expectedOutputTotalIncome), "Total income is not printed out.");
    }

}
