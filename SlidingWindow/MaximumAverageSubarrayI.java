import java.util.*;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        double cursum = 0;
        double maxsum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
        {
            cursum += nums[i];

            if(i >= k - 1)
            {
                maxsum = Math.max(cursum, maxsum);
                cursum -= nums[i - k + 1];
            }
        }

        return maxsum / k;
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

        int k = sc.nextInt();

        MaximumAverageSubarrayI obj = new MaximumAverageSubarrayI();
        double result = obj.findMaxAverage(nums, k);

        System.out.println("Maximum Average: " + result);
    }
}