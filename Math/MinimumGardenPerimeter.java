import java.util.*;

public class MinimumGardenPerimeter {

    public long minimumPerimeter(long neededApples) {
        long n = 0;
        long totalApples = 0;
        while(totalApples < neededApples)
        {
            n = n + 1;
            totalApples += 12 * n * n;
        }
        return 8 * n;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long neededApples = sc.nextLong();

        MinimumGardenPerimeter obj = new MinimumGardenPerimeter();
        System.out.println(obj.minimumPerimeter(neededApples));
    }
}