import java.util.*;

public class MinimumDeletionsToMakeArrayDivisible {

    static int gcd(int val1, int val2)
    {
        if(val2 == 0)
        {
            return val1;
        }
        return gcd(val2, val1 % val2);
    }

    public int minOperations(int[] nums, int[] numsDivide)
    {

        Arrays.sort(nums);

        int initial = numsDivide[0];
        for(int i = 1; i < numsDivide.length; i++)
        {
            initial = gcd(initial, numsDivide[i]);
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(initial % nums[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] numsDivide = new int[m];
        for(int i = 0; i < m; i++)
        {
            numsDivide[i] = sc.nextInt();
        }

        MinimumDeletionsToMakeArrayDivisible obj = new MinimumDeletionsToMakeArrayDivisible();
        System.out.println(obj.minOperations(nums, numsDivide));
    }
}