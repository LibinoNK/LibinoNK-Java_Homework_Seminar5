//Задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Иванов В.В.", "+79433212323, +78005553535, +79782223311");
        phoneBook.put("Петрова А.А.", "+79994443322");
        phoneBook.put("Сидорова О.Е.", "+79873323232, +79993316645, +79088455473");
        phoneBook.put("Коляскин В.Н.", "+79541113300");
        phoneBook.put("Петренко П.М.", "+79430000201");
        phoneBook.put("Арбузова Е.П.", "+79545552211");

        System.out.println("=".repeat(20));
        System.out.println(phoneBook);
        System.out.println("=".repeat(20));

        addNumber(phoneBook, "Арбузова Е.П.", "+77078822213");

        System.out.println(phoneBook);
        System.out.println("=".repeat(20));

        // Преобразуем HashMap в список записей
        List<Map.Entry<String, String>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
                return Integer.compare(countPhones(entry2.getValue()), countPhones(entry1.getValue()));
            }

            private int countPhones(String phones) {
                return phones.split(", ").length;
            }
        });

        // Выводим отсортированные записи
        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }


    }

    public static void addNumber(HashMap phoneBook, String name, String phoneNumber){
        if(phoneBook.containsKey(name)){
            phoneBook.put(name, phoneBook.get(name) + ", " + phoneNumber);
        }
        else{
            phoneBook.put(name, phoneNumber);
        }
    }
}
