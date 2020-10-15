package tasks;

public class Task01 {

    /**
     * Возвращает минимальное значение из массива.
     * Не использовать стандартную библиотеку!
     */
    public static int min(int[] ints) {
        int min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < min) {
                min = ints[i];
            }
        }
        return min;
    }

    public static float average(int[] ints) {
        float sum = ints[0];
        for (int i = 1; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum / ints.length;
    }

}
