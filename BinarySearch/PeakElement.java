import java.util.*;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            int mid = (left + right) / 2;

            if(nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        return left;
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

        PeakElement obj = new PeakElement();
        int result = obj.findPeakElement(nums);

        System.out.println("Peak Element Index: " + result);
        System.out.println("Peak Element Value: " + nums[result]);
    }
}