package tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать итератор над массивом.
 * Массив принимается в конструктор.
 * Итерация должна начинаться с первого элемента.
 * hasNext возвращает true, если итератор может вернуть следующее значение.
 * next должен возвращать следующее значение.(с переходом на следующий элемент)
 */
class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int index;


    public ArrayIterator(T[] _array) {
        this.array = _array;
        this.index = 0;
    }

    //@Override
    public boolean hasNext() {
        return index < array.length;
    }

    //@Override
    public T next() {
        // Если следующего значения нет, то надо бросить NoSuchElementException
        if (index >= array.length) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}

class Task02 {

}