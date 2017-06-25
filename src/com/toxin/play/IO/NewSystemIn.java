package com.toxin.play.IO;

import java.io.*;

public class NewSystemIn {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("JAVA").append('\n');
        sb.append("THE").append('\n');
        sb.append("BEST").append('\n');
        String data = sb.toString();

        InputStream is = new ByteArrayInputStream(data.getBytes());
        System.setIn(is);

        readAndPrintLine();
    }

    private static void readAndPrintLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
    }
}
