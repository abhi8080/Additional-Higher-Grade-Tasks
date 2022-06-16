package se.kth.iv1350.processsale.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.iv1350.processsale.dto.ItemDTO;
import se.kth.iv1350.processsale.model.Amount;
import se.kth.iv1350.processsale.model.Sale;

public class PrinterTest {

    private Printer instance;
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
    public void testPrintReceipt() {
        instance = new Printer();
        Sale sale = new Sale();
        sale.registerItemInSale(new ItemDTO("Orange Juice", 934632865, new Amount(10), 0.12, "1 liter"));
        sale.paymentForSale(new Amount(20));
        String receipt = sale.newReceipt();
        instance.printReceipt(receipt);
        String printout = printoutBuffer.toString();
        String expectedOutputBoughtItem = "Orange Juice";
        String expectedOutputVATForEntireSale = "VAT for entire sale: 1.2 SEK";
        String expectedOutputTotalCost = "Total cost: 11 SEK";
        String expectedOutputAmountPaid = "Amount paid: 20 SEK";
        String expectedOutputChange = "Change: 9 SEK";
        assertTrue(printout.contains(expectedOutputBoughtItem), "Bought item on the receipt is not printed out");
        assertTrue(printout.contains(expectedOutputVATForEntireSale), "VAT for entire sale on the receipt is not printed out");
        assertTrue(printout.contains(expectedOutputAmountPaid), "Amount paid on the receipt is not printed out");
        assertTrue(printout.contains(expectedOutputChange), "Change on the receipt is not printed out.");
        assertTrue(printout.contains(expectedOutputTotalCost), "Total cost on the receipt is not printed out.");

    }
}
