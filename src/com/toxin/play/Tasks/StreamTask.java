package com.toxin.play.Tasks;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamTask {

    @Data
    @AllArgsConstructor
    static class Client {
        private long id;
    }

    @Data
    @AllArgsConstructor
    static class Item {
        private long id;
        private String color;
    }

    /*
     * Сервис для поиска заказов клиентов
     */
    class ItemService {
        private Map<Client, List<Item>> database = Map.of(
                new Client(1L), List.of(new Item(3L, "C"), new Item(2L, "B"), new Item(3L, "C")),
                new Client(2L), List.of(new Item(1L, "A"), new Item(3L, "C")),
                new Client(3L), List.of(new Item(2L, "B")),
                new Client(4L), List.of(new Item(4L, "D"), new Item(4L, "D"), new Item(4L, "D"))
        );

        Collection<Item> getClientOrders(Client client) {
            return database.getOrDefault(client, Collections.emptyList());
        }
    }

    private ItemService itemService = new ItemService();

    /*
      Возвращает Stream ,
      содержащий count самых популярных цветов товаров,
      которые заказывали переданные клиенты
      @param clients - список клиентов
      @param count - максимальное количество записей, которое надо вернуть
      @return
     */
    public Stream<String> mostPopularColors(Collection<Client> clients, int count) {
        return clients.stream()
                .flatMap(c -> itemService.getClientOrders(c).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(count)
                .map(e -> e.getKey().getColor());
    }

    public static void main(String[] args) {
        StreamTask task = new StreamTask();

        Stream<String> stream = task.mostPopularColors(List.of(
                new Client(1L),
                new Client(2L),
                new Client(3L)
        ), 2);

        stream.forEach(System.out::println);
    }
}
