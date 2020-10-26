package tasks;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Построить частотный словарь(Map) символов английского или русского алфавита.
 * Для этого взять любой большой кусок текста и сохранить его в файле.
 * Соответственно в коде надо из файла читать.
 */
public class Task03 {

    public static void main(String[] args) {
        Map<Character, Integer> frequencies = new HashMap<Character, Integer>();
        try {
            File text = new File("test.txt");
            Scanner reader = new Scanner(text);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                for (int i = 0; i < line.length(); ++i) {
                    if (frequencies.containsKey(line.charAt(i))) {
                        frequencies.put(line.charAt(i), frequencies.get(line.charAt(i)) + 1);
                    }
                    else {
                        frequencies.put(line.charAt(i), 1);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.out.println(frequencies);
    }

}