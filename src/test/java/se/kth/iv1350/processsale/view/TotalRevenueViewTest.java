package se.kth.iv1350.processsale.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.processsale.model.Amount;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TotalRevenueViewTest {
   
    private TotalRevenueView instance;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @Test
    public void testDoShowTotalIncome() {
        instance  = new TotalRevenueView();
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        
        Amount totalIncome = new Amount(228);
       instance.doShowTotalIncome(totalIncome);
      
       String printout = printoutBuffer.toString();
       String expectedOutputTotalIncome = "228 SEK";
       assertTrue(printout.contains(expectedOutputTotalIncome), "Total income is not printed out.");
    }
    
}
