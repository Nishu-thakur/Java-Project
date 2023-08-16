package Grocery;

import java.sql.SQLOutput;
import java.util.Scanner;

public class consumer {


    ConsumerDetail[] bougth = new ConsumerDetail[50];
     int index = 0;
     public int temp;

static Scanner sc = new Scanner(System.in);
    public boolean searchItem(String Item ,String Brand,Seller sell){
        for(int i =0;i<sell.count;i++){
            if(sell.item[i].ItemName.equalsIgnoreCase(Item)&&sell.item[i].Brand.equalsIgnoreCase(Brand)){
                return true;
            }
        }
        return false;
    }
    public void addRegistration(ConsumerDetail b){
        System.out.println("----------------------=======WELCOME SUHANA=======----------------------");
        System.out.println("----------------------=======Registration=========----------------------");
        System.out.print("Enter Name-");
        String Name = sc.next();
        System.out.print("Enter MobileNo-");
        String number = sc.next();
        System.out.println("Enter Password-");
        System.out.println("Enter a 4 digit pin");
        int pin = sc.nextInt();
        b.password = pin;
        b.MobileNo = number;
        b.Name = Name;
        if(index<50){
            bougth[index] = b;
            index++;
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
    }
      public  int cheakRegistration(String Name,int password){
        for(int i =0;i<index;i++){
            if(bougth[i].Name.equalsIgnoreCase(Name)&&bougth[i].password==password){
                return i;
            }
        }
        return 100;
      }
    public void cousume(Seller sell){

        System.out.println("--------------=====WELCOME TO SUHANA======--------------");
        System.out.println("--------------======CousumerWebsite======---------------");
        System.out.println("---------------========Login======----------------------");
        System.out.print("Enter Name-");
        String Name = sc.next();
        System.out.print("Enter pin-");
        int pin = sc.nextInt();

             temp = cheakRegistration(Name,pin);
            if(temp!=100){
            System.out.println("====================WELCOME TO SUHANA=======================");
            System.out.println("==================================================="+Name+"==");
            System.out.print("Enter a product Name-");
            String NameProduct =sc.next();
            System.out.print("Enter a brand-");
            String brand = sc.next();
            System.out.println("====================Wait searching===========================");
            if(searchItem(NameProduct,brand,sell)){
                System.out.println("=============================Exist====================================");
                System.out.println("Name\t\tBrand\t\tQuantity\t\tExipiryDate\t\tManufacturingDate\t\tprice");
                for(int i =0;i<sell.count;i++){
                    if(sell.item[i].Brand.equalsIgnoreCase(brand)&&sell.item[i].ItemName.equalsIgnoreCase(NameProduct)){
                        System.out.println(sell.item[i].ItemName+"\t\t" +
                                sell.item[i].Brand+"\t\t"+sell.item[i].Quantity+"\t\t\t"
                        +sell.item[i].ExpiryDate+"\t\t\t\t"+sell.item[i].ManufacturingDate+"\t\t\t\t"
                        +sell.item[i].price);

                        System.out.print("Enter a Quantity-");
                        int Quantity = sc.nextInt();
                        if(Quantity<=sell.item[i].Quantity){
                            sell.item[i].Quantity = sell.item[i].Quantity-Quantity;
                            bougth[temp].items=bougth[temp].items+","+NameProduct;
                            for(int j =0;j<Quantity;j++){
                                bougth[temp].TotalPrice +=sell.item[i].price;
                            }
                        }else{
                            System.out.println("Quantity not avialable");
                        }

                    }



                }
            }
        }else{
            System.out.println("==============Invalid Login=================");
            System.out.println("--------------Registered yourself-----------");
        }
    }


    public void TotalPrice(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("===============================SUHANA==================================");
        System.out.println("Name->"+bougth[temp].Name);
        System.out.println("MobileNo->"+bougth[temp].MobileNo);
        System.out.println("ItemList->"+bougth[temp].items);
        System.out.println("TotalPrice->"+bougth[temp].TotalPrice);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
    }
}
