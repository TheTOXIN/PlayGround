package com.toxin.play.MD5;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.lang.ArrayUtils;

import java.math.BigInteger;
import java.util.Random;

public class HashMD5 {

    private static String hashTest = "C1E760565148F3DEA79AE087DDB157FF";
    private static String dataTest = "Hello MD5!!!";

    private static Random rand = new Random();

    public static void main(String[] args) {
        HashMD5 md5 = new HashMD5();

        String hash = md5.hash(dataTest);

        if (hashTest.equals(hash)) System.out.println(hash);
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

        int[][] S = {
            {7, 12, 17, 22},
            {5, 9, 14, 20},
            {4, 11, 16, 23},
            {6, 10, 15, 21}
        };

        FUN[] funs = {
            (X, Y, Z) -> (X & Y) | (~X & Z),
            (X, Y, Z) -> (X & Z) | (~Z & Y),
            (X, Y, Z) -> (X ^ Y ^ Z),
            (X, Y, Z) -> (Y ^ (~Z | X))
        };

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

            for (int i = 0; i < 64; i++) {
                int round = i >>> 4;
                int cycle;

                switch (round) {
                    case 0:
                        cycle = i % 4;
                        if (cycle == 0) for (int x : X) A = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 1) for (int x : X) B = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 2) for (int x : X) C = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 3) for (int x : X) D = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        break;
                    case 1:
                        cycle = i % 4;
                        if (cycle == 0) for (int x : X) A = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 1) for (int x : X) B = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 2) for (int x : X) C = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 3) for (int x : X) D = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        break;
                    case 2:
                        cycle = i % 4;
                        if (cycle == 0) for (int x : X) A = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 1) for (int x : X) B = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 2) for (int x : X) C = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 3) for (int x : X) D = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        break;
                    case 3:
                        cycle = i % 4;
                        if (cycle == 0) for (int x : X) A = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 1) for (int x : X) B = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 2) for (int x : X) C = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        else if (cycle == 3) for (int x : X) D = B + (A + funs[round].fun(B, C, D) + x + T[i] << S[round][cycle]);
                        break;
                }
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

        String hashA = HexBin.encode(bytesA);
        String hashB = HexBin.encode(bytesB);
        String hashC = HexBin.encode(bytesC);
        String hashD = HexBin.encode(bytesD);

        return hashA + hashB + hashC + hashD;
    }

    @FunctionalInterface
    private interface FUN {
        int fun(int X, int Y, int Z);
    }

}
