package BankingSystem;

import java.util.Scanner;

public class Bank {
    public String accountNo;
    public String Name;
    public String AccountType;
    public long balance;
    Scanner sc = new Scanner(System.in);

    public void openAccount(){
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Enter a account no");
        accountNo = sc.next();
        System.out.println("Enter a account type");
        AccountType = sc.next();
        System.out.println("enter Name");
        Name = sc.next();
        System.out.println("Enter a balance");
        balance = sc.nextLong();
        System.out.println("--------------------------------------------------------------------------------");


    }
    // method to display the account detail
    public void ShowAccountDetail(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Name of account Holder:"+Name);
        System.out.println("Account no:"+accountNo);
        System.out.println("AccountType:"+AccountType);
        System.out.println("Balance:"+balance);
    }

    // method to deposit money

    public void deposit(){
        long amt;
        System.out.println("Enter the amount you want to deposit");
        amt = sc.nextLong();
        balance = balance+amt;
    }

    // method to withdraw money

    public void withdraw(){
        long amt;
        System.out.println("Enter the amount you want to withdraw");
        amt = sc.nextLong();
        if(balance>=amt){
            balance = balance-amt;
            System.out.println("Balance after withdrawl "+balance);

        }else{
            System.out.println("Your balance is less than "+amt+"\tTransaction Failed||");

        }
    }

    // method to search an account number

    public boolean search(String ac_no){
        if(accountNo.equals(ac_no)){
            ShowAccountDetail();
            return true;
        }
        return false;
    }
}

