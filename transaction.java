package izza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class transaction {

    String transaction;

    public static String generateTrans() {
        char[] trans = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] id = new char[8];
        id[0] = 'I';
        id[1] = 'D';
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            id[i + 2] = trans[r.nextInt(trans.length)];
        }
        String trans1 = new String(id);
        return trans1;
    }

    public static String time1() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        String time = new String(formatter.format(date));
        return time;
    }

    public static void addlog(String log) throws IOException {

        File logs = new File("logs.txt");
        String temp = log;
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("logs.txt"));
        String line = reader.readLine();
        while (line != null) {
            temp = temp + "\r\n" + line;
            line = reader.readLine();
        }

        reader.close();
        PrintWriter writer = new PrintWriter("logs.txt");
        writer.write(temp);
        writer.close();
    }

    public static void openlog() {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "logs.txt");
        try {
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

