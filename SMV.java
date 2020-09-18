package izza;

import java.io.IOException;
import java.util.Scanner;

public class SMV {

    static hashMap hm;
    static Cart c;
    static coin c1;
    static transaction tr;

    public static void main(String[] args) throws IOException {
        hm = new hashMap();
        c = new Cart(8);
        c1 = new coin(0);
        tr = new transaction();
        hm.put("Pikapoo", 20, 1.5);
        hm.put("Hell and Sky", 20, 2.0);
        hm.put("SkyJuicee", 20, 1.0);
        hm.put("Popci", 20, 1.5);
        hm.put("MAILO", 20, 2.5);
        hm.put("99plus", 20, 1.5);
        hm.put("Sepright", 20, 1.5);
        hm.put("LeegalCaffeine", 20, 2.0);
        user();
    }

    public static void user() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Which one are you?"
                + "\n1) Vendor\n2) Buyer\nAnswer:");

        String input = s.nextLine();

        switch (input) {
            case "1":
                VendormainPage();
                break;
            case "2":
                BuyermainPage();
                break;
            default:
                System.out.println("Wrong entry, try again");
                user();
        }
    }

    public static void BuyermainPage() throws IOException {
        double coin1;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to buyer main page:"
                + "\n1: View catalog"
                + "\n2: Select drinks to add to cart"
                + "\n3: Select drinks to remove from your cart"
                + "\n4: to insert coins"
                + "\n5: to complete transaction"
                + "\n6: log out as a buyer");

        String user = s.nextLine();

        switch (user) {

            case "1":
                hm.display();
                BuyermainPage();
                break;
            case "2":
                addtocart();
                break;
            case "3":
                RemoveFromCart();
                break;
            case "4":
                coin1 = c1.getCoin();
                c1.setCoin(insertCoin(coin1));
                BuyermainPage();
                break;
            case "5":
                transaction(total(c.arr, c.arr1), c1.getCoin());
                break;
            case "6":
                user();
                break;
            default:
                System.out.println("Wrong entry, try again");
                BuyermainPage();
        }
    }

    public static void addtocart() throws IOException {
        Scanner s = new Scanner(System.in);
        int d = 5;
        do {
            System.out.println("Enter the number of the drink you want to add");
            hm.display();
            System.out.println("[9] Back");
            String input = s.nextLine();
            switch (input) {
                case "1":
                    c.addToCart("Pikapoo", 1);
                    c.display();
                    break;
                case "2":
                    c.addToCart("Hell and Sky", 1);
                    c.display();
                    break;
                case "3":
                    c.addToCart("SkyJuicee", 1);
                    c.display();
                    break;
                case "4":
                    c.addToCart("Popci", 1);
                    c.display();
                    break;
                case "5":
                    c.addToCart("MAILO", 1);
                    c.display();
                    break;
                case "6":
                    c.addToCart("99plus", 1);
                    c.display();
                    break;
                case "7":
                    c.addToCart("Sepright", 1);
                    c.display();
                    break;
                case "8":
                    c.addToCart("LeegalCaffeine", 1);
                    c.display();
                    break;
                case "9":
                    d = 6;
                    BuyermainPage();
                default:
                    System.out.println("wrong entry, try again");
                    addtocart();
            }

        } while (d == 5);

    }

    public static void RemoveFromCart() throws IOException {
        Scanner s = new Scanner(System.in);
        int d = 5;
        do {
            System.out.println("Enter the number of the drink you want to remove or 9 to go back");
            Cart.display();
            String input = s.nextLine();
            switch (input) {
                case "1":
                    c.removeFromCart1(0);
                    c.display();
                    break;
                case "2":
                    c.removeFromCart1(1);
                    c.display();
                    break;
                case "3":
                    c.removeFromCart1(2);
                    c.display();
                    break;
                case "4":
                    c.removeFromCart1(3);
                    c.display();
                    break;
                case "5":
                    c.removeFromCart1(4);
                    c.display();
                    break;
                case "6":
                    c.removeFromCart1(5);
                    c.display();
                    break;
                case "7":
                    c.removeFromCart1(6);
                    c.display();
                    break;
                case "8":
                    c.removeFromCart1(7);
                    c.display();
                    break;
                case "9":
                    d = 6;
                    BuyermainPage();
                default:
                    System.out.println("wrong entry, try again");
                    RemoveFromCart();
            }

        } while (d == 5);
    }

    public static double total(String[] arr, int[] arr1) {
        double total = 0;
        for (int i = 0; i < c.top; i++) {
            total = total + (hm.get(arr[i]) * arr1[i]);
        }
        return total;
    }

    public static double insertCoin(double coins) throws IOException {
        Scanner s = new Scanner(System.in);
        int d = 5;
        do {
            System.out.println("Insert coins:"
                    + "\n1: 10 cents"
                    + "\n2: 25 cents"
                    + "\n3: 50 cents"
                    + "\n4: 1 Ringgit"
                    + "\n5: 5 Ringgit"
                    + "\n6: 10 Ringgit"
                    + "\n7: Go back"
                    + "\nCoins " + coins);
            String input = s.nextLine();
            switch (input) {
                case "1":
                    coins = coins + 0.10;
                    break;
                case "2":
                    coins = coins + 0.25;
                    break;
                case "3":
                    coins = coins + 0.50;
                    break;
                case "4":
                    coins = coins + 1;
                    break;
                case "5":
                    coins = coins + 5;
                    break;
                case "6":
                    coins = coins + 10;
                    break;
                case "7":
                    d = 6;
                    System.out.println("You inserted " + coins + " MYR");
                    return coins;
                default:
                    System.out.println("wrong entry try again");
                    insertCoin(coins);
            }
        } while (d == 5);
        return coins;
    }

    public static void transaction(double total, double coins) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Transaction menu"
                + "\nyou inserted " + coins
                + "\nyour total is " + total
                + "\nwould you like to proceed with your transaction?"
                + "\n1: Yes\n2: No\nPS: if your total is more than the money inserted the transaction will be aborted."
        );
        String input = s.nextLine();

        switch (input) {
            case "1":
                if (coins >= total && total > 0) {
                    String log = "";
                    System.out.println("transation done");
                    String trans = tr.generateTrans();

                    log = log + "Time: " + tr.time1() + "\n";
                    log = log + "Transaction ID: " + trans + "\n";
                    System.out.println("You bought :");
                    log = log + c.display() + "\n";
                    tr.addlog(log);
                    System.out.println("Transaction ID: " + trans + "\ntime:"
                            + tr.time1() + "\nThanks for buying from our vending machine!\n");
                    stockChanger(c.arr, c.arr1, c.top);
                    c.emptyCart();
                    c1.setCoin(coins - total);
                    if (coins - total != 0) {
                        System.out.println("your change is " + (coins - total) + "\n");
                        c1.setCoin(0);
                    }
                    user();
                } else if (total == 0) {
                    System.out.println("Cart is empty");
                    BuyermainPage();
                } else {
                    System.out.println("Your money is not enough, transaction will be aborted");
                    c1.setCoin(0);
                    c.emptyCart();
                    BuyermainPage();
                }
                break;
            case "2":
                System.out.println("transaction aborted, take your money back");
                c1.setCoin(0);
                c.emptyCart();
                BuyermainPage();
            default:
                System.out.println("Wrong entry, try again");
                BuyermainPage();
        }
    }

    public static void stockChanger(String[] a, int[] b, int top) {
        for (int i = 0; i < top; i++) {
            hm.Stock(a[i], b[i]);
        }
    }

    public static void VendormainPage() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to vendor main page:"
                + "\n1: Check the items available"
                + "\n2: Refill the stock"
                + "\n3: Open the log book"
                + "\n4: Log out as a vendor");

        String user = s.nextLine();

        switch (user) {

            case "1":
                hm.display();
                VendormainPage();
                break;
            case "2":
                refill();
                break;
            case "3":
                tr.openlog();
                VendormainPage();
                break;
            case "4":
                user();
                break;
            default:
                System.out.println("Wrong entry, try again");
                VendormainPage();
        }

    }

    public static void refill() throws IOException {
        Scanner s = new Scanner(System.in);
        int d = 5;
        do {
            System.out.println("Enter the number of the drink you want to refill");
            hm.display();
            System.out.println("[9] Back");
            String input = s.nextLine();
            switch (input) {
                case "1":
                    hm.Stock1("Pikapoo", 1);

                    break;
                case "2":
                    hm.Stock1("Hell and Sky", 1);

                    break;
                case "3":
                    hm.Stock1("SkyJuicee", 1);

                    break;
                case "4":
                    hm.Stock1("Popci", 1);

                    break;
                case "5":
                    hm.Stock1("MAILO", 1);

                    break;
                case "6":
                    hm.Stock1("99plus", 1);

                    break;
                case "7":
                    hm.Stock1("Sepright", 1);

                    break;
                case "8":
                    hm.Stock1("LeegalCaffeine", 1);

                    break;
                case "9":
                    d = 6;
                    VendormainPage();
                default:
                    System.out.println("wrong entry, try again");
                    refill();
            }

        } while (d == 5);
    }
    
}
