import java.util.*;

public class CountOperationsToZero {

    public int countOperations(int num1, int num2) {

        System.out.println("Current Values -> num1: " + num1 + " num2: " + num2);

        if(num1 * num2 == 0)
        {
            System.out.println("One value became zero. Stop.");
            return 0;
        }

        if(num1 > num2)
        {
            System.out.println("Subtract num2 from num1");
            return 1 + countOperations(num1 - num2, num2);
        }
        else
        {
            System.out.println("Subtract num1 from num2");
            return 1 + countOperations(num1, num2 - num1);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        CountOperationsToZero obj = new CountOperationsToZero();
        int result = obj.countOperations(num1, num2);

        System.out.println("Total Operations: " + result);
    }
}