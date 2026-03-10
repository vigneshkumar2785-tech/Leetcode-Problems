import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Use two maps to ensure a one-to-one relationship
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS.containsKey(charS) && mapS.get(charS) != charT) return false;
            if (mapT.containsKey(charT) && mapT.get(charT) != charS) return false;

            mapS.put(charS, charT);
            mapT.put(charT, charS);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "paper", t1 = "title";
        String s2 = "foo", t2 = "bar";

        System.out.println("Are '" + s1 + "' and '" + t1 + "' isomorphic? " + isIsomorphic(s1, t1));
        System.out.println("Are '" + s2 + "' and '" + t2 + "' isomorphic? " + isIsomorphic(s2, t2));
    }
}
