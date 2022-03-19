package Sort;

public class QuickSort {

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int a = begin; a < end; a++) {
            if (arr[a] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[a];
                arr[a] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 15, 4, 1, 14, 7, 2, 17, 8, 6};

        quickSort(arr, 0, n - 1);

        for (int i : arr) {
            System.out.println(i + " ");
        }

    }

}
