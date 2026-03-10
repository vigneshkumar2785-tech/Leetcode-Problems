public class Subsequences {

    public static void printSubsequences(String input, String current) {
        if (input.isEmpty()) {
            if (!current.isEmpty()) { 
                System.out.println(current);
            }
            return;
        }

        printSubsequences(input.substring(1), current + input.charAt(0));

        printSubsequences(input.substring(1), current);
    }

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("Subsequences of " + str + ":");
        printSubsequences(str, "");
    }
}
