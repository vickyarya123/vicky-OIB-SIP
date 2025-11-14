
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// static amount;
public class Atm {
    static float amount = 10000;
    static int PIN;
    static List<String> TransactionHistory = new ArrayList<>();

    // add transaction history to array list 
    public static void addTransaction(String type, float useramount) {
        Date date = new Date();
        String transection = type + ": " + useramount + "    | date - " + date;
        TransactionHistory.add(transection);

    }

    // show transaction history 
    public static void showTransection() {
        if (TransactionHistory.isEmpty()) {
            System.out.println("NO Transaction to display. ");
        } else {
            System.out.println("Transaction to display :");
            for (String transaction : TransactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // access Granted
    public static boolean accessGranted() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your 4-digit PIN: ");

        PIN = sc.nextInt();

        if (PIN < 1000 || PIN > 9999) {
            System.out.println("sorry invalid PIN");
            System.out.println();

            return false;

        } else {
            System.out.println("access granted");
            System.out.println();
            return true;
        }
    }

    // show Options;
    public static void showOption() {
        Scanner sc = new Scanner(System.in);

        System.out.println("  ----------------------------------------------   ");
        System.out.println("    1: withdraw            2: deposite");
        // System.out.println();
        System.out.println("    3: check balance       4: change pin");
        // System.out.println();
        System.out.println("    5: TransferMoney       6: mini-statement");
        // System.out.println();
        System.out.println("                 7: exit(cencle)");
        System.out.println();
        System.out.print("Choose the opertaion you want to perform:");

    }

    // checkBalance ;
    public static void checkBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter you pin : ");
        int userPIN = sc.nextInt();
        if (userPIN != PIN) {
            System.out.println("invalid PIN");
        } else {
            System.out.println("avalible balance is : " + amount);
        }
        // this amount=amount;
        // return amount;
    }

    // deposite amount ;
    public static void deposite() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter money to be deposited :");
        float useramount = sc.nextFloat();
        if (useramount <= 0) {
            System.out.println("Enter amount more than 0");
        } else {

            System.out.print("enter you pin : ");
            int userPIN = sc.nextInt();
            if (userPIN != PIN) {
                System.out.println("invalid PIN");
            } else {
                amount = amount + useramount;
                // System.out.println("deposite successfull");
                System.out.println("your money has been successfully depsited");
                addTransaction("Deposit  ", useramount);
                // System.out.println("avilable balance is " + checkBalance());
            }
        }
    }

    // withdraw amount ;
    public static void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter money to be withdraw : ");
        float useramount = sc.nextFloat();
        if (useramount <= 0) {
            System.out.println("Enter amount more than 0");
        } else {
            System.out.print("enter you pin : ");
            int userPIN = sc.nextInt();
            if (userPIN != PIN) {
                System.out.println("invalid PIN");
            } else {
                if (amount < useramount) {
                    System.out.println("insufficient balance in your account");
                } else {
                    amount = amount - useramount;
                    System.out.println("withdraw successful");
                    System.out.println("please collect your money");
                    addTransaction("withdraw  ", useramount);
                }
            }
        }
    }

    // change ATMPIN ;
    public static void chagnePIN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your old PIN : ");
        int oldPIN = sc.nextInt();
        System.out.print("Enter your new PIN : ");
        int newPIN = sc.nextInt();
        System.out.println();
        if (PIN != oldPIN) {
            System.out.println("SORRY oldPIN Incorect");
            cencle();
        }
        PIN = newPIN;
        System.out.println("successfull change your PIN");
    }

    // cencle program  or exit program;
    public static void cencle() {
        System.out.println();
        System.out.println("           EXIT SUCCESSFULL");
        System.out.println();
        System.exit(0);
    }

    // transfermoney
    public static void TransferMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        // System.out.println("Enter account number where you transfer");
        System.out.println("Enter account holder name where you transfer");
        System.out.print("Enter here : ");
        String account_name = sc.nextLine();

        System.out.print("Enter amount : ");
        float useramount = sc.nextFloat();
        if (useramount <= 0) {
            System.out.println("Enter amount more than 0 rupies");
        } else {
            System.out.print("enter you pin : ");
            int userPIN = sc.nextInt();
            if (userPIN != PIN) {
                System.out.println("invalid PIN");
            } else {
                if (amount < useramount) {
                    System.out.println("insufficient balance in your account");
                } else {
                    amount = amount - useramount;
                    System.out.println();
                    System.out.println("Transfer successful ");
                    String accountDetail = "transfer to " + account_name;
                    addTransaction(accountDetail, useramount);
                }

            }
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("     ----WELCOME TO ATM OF VICKY ARYA-----");
        System.out.println();
        try {

            if (accessGranted()) {

                while (true) {

                    showOption();

                    int value = sc.nextInt();

                    switch (value) {

                        case 1:
                            withdraw();
                            break;

                        case 2:
                            deposite();
                            break;
                        case 3:
                            checkBalance();
                            break;
                        case 4:
                            chagnePIN();
                            break;
                        case 5:
                            TransferMoney();
                            break;
                        case 6:
                            showTransection();
                            break;
                        case 7:
                            cencle();
                            break;
                        default:
                            System.out.println("wrong choose");
                    }
                    System.out.println();
                }
            }
           
        } catch (Exception ex) {
            System.out.println();
            System.out.println("Error:  " + ex.getMessage());
        }
    }
}
