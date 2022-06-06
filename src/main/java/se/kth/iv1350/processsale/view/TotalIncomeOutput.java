package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.model.Amount;
import se.kth.iv1350.processsale.model.SaleObserver;

/**
 * Shows the total income.
 */
public abstract class TotalIncomeOutput implements SaleObserver {

    private Amount totalIncome;

    protected TotalIncomeOutput() {

        totalIncome = new Amount(0);
    }

    private void calculateTotalIncome(Amount costOfSale) {
        totalIncome = new Amount(totalIncome.getAmount() + costOfSale.getAmount());
    }

    /**
     * Invoked when a new sale is made.
     *
     * @param costOfSale The cost of the sale.
     */
    @Override
    public void newSale(Amount costOfSale) {
        calculateTotalIncome(costOfSale);
        showTotalIncome();
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome(totalIncome);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void doShowTotalIncome(Amount totalIncome) throws Exception;

    protected abstract void handleErrors(Exception e);

}
