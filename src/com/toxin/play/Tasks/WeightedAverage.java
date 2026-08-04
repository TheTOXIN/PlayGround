package com.toxin.play.Tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Пример входных данных: 2025-10, кредит, объем,
 * 320.0 2025-10, кредит, чистый доход,
 * 30.0 2025-09, кредит, объем,
 * 170.0 2025-09, кредит, чистый доход, 18 ...
 * данные по другим продуктам
 * Средневзвешенное по кредиту: (320.0 * 30.0 + 170.0 * 18.0) / (30.0 + 18.0)
 */
public class WeightedAverage {

    record RawData(YearMonth month, String product, String attribute, BigDecimal value) {
    }

    record CalculationResult(String product, BigDecimal result) {
    }

    /**
     * Формула расчета средневзвешенного:
     * * ∑m(a * b) / ∑mb * a - attr1 * b - attr2 * m - каждый месяц расчитываемого периода. *
     * Необходимо вернуть раcчитаное значение для каждого продукта.
     */
    public static List<CalculationResult> calculateWeightedAverage(
            List<RawData> rawData, String attr1, String attr2
    ) {
        Map<String, Map<YearMonth, Map<String, BigDecimal>>> rowDataMap = rawData
                .stream()
                .collect(
                        Collectors.groupingBy(RawData::product,
                                Collectors.groupingBy(RawData::month,
                                        Collectors.toMap(RawData::attribute, RawData::value,
                                                (v1, v2) -> v1)
                                )
                        )
                );

        List<CalculationResult> results = new ArrayList<>();

        for (var byProduct : rowDataMap.entrySet()) {
            Map<YearMonth, Map<String, BigDecimal>> months = byProduct.getValue();

            BigDecimal numerator = BigDecimal.ZERO;
            BigDecimal denominator = BigDecimal.ZERO;

            for (var byMonth : months.entrySet()) {
                Map<String, BigDecimal> attrs = byMonth.getValue();

                BigDecimal a = attrs.get(attr1);
                BigDecimal b = attrs.get(attr2);

                if (a == null || b == null) {
                    continue;
                }

                numerator = numerator.add(a.multiply(b));
                denominator = denominator.add(b);
            }

            BigDecimal weightedAverage = BigDecimal.ZERO;

            if (denominator.compareTo(BigDecimal.ZERO) != 0) {
                weightedAverage = numerator.divide(denominator, 2, RoundingMode.HALF_UP);
            }

            CalculationResult result = new CalculationResult(
                    byProduct.getKey(),
                    weightedAverage
            );

            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        List<RawData> data = generateRawData();
        List<CalculationResult> result = calculateWeightedAverage(
                data, "объем", "чистый доход");

        result.forEach(r ->
                System.out.println(r.product() + " -> " + r.result())
        );
    }

    public static List<RawData> generateRawData() {
        List<RawData> data = new ArrayList<>();

        // === КРЕДИТ ===
        data.add(new RawData(YearMonth.of(2025, 10), "кредит", "объем", new BigDecimal("320.0")));
        data.add(new RawData(YearMonth.of(2025, 10), "кредит", "чистый доход", new BigDecimal("30.0")));

        data.add(new RawData(YearMonth.of(2025, 9), "кредит", "объем", new BigDecimal("170.0")));
        data.add(new RawData(YearMonth.of(2025, 9), "кредит", "чистый доход", new BigDecimal("18.0")));

        data.add(new RawData(YearMonth.of(2025, 8), "кредит", "объем", new BigDecimal("200.0")));
        data.add(new RawData(YearMonth.of(2025, 8), "кредит", "чистый доход", new BigDecimal("20.0")));

        // === ДЕПОЗИТ ===
        data.add(new RawData(YearMonth.of(2025, 10), "депозит", "объем", new BigDecimal("500.0")));
        data.add(new RawData(YearMonth.of(2025, 10), "депозит", "чистый доход", new BigDecimal("25.0")));

        data.add(new RawData(YearMonth.of(2025, 9), "депозит", "объем", new BigDecimal("450.0")));
        data.add(new RawData(YearMonth.of(2025, 9), "депозит", "чистый доход", new BigDecimal("22.0")));

        // === КАРТЫ ===
        data.add(new RawData(YearMonth.of(2025, 10), "карты", "объем", new BigDecimal("150.0")));
        data.add(new RawData(YearMonth.of(2025, 10), "карты", "чистый доход", new BigDecimal("12.0")));

        data.add(new RawData(YearMonth.of(2025, 9), "карты", "объем", new BigDecimal("130.0")));
        data.add(new RawData(YearMonth.of(2025, 9), "карты", "чистый доход", new BigDecimal("10.0")));

        // === С ПРОПУСКОМ (проверка null-логики) ===
        data.add(new RawData(YearMonth.of(2025, 8), "карты", "объем", new BigDecimal("120.0")));
        // нет "чистый доход" → должен пропуститься

        // === С НУЛЕВЫМ ВЕСОМ ===
        data.add(new RawData(YearMonth.of(2025, 7), "кредит", "объем", new BigDecimal("100.0")));
        data.add(new RawData(YearMonth.of(2025, 7), "кредит", "чистый доход", BigDecimal.ZERO));

        return data;
    }
}