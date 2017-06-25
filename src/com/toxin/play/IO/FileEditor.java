package com.toxin.play.IO;

import java.io.*;

public class FileEditor {
    public void createFile(String name) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream outputStream = new FileOutputStream("src/com/toxin/play/IO/" + name);

        String str;
        while (!(str = reader.readLine()).isEmpty()) {
            outputStream.write(str.getBytes());
            outputStream.write('\n');
        }

        outputStream.flush();
        outputStream.close();
    }

    public void copyFile(String name) throws IOException {
        FileInputStream in = new FileInputStream("src/com/toxin/play/IO/" + name);
        FileOutputStream out = new FileOutputStream("src/com/toxin/play/IO/" + "Copy_" + name);

        byte[] buffer = new byte[1000];

        while (in.available() > 0) {
            int data = in.read(buffer);
            out.write(buffer, 0, data);
        }

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        FileEditor fileEditor = new FileEditor();
        fileEditor.createFile("test.txt");
        fileEditor.copyFile("test.txt");
    }
}
