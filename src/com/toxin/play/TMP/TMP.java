package com.toxin.play.TMP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TMP {

    public enum TEST {
        TEST_1("TYPE_1", ""),
        TEST_2("TYPE_2", "KIND_1"),
        TEST_3("TYPE_2", "KIND_2");

        String type;
        String kind;

        TEST(String type, String kind) {
            this.type = type;
            this.kind = kind;
        }
    }

    public static void main(String[] args) {
        System.out.println("TEST - 1");

        List<String> types = Arrays.asList("TYPE_1", "TYPE_2");
        List<String> kinds = Arrays.asList("KIND_1", "KIND_2");

        long t1 = System.nanoTime();
        System.out.println("RES 1 = " + test_1(types, kinds) + " time: " + (System.nanoTime() - t1));

        long t2 = System.nanoTime();
        System.out.println("RES 2 = " + test_2(types, kinds) + " time: " + (System.nanoTime() - t2));
    }

    private static List<TEST> test_1(
            final List<String> ussdTypes,
            final List<String> ussdKinds
    ) {
        return ussdTypes.stream().flatMap(ussdType ->
                Arrays.stream(TEST.values())
                        .filter(pt -> ussdType.equals(pt.type))
                        .filter(pt -> "".equals(pt.kind) || ussdKinds.contains(pt.kind))
                        .toList()
                        .stream()
        ).collect(Collectors.toList());
    }

    public static List<TEST> test_2(
            final List<String> ussdTypes,
            final List<String> ussdKinds
    ) {
        List<TEST> result = new ArrayList<>();

        for (String ussdType : ussdTypes) {
            for (TEST portalType : TEST.values()) {
                if (ussdType.equals(portalType.type)) {
                    String ussdKind = portalType.kind;
                    if ("".equals(ussdKind) || ussdKinds.contains(ussdKind)) {
                        result.add(portalType);
                    }
                }
            }
        }

        return result;
    }
}
