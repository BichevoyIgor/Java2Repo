import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"кот", "собака", "гусь", "кот", "лев", "ёжик", "морж", "гусь", "мышь", "слон", "гусь", "морж", "аист", "моль", "бегемот", "корова", "кролик", "ворона", "воробей"};
        System.out.println("В массиве содержатся следующие уникальные слова: " + unique(words));
        repeatWords(words);
    }

    // Метод возвращает список уникальных слов
    public static ArrayList<String> unique(String[] s) {
        int repeat;
        ArrayList<String> uniqueWords = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            repeat = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[i].equals(s[j])) repeat++;
            }
            if (repeat <= 1) uniqueWords.add(s[i]);
        }
        return uniqueWords;
    }

    // метод выводит на экран сколько раз повторяется каждое слово в массиве
    public static void repeatWords(String[] s) {
        int repeat;
        Map<String, Integer> repeatWords = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            repeat = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[i].equals(s[j])) repeat++;
            }
            repeatWords.put(s[i], repeat);
        }
        for (Map.Entry<String, Integer> word : repeatWords.entrySet()) {
            System.out.printf("Слово \"%s\" встречается %d раз\n", word.getKey(), word.getValue());
        }
    }
}
