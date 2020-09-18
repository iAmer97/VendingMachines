package izza;

import java.io.*;

public class hashMap {

    public final int SIZE = 16;
    public Entry table[] = new Entry[SIZE];

    class Entry {

        String item;
        int stock;
        double price;
        Entry next;

        public Entry(String item, int stock, double price) {
            this.item = item;
            this.stock = stock;
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getItem() {
            return item;
        }

        public double getPrice() {
            return price;
        }

    }

    public double get(String item) {
        int hash = item.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.item.equals(item)) {
                return e.price;
            }
            e = e.next;
        }
        return 0;
    }

    public void put(String item, int stock, double price) {
        int hash = item.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            if (e.item.equals(item)) {
                e.stock = stock;
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBox = new Entry(item, stock, price);
                e.next = entryInOldBox;
            }
        } else {
            Entry entryInNewBox = new Entry(item, stock, price);
            table[hash] = entryInNewBox;
        }
    }

    public void Stock(String item, int stock) {
        int hash = item.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.item.equals(item)) {
                e.stock = e.stock - stock;
                return;
            }
        }
    }

    public void Stock1(String item, int stock) {
        int hash = item.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.item.equals(item)) {
                if (e.stock < 20) {
                    e.stock = e.stock + stock;
                    return;
                }else{
                    System.out.println("Stock is full");
                    return;
                }
            }
        }
    }

    public void display() {
        int i = 0;
        int counter = 1;
        System.out.println("Name\t-\tPrice\t-\tStock");
        for (i = 0; i < 16; i++) {
            if (table[i] != null) {
                System.out.println("[" + counter + "] " + table[i].item + "\t\t" + table[i].price + "\t\t" + table[i].stock);
                counter++;
                if (table[i].next != null) {
                    System.out.println("[" + counter + "] " + table[i].item + "\t\t" + table[i].price + "\t\t" + table[i].stock);
                    table[i] = table[i].next;
                    counter++;
                }
            }
        }
    }

}
