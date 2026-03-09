import java.util.*;

public class MaximumVowelsSubstring {

    public int maxVowels(String s, int k) {

        int n = s.length();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        int maxCount = count;

        for (int i = k; i < n; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }

            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int k = sc.nextInt();

        MaximumVowelsSubstring obj = new MaximumVowelsSubstring();

        int result = obj.maxVowels(s, k);

        System.out.println("Maximum Vowels in Substring: " + result);
    }
}