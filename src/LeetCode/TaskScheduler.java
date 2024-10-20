package LeetCode;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Frequency of each task
        int[] freq = new int[26]; // Assuming all tasks are uppercase letters
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        int maxCount = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                maxCount = 1;
            } else if (f == maxFreq) {
                maxCount++;
            }
        }

        // Step 3: Calculate the minimum intervals
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maxFreq * maxCount);
        int idles = Math.max(0, emptySlots - availableTasks);

        // Total time is task count + idle time
        return tasks.length + idles;
    }
}
