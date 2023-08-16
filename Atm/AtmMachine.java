package Atm;
import java.util.Scanner;
public class AtmMachine {
    static Scanner sc  = new Scanner(System.in);
    static CardHolders card = new CardHolders();

    public void Deposit(){
        System.out.println("================Deposit Amount===============");
        System.out.print("Enter a Account No-");
        long account = sc.nextLong();
        for(int i = 0;i<card.count;i++){
            if(card.Holders[i].AtmNumber==account){
                System.out.print("Enter a Amount");
                int amount = sc.nextInt();
                card.Holders[i].balance = card.Holders[i].balance+amount;
                System.out.println("-----------successfully added--------------");
                checkBalance(account);
            }
        }

    }

    public void ChangePin(){
        System.out.println("============Green pin change==========");
        System.out.print("Enter old pin-");

        int oldPin = sc.nextInt();
        int a = 0;
        for(int i=0;i<card.count;i++){
            if(oldPin==card.Holders[i].password){
                System.out.print("Enter New pin-");
                oldPin = sc.nextInt();
                System.out.print("Confirm pin");
                int newPin = sc.nextInt();
                a++;
                while(newPin!=oldPin){
                    System.out.print("Enter New pin-");
                    oldPin = sc.nextInt();
                    System.out.print("Confirm pin");
                    newPin = sc.nextInt();
                }
                card.Holders[i].password = newPin;
                System.out.println("========Password Changed=====");
                break;
            }

        }
        if(a==0){
            System.out.println("---------Please Enter valid password--------");
        }
    }

    public void Transaction(){
        System.out.println("--------------------------Transaction--------------------------------");
        System.out.print("Enter your Account no-");
        boolean Acc = false;
        boolean acc = false;
        long Account = sc.nextLong();
        for(int i =0;i<card.count;i++){
            if(card.Holders[i].AtmNumber==Account){
                Acc = true;
                System.out.print("Enter AccountNo of Receiver");
                long account = sc.nextLong();
                for(int j =0;j<card.count;j++){
                    if(account==card.Holders[j].AtmNumber){
                        acc = true;
                        System.out.print("Enter a amount");
                        int amount = sc.nextInt();
                        if(amount<=card.Holders[i].balance){

                            card.Holders[i].balance = card.Holders[i].balance-amount;
                            card.Holders[j].balance = card.Holders[j].balance+amount;
                            System.out.println("------------Transaction Successful------------");
                            checkBalance(Account);
                            break;
                        }else{
                            System.out.println("-----Invalid Amount---");
                            break;
                        }
                    }
                }
            }
        }
        if(Acc==false){
            System.out.println("--------Invalid Account-------");
        }else if(acc ==false){
            System.out.println("-------Invalid Receiver Account--------");
        }
    }
     public void checkBalance(long accountNO){
         if(CheckAccountNO(accountNO)){
             for(int i =0;i<card.count;i++){
                 if(card.Holders[i].AtmNumber==accountNO){
                     System.out.println("----------------------------------------------------------------");
                     System.out.println("Available balance--"+card.Holders[i].balance);
                     System.out.println("----------------------------------------------------------------");
                     break;
                 }
             }
         }
     }
//                               withdraw

    public void withDraw(){
        System.out.println("-------------------------WITHDRAW------------------------");

        int a =0;
        System.out.print("Enter a Account Type-");
        String AccountType = sc.next();
        System.out.print("please Enter a Account Number");
        long account  = sc.nextLong();
        System.out.println("please Enter a password");
        int password = sc.nextInt();
        for(int i=0;i<card.count;i++){
            if(card.Holders[i].AtmNumber==account&&card.Holders[i].password==password&&card.Holders[i].AccountType.equalsIgnoreCase(AccountType)){
                System.out.println("Enter a Amount");
                int amount = sc.nextInt();

                if(card.Holders[i].balance>=amount){
                    card.Holders[i].balance = card.Holders[i].balance-amount;
                    System.out.println("Successfully withdraw-"+amount);
                    checkBalance(account);
                    a++;
                    break;
                }else{
                    a++;
                    System.out.println("------------Invalid Amount------------");
                    break;
                }
            }
        }
            if(a==0){
                System.out.println("Invalid account");
            }
        }


    public boolean CheckAccountNO(long accountNo){



        for(int i =0;i<card.count;i++){
            if(card.Holders[i].AtmNumber==accountNo){
                return true;
            }
        }
        return false;
    }
    public boolean CheakPassword(int password){
        System.out.println("Please Enter Password");
        for(int i =0;i<card.count;i++){
            if(card.Holders[i].password==password){
                return true;
            }
        }
        return false;
    }


    public static void main(String [] args){
        Registration reg = new Registration();
        AtmMachine atm = new AtmMachine();

        int game = 11;

        System.out.println("if you haven't registerd please Registration");
        System.out.println("Please Registration yourself");
        card.addAccount(reg);
        reg.interfaces();


        System.out.println("--------------------Bank of India---------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("----------------------ENTER CARD----------------------------");
        while(game!=10){

            System.out.print("Enter field--");
            game = sc.nextInt();
            switch(game){
                case 5:
                   Registration regis = new Registration();
                   card.addAccount(regis);
                   break;
                case 6:
                    card.print();
                    break;
                case 0:
                    System.out.print("Enter AccountNumber-");
                    long account = sc.nextLong();
                    atm.checkBalance(account);
                    break;
                case 2:
                    atm.withDraw();
                    break;
                case 4:
                    atm.Deposit();
                    break;
                case 3:
                    atm.Transaction();
                    break;
                case 1:
                    atm.ChangePin();
                    break;
            }
            if(game==10){
                System.out.println("Thanks to coming");
            }
        }
    }
}
