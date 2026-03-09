import java.util.*;

class MountainArray {
    int[] arr;

    MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

public class FindInMountainArray {

    static int binarysearch(MountainArray mountainArr, int target , int start , int end , boolean increasing)
    {
        while(start <= end)
        {
            int mid = (start + end) / 2;
            int midElement = mountainArr.get(mid);

            if(midElement == target)
            {
                return mid;
            }

            if(increasing && midElement < target || !increasing && midElement > target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findpeek(MountainArray mountainArr ,int n)
    {
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            int mid = (left + right) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1))
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

    public int findInMountainArray(int target, MountainArray mountainArr) 
    {
        int n = mountainArr.length();
        int peek = findpeek(mountainArr,n);

        int result = binarysearch(mountainArr,target,0,peek,true);

        if(result != -1)
        {
            return result;
        }

        return binarysearch(mountainArr,target,peek + 1,n - 1,false);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        MountainArray mountainArr = new MountainArray(arr);

        FindInMountainArray obj = new FindInMountainArray();

        int result = obj.findInMountainArray(target, mountainArr);

        System.out.println("Target Index: " + result);
    }
}