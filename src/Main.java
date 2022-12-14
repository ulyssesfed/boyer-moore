import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boyerMoore(getInput("enter the string to search through"), getInput("enter the string to search for"));

    }
    public static void boyerMoore(String text, String pattern) {
        // Preprocessing
        int[] right = new int[256];
        Arrays.fill(right, -1);
        for (int i = 0; i < pattern.length(); i++) {
            right[pattern.charAt(i)] = i;
        }

        // Searching
        int m = pattern.length();
        int n = text.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                // Found pattern, print text with brackets around pattern
                System.out.println(text.substring(0, i) + "[" + pattern + "]" + text.substring(i + m));
                i += m - 1;
            }
        }
    }


    public static String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();

    }

}