package LeetCode;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        int ballToLeft = 0, movesToLeft = 0;
        int ballToRight = 0, movesToRight = 0;

        for (int i = 0; i < n; i++) {
            answer[i] += movesToLeft;
            ballToLeft += Character.getNumericValue(boxes.charAt(i));
            movesToLeft += ballToLeft;


            int j = n - i - 1;
            answer[j] += movesToRight;
            ballToRight += Character.getNumericValue(boxes.charAt(j));
            movesToRight += ballToRight;
        }

        return answer;
    }
}
