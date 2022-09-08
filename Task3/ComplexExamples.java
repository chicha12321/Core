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

        Map<String, Long> sortedMap = Arrays.stream(Optional.of(RAW_DATA).orElseThrow(NullPointerException::new))
                .filter(Objects::nonNull).distinct()
                .sorted(Comparator.comparing(obj -> obj.name))
                .sorted(Comparator.comparing(obj -> obj.id))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        sortedMap.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value:\t " + value);
        });

        System.out.println();


        System.out.println("Task2:");
        System.out.println();

        int[] array = new int[]{3, 4, 2, 7};
        System.out.println(Arrays.toString(findPare(array, 10)));
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

    public static int[] findPare(int[] array, int number) {
        if (array != null) {
            Arrays.sort(array);
        } else return null;

        int leftPointer = 0;
        int rightPointer = array.length - 1;
        int sumNumbers;

        while (leftPointer < rightPointer) {
            sumNumbers = array[leftPointer] + array[rightPointer];
            if (sumNumbers == number) {
                return new int[]{array[leftPointer], array[rightPointer]};
            }
            if (sumNumbers < number) {
                leftPointer++;
            } else {
                rightPointer++;
            }
        }
        return null;
    }

    /*
    Task3
        Реализовать функцию нечеткого поиска
     */
    public static boolean fuzzySearch(String searchString, String inputString) {
        if ((searchString.isEmpty() || inputString.isEmpty())) {
            return false;
        }
        String strCoincidences = "";
        int indexForSearchString = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == searchString.charAt(indexForSearchString)) {
                strCoincidences += searchString.charAt(indexForSearchString);
                if (strCoincidences.equals(searchString)) {
                    return true;
                } else indexForSearchString++;
            }
        }
        return false;
    }
}
