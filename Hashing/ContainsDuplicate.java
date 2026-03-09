import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
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

        ContainsDuplicate obj = new ContainsDuplicate();

        boolean result = obj.containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }
}