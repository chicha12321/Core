package Task2;


public class main {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] arrayForTest = {1, 2, 3, 4, 5, 5, 6 ,9};

        sort(array);

        System.out.println("Отсортированный массив::");
        for (int j : array) {
            System.out.print("[");
            System.out.print(j);
            System.out.print("]");
        }
    assert (isArrEquals(array,arrayForTest));
    }

    public static int[] sort(int array[]) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        return array;
    }
    public static boolean isArrEquals(int[] arr1, int[] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }
        } else return false;
        return true;
    }
}
