package tasks;

import java.util.*;

public class Task01 {

    /**
     * Реализуйте метод, который возвращает новую коллекцию,
     * но уже без дубликатов.
     * Дубликаты, если equals true.
     */
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        Set<T> set = new HashSet<T>(collection);
        collection.clear();
        collection.addAll(set);
        return collection;
    }

}