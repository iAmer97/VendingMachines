/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package izza;

public class Cart {

    static hashMap hm;
    static int maxSize;
    static int top;
    static String arr[];
    static int arr1[];

    public Cart(int n) {
        maxSize = n;
        top = 0;                    // points to index 0
        arr = new String[maxSize];
        arr1 = new int[maxSize];
    }

    public static boolean empty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void addToCart(String item, int stock) {

        for (int i = 0; i < top; i++) {
            if (arr[i].equals(item)) {
                arr1[i] = arr1[i] + stock;
                return;
            }
        }
        if (top < maxSize) {
            arr[top] = item;
            arr1[top] = stock;
            top++;
        } else {
            System.out.println("Stack overflow!!! Stack has reached maxSize..");
        }

    }

    public static void removeFromCart1(int index) {

        arr1[index] = arr1[index] - 1;
        if (arr1[index] == 0) {
            for (int k = index; k < top; k++) {
                arr[k] = arr[k + 1];
                arr1[k] = arr1[k + 1];

            }
            top--;
        }
    }

    public static String display() {
        String temp = "";
        if (!empty()) {
            System.out.println("Name\t-\tStock");
            for (int i = 0; i < top; i++) {
                System.out.println("[" + (i + 1) + "] " + arr[i] + "\t\t" + arr1[i]);
                temp = temp + "[" + (i + 1) + "] " + arr[i] + "\t\t" + arr1[i] + "\n";
            }
            System.out.println("Your total is: " + SMV.total(arr, arr1));
            temp = temp + "total: " + SMV.total(arr, arr1) + "\n";

            return temp;
        } else {
            System.out.println("cart is empty");
        }
        return null;
    }
    
    public static void emptyCart() {
        for (int i = 0; i < top; i++) {
            arr[i] = null;
            arr1[i] = 0;
        }
        top = 0;
    }

}
