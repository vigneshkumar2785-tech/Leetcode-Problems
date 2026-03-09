import java.util.*;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> s = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(i > k)
            {
                s.remove(nums[i - k - 1]);
            }

            if(!s.add(nums[i]))
            {
                return true;
            }
        }

        return false;
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

        ContainsDuplicateII obj = new ContainsDuplicateII();

        boolean result = obj.containsNearbyDuplicate(nums, k);

        System.out.println("Nearby Duplicate Exists: " + result);
    }
}