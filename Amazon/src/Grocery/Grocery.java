package Grocery;

import java.util.Scanner;

public class Grocery {
    public static void instruction(){
        System.out.println("Consumer Registration---Enter 0");
        System.out.println("Bought things-----------Enter 1");
        System.out.println("Quit--------------------Enter 5");
    }
    public static void main(String[] args) {
        Seller sell = new Seller();
        consumer con = new consumer();
        int game = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Seller-0                                      Consumer-1");
        System.out.println("-------------------Quit-2------------------------------");
        while(game!=2){
            System.out.println("--------------------===Welcome===-----------------");
            System.out.println("Enter field ");

            game = sc.nextInt();
            switch(game){
                case 0:
                    Items b = new Items();
                   sell.addItems(b);
                   break;
                case 1:
                    instruction();

                    int field = 11;
                    while(field!=5){
                        System.out.print("Enter a fields-");
                         field = sc.nextInt();
                        switch(field){
                            case 0:
                                ConsumerDetail consume = new ConsumerDetail();
                                con.addRegistration(consume);
                                break;
                            case 1:
                                con.cousume(sell);


                        }
                        if(field==5){
                            con.TotalPrice();
                        }
                    }

            }
        }
    }
}
