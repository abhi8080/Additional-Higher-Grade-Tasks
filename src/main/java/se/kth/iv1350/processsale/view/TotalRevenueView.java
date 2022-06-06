package se.kth.iv1350.processsale.view;


import se.kth.iv1350.processsale.model.Amount;


class TotalRevenueView extends TotalIncomeOutput{
    
    TotalRevenueView (){
   }
  
    @Override
    protected void doShowTotalIncome(Amount totalIncome)
    {
        System.out.println("------------------");
        System.out.println("Total income: " + totalIncome + " SEK" );
        System.out.println("------------------");
    }
    @Override
    protected void handleErrors(Exception e) {

        System.out.println("An error has occurred.");
    }

}







