import java.util.*;

public class MaximumHourglassSum {

    public int maxSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(rows < 3 || cols < 3)
        {
            return 0;
        }

        int maxsum = 0;

        for(int i = 0; i < rows - 2; i++)
        {
            for(int j = 0; j < cols - 2; j++)
            {
                int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2]
                        + grid[i+1][j+1]
                        + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];

                maxsum = Math.max(maxsum, sum);
            }
        }

        return maxsum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        MaximumHourglassSum obj = new MaximumHourglassSum();
        System.out.println(obj.maxSum(grid));
    }
}