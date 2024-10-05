package Sort;

import java.util.Arrays;

public class SortingAlgorithm {
    public static void printArray(int no, int[] array) {
        System.out.printf("%d: ", no);
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            printArray(i, array);
        }
    }

    public static void bubbleSort2(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            printArray(i, array);
            if (isSorted) break;
        }
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > ai) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = ai;
            printArray(i, a);
        }
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                // min [i,n]
                if (a[j] < a[minIndex])
                    minIndex = j;
            if (minIndex != i) {
                int t = a[i];
                a[i] = a[minIndex];
                a[minIndex] = t;
            }

            printArray(i, a);
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int[] result = new int[n];

        int i = 0, i1 = 0, i2 = 0;

        while (i1 < n1 && i2 < n2)
            if (arr1[i1] < arr2[i2])
                result[i++] = arr1[i1++];
            else
                result[i++] = arr2[i2++];

        while (i1 < n1) result[i++] = arr1[i1++];
        while (i2 < n2) result[i++] = arr2[i2++];

        return result;
    }

    public static int[] mergeSort(int[] a, int l, int r) {
        if (l > r) return new int[0];
        if (l == r) return new int[]{a[l]};

        int mid = (l + r) / 2;

        // tách ra cho đến khi nào thành 1 mảng có 1 phần tử
        int[] arrLeft = mergeSort(a, l, mid);
        int[] arrRight = mergeSort(a, mid + 1, r);

        // merge two array
        return merge(arrLeft, arrRight);
    }

    public static int[] mergeSort(int[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    public static int partition(int[] a, int l, int r) {
        int mid = a[(l + r) / 2];
        int i = l, j = r;

        while (i <= j) {
            while (a[i] < mid) i++;
            while (a[j] > mid) j--;
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }

        return i;
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int k = partition(a, l, r);
        quickSort(a, l, k - 1);
        quickSort(a, k, r);
    }

    public static void quickSort2(int[] a, int l, int r) {
        int mid = a[(l + r) / 2];
        int i = l, j = r;

        while (i < j) {
            while (a[i] < mid) i++;
            while (a[j] > mid) j--;
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        if (i < r) quickSort2(a, i, r);
        if (l < j) quickSort2(a, l, j);
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 9, 8, 7, 8, 96, 5, 0};
        int n = a.length;

//        bubbleSort(a);

        System.out.println(Arrays.toString(mergeSort(a)));
        //System.out.println(Arrays.toString(a));
//        insertionSort(a);
//        selectionSort(a);

    }
}
