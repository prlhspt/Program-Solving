package Sort;

public class InsertionSort {

    public static void insertionSortImperative(int[] arr) {
        for (int a = 1; a < arr.length; a++) {
            int key = arr[a];
            int b = a - 1;
            while (b >= 0 && arr[b] > key) {
                arr[b + 1] = arr[b];
                b = b - 1;
            }
            arr[b + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        insertionSortImperative(arr);

    }
}
