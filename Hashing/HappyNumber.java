import java.util.*;

public class HappyNumber {

    static int sumDigit(int n)
    {
        int count = 0;

        while (n > 0)
        {
            int digit = n % 10;
            count = count + digit * digit;
            n = n / 10;
        }

        return count;
    }

    public static boolean isHappy(int n)
    {
        HashSet<Integer> set = new HashSet<>();

        while(n != 1)
        {
            if(set.contains(n))
            {
                return false;
            }

            set.add(n);
            n = sumDigit(n);
        }

        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean result = isHappy(n);

        System.out.println("Is Happy Number: " + result);
    }
}