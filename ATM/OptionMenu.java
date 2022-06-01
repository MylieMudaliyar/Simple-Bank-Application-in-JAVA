package ATM;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;


public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("$ ###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
    
        do{
            try{
                data.put(8923119, 289382);
                data.put(7178391, 746719);
                data.put(1283042, 430981);
                
                System.out.println("\n" +"Welcome to MYLX BANK"+"\n");
                System.out.println("Enter Account Number");
                setAccountnumber(menuInput.nextInt());

                System.out.println("Enter PIN ");
                setPIN(menuInput.nextInt());
            }
            catch (Exception e){
                System.out.println("\n" + "Invalid" + "\n");
                x=2;
            }

        
            int cn = getAccountnumber();
            int pn = getPIN();
            if(data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            }else
            System.out.println("Wrong Account Number or PIN");

        } while (x==1);
    }

    public void getAccountType(){
        System.out.println("\n"+"Select Account Type"+"\n");
        System.out.println("1- Checking Account");
        System.out.println("2- Savings Account");
        System.out.println("3- Exit");

        System.out.print("Choice: ");

        int OptionSelect = menuInput.nextInt();

        switch(OptionSelect) {
            case 1:
                getCheckingAcc();
                break;

            case 2:
                getSavingsAcc();
                break;

            case 3:
                System.out.println("Thank you for choosing MYLX BANK." + "\n" + " Visit Again" + "\n");
                break;

            default:
                System.out.println("Choose a Valid Option");
                getAccountType();
        }
    }


    public void getCheckingAcc(){
        System.out.println("\n" + "Select Option:" + "\n");
        System.out.println("1- View Balance");
        System.out.println("2- Withdraw Funds");
        System.out.println("3- Deposit Funds");
        System.out.println("4- Exit");

        System.out.print("Choice: ");

        int OptionSelect = menuInput.nextInt();

        switch(OptionSelect) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getCheckingAcc();
                break;
            
            case 2:
                getCheckingWithdrawAmt();
                getCheckingAcc();
                break;

            case 3:
                getCheckingDepositAmt();
                getCheckingAcc();
                break;
            
            case 4:
                getAccountType();
                break;

            default:
                System.out.println("Choose a Valid Option");
                getCheckingAcc();
                
        }
    }

    public void getSavingsAcc(){
        System.out.println("\n" + "Select Option:" + "\n");
        System.out.println("1- View Balance");
        System.out.println("2- Withdraw Funds");
        System.out.println("3- Deposit Funds");
        System.out.println("4- Exit");

        System.out.print("Choice: ");

        int OptionSelect = menuInput.nextInt();

        switch(OptionSelect) {
            case 1:
            System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingBalance()));
            getSavingsAcc();
            break;
        
        case 2:
            getSavingWithdrawAmt();
            getSavingsAcc();
            break;

        case 3:
            getSavingDepositAmt();
            getSavingsAcc();
            break;
        
        case 4:
            getAccountType();
            break;

        default:
            System.out.println("Choose a Valid Option");
            getSavingsAcc();
            
        }
    }

}   