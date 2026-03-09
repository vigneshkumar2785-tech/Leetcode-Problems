import java.util.*;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reversenumber = 0;
        int Originalnumber = x;

        if(x < 0)
        {
            return false;
        }

        while(x != 0)
        {
            int digit = x % 10;
            reversenumber = reversenumber * 10 + digit;
            x = x / 10;
        }

        if(Originalnumber == reversenumber)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        PalindromeNumber obj = new PalindromeNumber();
        boolean result = obj.isPalindrome(x);

        System.out.println(result);
    }
}