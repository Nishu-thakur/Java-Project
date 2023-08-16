package BankingSystem;

import java.util.Scanner;

public class BankingApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bank [] c = new Bank[n];
        for(int i = 0;i<c.length;i++){
            c[i] = new Bank();
            c[i].openAccount();
        }
//     loop runs until number 4 is ot pressed to exit

        int ch ;
        do{
            System.out.println("\n ***Banking System Application***");
            System.out.println("1 Display all account detail\n 2 Search By AccountNumber \n 3.Deposit the amount \n 4 withdraw the amount \n 5 Exit");
            System.out.println("Enter your Choice");
            ch = sc.nextInt();

            switch (ch){
                case 1:
                    for(int i = 0;i<c.length;i++){
                        c[i].ShowAccountDetail();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account no .you want to Search");
                    String ac_no = sc.next();
                    boolean found = false;
                    for(int i =0;i<c.length;i++){
                        found = c[i].search(ac_no);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account does't !!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account No:");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0;i<c.length;i++){
                        found = c[i].search(ac_no);
                        if(found){
                            c[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account Does'nt Exit");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account No:");
                    ac_no = sc.next();
                    found = false;
                    for(int i =0;i<c.length;i++){
                        found = c[i].search(ac_no);
                        if(found){
                            c[i].withdraw();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed: Account does't exit!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        }while(ch!=5);
    }
}
