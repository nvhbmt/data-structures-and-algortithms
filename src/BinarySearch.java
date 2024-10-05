public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        int n = a.length;
        int left = 0;
        int right = n -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == key) return mid;
            else if (key > a[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static int binarySearchRecursion(int[] a, int key, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

//        System.out.println(left + " " + mid + " " + right);

        if (a[mid] == key) return  mid;

        if (key > a[mid]) left = mid + 1;
        else right = mid - 1;

        return binarySearchRecursion(a,key,left,right);
    }

    public static int binarySearchRecursion(int[] a, int key) {
        int n = a.length;
        return binarySearchRecursion(a,key,0,n -1);
    }

    public static void main(String[] args) {
        int[] a = {1,4,9,12,19,25,31,46,50,57,72};
        System.out.println(binarySearchRecursion(a,31));
    }
}
