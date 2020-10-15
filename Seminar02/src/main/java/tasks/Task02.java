package tasks;

public class Task02 {

    /**
     * @param dayOfWeek от 0 до 6 включительно
     * @return Возвращает "rest" для субботы и воскресенья.
     * Для остальных дней "work".
     * @throws IllegalArgumentException Если dayOfWeek не от 0 до 6.
     */
    public static String shouldIWork(int dayOfWeek) {
        if (dayOfWeek < 0 || dayOfWeek > 6) {
            throw new IllegalArgumentException();
        }
        else if (dayOfWeek < 5) {
            return "work";
        }
        else {
            return "rest";
        }
    }

}
