import java.util.*;

public class CircularGameWinner {

    public int findTheWinner(int n, int k) {

        int result = 0;

        for(int i = 2; i <= n; i++)
        {
            result = (result + k) % i;
        }

        return result + 1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        CircularGameWinner obj = new CircularGameWinner();
        int winner = obj.findTheWinner(n, k);

        System.out.println("Winner is: " + winner);
    }
}