package com.toxin.play.MD5;

import org.apache.commons.lang.ArrayUtils;

import java.math.BigInteger;

public class HashMD5 {

    public static void main(String[] args) {
        System.out.println(new HashMD5().hash("Hello MD5!!!"));
    }

    private String hash(String data) {

        //STEP 1
        byte one = 0x8;

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

        //STEP2

        byte[] subData = ArrayUtils.subarray(data.getBytes(), 0, 8);
        bytes = ArrayUtils.addAll(bytes, subData);

        //STEP3

        int A = 0x01234567;
        int B = 0x89ABCDEF;
        int C = 0xFEDCBA98;
        int D = 0x76543210;

        int[] T = new int[64];

        for (int i = 0; i < T.length; i++) {
            T[i] = (int) (Math.pow(2, 32) * Math.abs(Math.sin(i)));
        }

        //STEP4

        for (int b = 0; b < bytes.length; b += 64) {
            byte[] block = ArrayUtils.subarray(bytes, b, b + 64);
            int[] X = new int[16];

            for (int w = 0; w < X.length; w++) {
                byte[] word = ArrayUtils.subarray(block, w * 4, w * 4 + 4);
                X[w] = new BigInteger(word).intValue();
            }

            int AA = A;
            int BB = B;
            int CC = C;
            int DD = D;

            int i = 0;

            for (int k = 0; k < X.length; k++) {
                int S = X[k] % (k + i + 1);
                A = B + (A + funF(B, C, D) + X[k] + T[i] << S);
                i++;
            }

            for (int k = 0; k < X.length; k++) {
                int S = X[k] % (k + i + 1);
                A = B + (A + funG(B, C, D) + X[k] + T[i] << S);
                i++;
            }

            for (int k = 0; k < X.length; k++) {
                int S = X[k] % (k + i + 1);
                A = B + (A + funH(B, C, D) + X[k] + T[i] << S);
                i++;
            }

            for (int k = 0; k < X.length; k++) {
                int S = X[k] % (k + i + 1);
                A = B + (A + funI(B, C, D) + X[k] + T[i] << S);
                i++;
            }

            A = AA + A;
            B = BB + B;
            C = CC + C;
            D = DD + D;
        }

        //STEP5

        byte[] bytesA = BigInteger.valueOf(A).toByteArray();
        byte[] bytesB = BigInteger.valueOf(B).toByteArray();
        byte[] bytesC = BigInteger.valueOf(C).toByteArray();
        byte[] bytesD = BigInteger.valueOf(D).toByteArray();

        System.out.println(ArrayUtils.toString(bytesA));
        System.out.println(ArrayUtils.toString(bytesB));
        System.out.println(ArrayUtils.toString(bytesC));
        System.out.println(ArrayUtils.toString(bytesD));

        return "";
    }

    private int funF(int X, int Y, int Z) {
        return (X & Y) | (~X & Z);
    }

    private int funG(int X, int Y, int Z) {
        return (X & Z) | (~Z & Y);
    }

    private int funH(int X, int Y, int Z) {
        return X ^ Y ^ Z;
    }

    private int funI(int X, int Y, int Z) {
        return Y ^ (~Z | X);
    }

}
