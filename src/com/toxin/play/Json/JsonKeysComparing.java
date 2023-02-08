package com.toxin.play.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.StreamSupport;

public class JsonKeysComparing {

    public static void main(String[] args) throws Exception {
        final List<String> keysA = getAllKeysOfJson("res/a.json");
        final List<String> keysB = getAllKeysOfJson("res/B.json");

        final List<String> errors = searchErrors(keysA, keysB);

        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            errors.forEach(System.out::println);
        }
    }

    private static List<String> searchErrors(List<String> keysA, List<String> keysB) {
        List<String> errors = new ArrayList<>();

        if (keysA.size() != keysB.size()) {
            errors.add("Diff size, a = " + keysA.size() + " & b = " + keysB.size());
            return errors;
        }

        for (int i = 0; i < keysA.size(); i++) {
            final String keyA = keysA.get(i);
            final String keyB = keysB.get(i);

            if (!keyA.equals(keyB)) {
                errors.add("Not eq, a = " + keyA + " & b = " + keyB);
            }
        }

        return errors;
    }

    private static List<String> getAllKeysOfJson(String path) throws IOException {
        final String jsonA = Files.readString(Path.of(path));

        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode jsonNode = mapper.readTree(jsonA);

        return process(jsonNode, new LinkedList<>());
    }

    private static List<String> process(JsonNode root, List<String> keys) {
        if (root.isEmpty()) return keys;

        final Iterable<String> iterable = root::fieldNames;
        StreamSupport.stream(iterable.spliterator(), false)
                .sorted(Comparator.naturalOrder())
                .forEach(keys::add);

        root.elements().forEachRemaining(node -> process(node, keys));

        return keys;
    }
}
