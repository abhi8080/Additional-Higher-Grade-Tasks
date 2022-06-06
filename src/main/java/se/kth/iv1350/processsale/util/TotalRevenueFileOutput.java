package se.kth.iv1350.processsale.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.processsale.model.Amount;
import se.kth.iv1350.processsale.view.TotalIncomeOutput;

/**
 * This class is responsible for writing the total revenue to a file.
 */
public class TotalRevenueFileOutput extends TotalIncomeOutput {

    private PrintWriter logStream;

    /**
     * Creates a new instance.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("log-totalIncome.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG TO FILE");
            ioe.printStackTrace();
        }
    }
    @Override
    protected void doShowTotalIncome(Amount totalIncome) throws Exception {

        logStream.println("Total income: " + totalIncome + " SEK");
    }
    @Override
    protected void handleErrors(Exception e) {
       logStream.println("An error has occurred.");
    }

}
