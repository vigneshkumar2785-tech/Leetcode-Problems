import java.util.*;

public class ValidWord {

    public boolean isValid(String word) {

        int n = word.length();
        if(n < 3) {
            return false;
        }

        boolean vowel = false;
        boolean consonant = false;

        for(char c : word.toCharArray()) {
            if(!Character.isLetterOrDigit(c)) {
                return false;
            }

            char lower = Character.toLowerCase(c);

            if(lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowel = true;
            }
            else if(Character.isLetter(c)) {
                consonant = true;
            }
        }

        return vowel && consonant;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidWord obj = new ValidWord();
        String word = sc.nextLine();
        System.out.println(obj.isValid(word));
    }
}