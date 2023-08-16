package Atm;

import java.util.Scanner;

public class CardHolders {
    public Registration [] Holders = new Registration[50];
    public  int count = 0;
    Scanner sc = new Scanner(System.in);
    public void addAccount(Registration b){
        System.out.println("------------WELCOME TO BANK OF INDIA-------------------");
        System.out.print("Enter a name-");
        String name = sc.next();
        System.out.print("Enter a AccountNo-");
        long Account= sc.nextInt();
        System.out.print("Enter a password-");
        int password = sc.nextInt();
        System.out.print("Enter a Account Type-");
        String AccountType = sc.next();
        System.out.print("Enter a Balance-");
        long balance = sc.nextLong();
        b.AtmNumber = Account;
        b.CardName = name;
        b.password = password;
        b.balance = balance;
        b.AccountType = AccountType;
        if(count<50&&Compare(b)) {
            Holders[count++] = b;
            System.out.println("--------SUCCESSFULLY ADDED----------");
        }
        else if(count>=50){
            System.out.println("No Space Available");
        }
        else {
            System.out.println("Invalid Account No");
        }
        System.out.println("--------------------------------------------------------");
    }
   public void print(){
       System.out.println("-----------------Card Holder Details---------------------");
       System.out.println("SNO\t\tName\t||\tAccountNumber\t\t");
       for(int i =0;i<count;i++){
           System.out.println(i+"\t"+Holders[i].CardName+"\t\t"+Holders[i].AtmNumber+"\t\t\t");
       }
       System.out.println("---------------------------------------------------------");
       System.out.println("---------------------------------------------------------");
   }

   public boolean Compare(Registration b){
        for(int i=0;i<count;i++){
            if(Holders[i].AtmNumber==b.AtmNumber){
                return false;
            }
        }
        return true;
   }


}
