package ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("$ ###,##0.00");

    private double checkingBalance = 0;
    private double savingBalance = 0;
    private int Accountnumber;
    private int PIN;

    public int setAccountnumber( int Accountnumber){
        this.Accountnumber = Accountnumber;
        return Accountnumber;
    }

    public int getAccountnumber(){
        return Accountnumber;
    }

    public int setPIN( int PIN){
        this.PIN = PIN;
        return PIN;
    }

    public int getPIN(){
        return PIN;
    }

    public double getCheckingBalance() {
        return checkingBalance;      
    }
        
    public double getSavingBalance() {
        return savingBalance;
    }

    public double calCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCheckingWithdrawAmt(){
        System.out.println("Current Balance in Checking Account: " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount to be Withdrawn: ");

        double amount = menuInput.nextDouble();

        if(checkingBalance - amount >= 0){
            calCheckingWithdraw(amount);
            System.out.println("New Balance of Checking Account: " + moneyFormat.format(checkingBalance));
            } else{
                System.out.println("Insufficient Balance");
            }

    }

    public void getSavingWithdrawAmt(){
        System.out.println("Current Balance in Saving Account: " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount to be Withdrawn: ");

        double amount = menuInput.nextDouble();

        if(savingBalance - amount >= 0){
            calSavingWithdraw(amount);
            System.out.println("New Balance of Saving Account: " + moneyFormat.format(savingBalance));
            } else{
                System.out.println("Insufficient Balance");
            }
    }

    public void getCheckingDepositAmt(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to Deposit from Checking Account: ");
        double amount = menuInput.nextDouble();
        if ((checkingBalance + amount) >= 0) {
            calCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient Balance." + "\n");
        }
    }

    public void getSavingDepositAmt(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to Deposit from Saving Account: ");
        double amount = menuInput.nextDouble();
        if ((savingBalance + amount) >= 0) {
            calSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient Balance." + "\n");
        }
    }



    
    
}
