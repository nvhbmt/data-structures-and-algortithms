package Trie;

public class ReverseBits {
    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        while (sb.length() < 32) sb.insert(0, '0');
        sb.reverse();
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
}
