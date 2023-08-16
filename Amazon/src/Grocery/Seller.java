package Grocery;

import java.util.Scanner;

public class Seller {
    Items item[] = new Items[100];
    public int count = 0;
    static Scanner sc = new Scanner(System.in);

    public void addItems(Items b){
        System.out.println("----------------------------------------------------------");
        System.out.println("------------============WELCOME SUHANA============--------");
        System.out.println("----------------------------------------------------------");
        System.out.print("Enter Item Name-");
        String Name = sc.next();
        System.out.print("Enter Brand-");
        String Brand = sc.next();
        System.out.print("Enter Expiry Date-");
        int ExpiryDate = sc.nextInt();
        System.out.print("Enter ManufactureDate-");
        int ManufactureDate = sc.nextInt();
        System.out.print("Enter price-");
        int price = sc.nextInt();
        System.out.print("Enter Quantity-");
        int quantity = sc.nextInt();
        b.Quantity = quantity;
        b.Brand = Brand;
        b.ItemName = Name;
        b.ExpiryDate = ExpiryDate;
        b.ManufacturingDate = ManufactureDate;
        b.price = price;
        if(cheakItem(b)){
            System.out.println("----=====Item present Already=====-----");
            System.out.println("you can add a Quantity");
            System.out.print("Enter a Quantity-");
            int Quantity = sc.nextInt();

            if(b.Quantity+Quantity<50){
                b.Quantity = b.Quantity+Quantity;
            }else{
                System.out.print("please below 50 ");
                System.out.print("Available Quantity is-"+b.Quantity);
            }

        }
        else if(count<100){
            item[count] = b;
            count++;
            System.out.println("------------------------------------------------------------");
            System.out.println("--------------=======SuccessfullyAdded======----------------");
            System.out.println("------------------------------------------------------------");
        }else{
            System.out.print("+++++++=============No Space Available===========+++++++");
        }

    }
    public boolean cheakItem(Items b){
        for(int i =0;i<count;i++){
            if(item[i].ItemName.equalsIgnoreCase(b.ItemName)&&item[i].Brand.equalsIgnoreCase(b.Brand)){
                return true;
            }
        }
        return false;
    }


}
