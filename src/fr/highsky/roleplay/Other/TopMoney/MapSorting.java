package fr.highsky.roleplay.Other.TopMoney;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MapSorting {

    private static final Function EXTRACT_KEY =
            new Function<Map.Entry<Object, Object>, Object>() {
                public Object apply(Map.Entry<Object, Object> input) {
                    return input.getKey();
                }
            };

    private static final Function EXTRACT_VALUE =
            new Function<Map.Entry<Object, Object>, Object>() {
                public Object apply(Map.Entry<Object, Object> input) {
                    return input.getValue();
                }
            };

    public static <T, V extends Comparable<V>> List<Map.Entry<T, V>> sortedValues(Map<T, V> map) {
        return sortedValues(map, Ordering.<V>natural());
    }

    public static <T, V> List<Map.Entry<T, V>> sortedValues(Map<T, V> map, Comparator<V> valueComparator) {
        return Ordering.from(valueComparator).onResultOf(MapSorting.<T, V>extractValue()).sortedCopy(map.entrySet());
    }

    @SuppressWarnings("unchecked")
    private static <T, V> Function<Map.Entry<T, V>, T> extractKey() {
        return EXTRACT_KEY;
    }

    @SuppressWarnings("unchecked")
    private static <T, V> Function<Map.Entry<T, V>, V> extractValue() {
        return EXTRACT_VALUE;
    }
}
