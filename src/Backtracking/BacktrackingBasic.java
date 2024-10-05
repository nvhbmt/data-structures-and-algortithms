package Backtracking;

import java.util.Arrays;

public class BacktrackingBasic {
    public static String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};
    public static int[] selections = new int[colors.length];
    public static int[] validValues = {0, 1};
    public static int count = 0;

    public static void backtracking(int currentIndex) {
        for (int validValue : validValues) {
            selections[currentIndex] = validValue;
            if (currentIndex == colors.length - 1) {
                progress(selections);
            } else {
                backtracking(currentIndex + 1);
            }
        }
    }

    public static void progress(int[] selections) {
        count++;
        System.out.print(count + ". " + Arrays.toString(selections) + " ");
        for (int i = 0; i < colors.length; i++) {
            if (selections[i] == 1) {
                System.out.print(colors[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        backtracking(0);
    }
}
