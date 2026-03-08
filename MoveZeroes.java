import java.util.*;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1)
        {
            return;
        }

        int i = 0;
        int j = 0;

        while(i < n)
        {
            if(nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
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

        MoveZeroes obj = new MoveZeroes();
        obj.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}