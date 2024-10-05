import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;

        for (int i = 0, j = n - 1; i < j; i++) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) j--;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] a = {3, 1, 2, 4};
//        System.out.println(Arrays.toString(sortArrayByParity(a)));
        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(s);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (char c : s.toCharArray())
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) return false;
            }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) - 1);
        }

        for (int value : hash.values()) {
            if (value != 0) return false;
        }

        return true;
    }
}