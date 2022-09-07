package homework;

import java.util.*;
import java.util.stream.Collectors;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */
        System.out.println("Task1:");
        System.out.println();

        Map<Object, Long> map = Arrays.stream(RAW_DATA).distinct()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        Set<Map.Entry<Object, Long>> entrySet = map.entrySet();
        for (Map.Entry<Object, Long> obj : entrySet) {
            System.out.println("Key: \t" + obj.getKey() + "\nValue:\t" + obj.getValue());
        }

        System.out.println();


        System.out.println("Task2:");
        System.out.println();

        int array[] = {3, 4, 2, 7};
        System.out.println(findPare(array, 10));
        System.out.println();


        System.out.println("Task3:");
        System.out.println();

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
        System.out.println(fuzzySearch("lwlww", "lw"));//false
        System.out.println(fuzzySearch("lwww", "lww"));//false

    }
     /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */

    public static List<Integer> findPare(int[] array, int number) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == number && i != j && list.isEmpty()) {
                    list.add(array[i]);
                    list.add(array[j]);
                }
            }
        }
        return list;
    }

    /*
    Task3
        Реализовать функцию нечеткого поиска
     */
    public static boolean fuzzySearch(String s1, String s2) {
        StringBuilder strCoincidences = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(index)) {
                strCoincidences.append(s1.charAt(index));
                if (strCoincidences.toString().equals(s1)) {
                    return true;
                } else index++;
            }
        }
        return false;
    }
}
