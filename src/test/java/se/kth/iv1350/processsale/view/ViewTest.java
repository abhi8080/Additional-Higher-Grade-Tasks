package se.kth.iv1350.processsale.view;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.Printer;
import se.kth.iv1350.processsale.integration.SystemCreator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ViewTest {

    private View instance;
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
    public void testSampleExecution() throws Exception {
        SystemCreator systemCreator = new SystemCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(systemCreator, printer);
        instance = new View(contr);
        instance.sampleExecution();
        String printout = printoutBuffer.toString();
        String expectedOutputIdentifier934632865 = "934632865";
        String expectedOutputIdentifier121936821 = "121936821";
        String expectedOutputIdentifier531632821 = "531632821";
        String expectedOutputIdentifier171172841 = "171172841";
        String expectedOutputTotalCost = "Total cost is: 63 SEK.";
        String expectedOutputTotalCostAfterDiscount = "The total cost now is: 50 SEK.";
        String expectedOutputAmountPaidByCustomer = "Customer pays 100 SEK.";
        assertTrue(printout.contains(expectedOutputIdentifier934632865), "Item identifier 934632865 is not printed out.");
        assertTrue(printout.contains(expectedOutputIdentifier121936821), "Item identifier 121936821 is not printed out.");
        assertTrue(printout.contains(expectedOutputIdentifier531632821), "Item identifier 531632821 is not printed out.");
        assertTrue(printout.contains(expectedOutputIdentifier171172841), "Item identifier 171172841 is not printed out.");
        assertTrue(printout.contains(expectedOutputTotalCost), "Total cost is not printed out.");
        assertTrue(printout.contains(expectedOutputTotalCostAfterDiscount), "Total cost after discount is not printed out.");
        assertTrue(printout.contains(expectedOutputAmountPaidByCustomer), "The amount that the customer pays is not printed out.");

        /**
         * InvalidItemIdentifierException output.
         */
        /*
        String expectedOutputInvalidItemIdentifierException = "Item with identifier: 111186021 does not exist in the inventory catalog";
        assertTrue(printout.contains(expectedOutputInvalidItemIdentifierException), "Wrong printout when InvalidItemIdentifierException is thrown. ");
         */
        /**
         * OperationFailedException output.
         */
        /* String expectedOutputOperationFailedExceptionForTheUserInterface = "Scanning of item unsuccessful, please try again.";
        String expectedOutputOperationFailedExceptionForTheLog = "Could not scan the item.";
        assertTrue(printout.contains(expectedOutputOperationFailedExceptionForTheUserInterface), "Wrong printout for the user interface when OperationFailedException is thrown.");
        assertTrue(printout.contains(expectedOutputOperationFailedExceptionForTheLog), "Wrong printout for the log when OperationFailedException is thrown.");
         */
    }
}
