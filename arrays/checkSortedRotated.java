package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class checkSortedRotated {
    // solution 1 - create all the type of rotations possible and match it with
    // input TC -> O(n^2) nd SC -> O(n)
    public static boolean check1(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p = i;
            ArrayList<Integer> com = new ArrayList<>();
            for (int j = p; j < nums.length; j++) {
                com.add(nums[j]);
            }
            for (int j = 0; j <= p - 1; j++) {
                com.add(nums[j]);
            }
            if (com.equals(res)) {
                return true;
            }
        }
        return false;
    }

    // sol 2 - similar to above brute force only change is that we are comparing it using formula O(n^2)
    public static boolean check2(int[] nums) {
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int x = 0;
        while (x < nums.length) {
            boolean isX = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != temp[(i + x) % nums.length]) {
                    isX = false;
                    break;
                }
            }
            if (isX)
                return true;
            x++;
        }
        return false;
    }

    // sol 3 - most optimized sol TC -> O(n) and SC -> O(1) 
    // logic - if arr is rotated and sorted then it will violated the ascending order property only once 
    // or never but if more than that then false becz the arr is rotated we will check for 0 and n-1 also
    public static boolean check3(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                count++;
            }
        }
        if(count<=1) return true;
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        System.out.println(check1(arr));
        System.out.println(check2(arr));
        System.out.println(check3(arr));
    }
}
