package com.toxin.play.MD5;

import org.apache.commons.lang.ArrayUtils;

public class HashMD5 {

    public static void main(String[] args) {
        System.out.println(new HashMD5().hash("Hello MD5!!!"));
    }

    private String hash(String data) {
        byte one = 0x8;
        byte nil = 0x0;

        //STEP 1

        byte[] bytes = data.getBytes();
        bytes = ArrayUtils.add(bytes, one);

        int L = bytes.length * 8;
        int dL = 0;
        int N = 0;

        while (dL < L) {
            dL = 512 * N + 448;
            N++;
        }

        int countNil = (dL - L) / 8;
        bytes = ArrayUtils.addAll(bytes, new byte[countNil]);

        return ArrayUtils.toString(bytes);
    }

}
