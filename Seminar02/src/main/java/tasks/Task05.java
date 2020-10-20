package tasks;

/**
 * Напишите класс, конструктор которого принимает два массива:
 * массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент
 * из первого массива случайным образом, с учётом его веса.
 * Пример:
 * Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже,
 * чем значение «2» и в десять раз реже, чем значение «3».
 */
class RandomFromArray {
    private int[] array;

    RandomFromArray(int[] values, int[] weights) {
        int arr_len = 0;
        for (int i = 0; i < weights.length; ++i) {
            arr_len += weights[i];
        }
        array = new int[arr_len];
        int cur_value = 0;
        int cur_weight = weights[0];
        for (int i = 0; i < arr_len; ++i) {
            if (cur_weight == 0) {
                ++cur_value;
                cur_weight = weights[cur_value];
            }
            --cur_weight;
            array[i] = values[cur_value];
        }
    }

    public int weighted_random() {
        int i = (int) (Math.random() * array.length);
        return array[i];
    }
}

public class Task05 {

}
