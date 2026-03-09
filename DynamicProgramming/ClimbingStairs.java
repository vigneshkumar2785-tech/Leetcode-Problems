import java.util.*;

public class ClimbingStairs {

    public int climbStairs(int n) {

        int num1 = 1;
        int num2 = 1;

        for(int i = 2; i <= n; i++)
        {
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }

        return num2;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ClimbingStairs obj = new ClimbingStairs();

        int result = obj.climbStairs(n);

        System.out.println("Total Ways: " + result);
    }
}