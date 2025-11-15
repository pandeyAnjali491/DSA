package twoPointers;
public class containerWithMostWater {
    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        int maxArea =0;

        // brute force O(n^2)
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i+1; j < arr.length; j++) {
        //         int height = Math.min(arr[i], arr[j]);
        //         int width = j-i;
        //         int area = height*width;
        //         maxArea = Math.max(maxArea, area);
        //     }
        // }

        // 2 pointers - optimized O(n)
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            int height = Math.min(arr[i], arr[j]);
            int width = j-i;
            int area = height*width;
            maxArea = Math.max(maxArea, area);
            if(arr[i]<arr[j]) i++;
            else j--;
        }
        System.out.println("max area: "+maxArea);
    }
}
