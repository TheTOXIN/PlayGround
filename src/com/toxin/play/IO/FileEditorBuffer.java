package com.toxin.play.IO;

import java.io.*;
import java.util.Scanner;

public class FileEditorBuffer {
    public void createFile(String name) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/toxin/play/IO/" + name));

        String str;
        while (!(str = sc.nextLine()).isEmpty()) {
            writer.write(str);
            writer.newLine();
        }

        sc.close();
        writer.flush();
        writer.close();
    }

    public void copyFile(String name) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/toxin/play/IO/" + name));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/toxin/play/IO/" + "Copy_" + name));

        while (reader.ready()) {
            writer.write(reader.readLine());
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        FileEditorBuffer fileEditorBuffer = new FileEditorBuffer();
        fileEditorBuffer.createFile("test.txt");
        fileEditorBuffer.copyFile("test.txt");
    }
}
