package twoPointers;
public class pairSum1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int tar = 4;
        // brute force O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j]==tar){
                    System.out.println("Pairs: ["+arr[i]+","+arr[j]+"]");
                }
            }
        }

        // better - by sorting array then applying two pointers O(nlogn)
        // if input arr is already sorted then O(n) only
        int i=0;
        int j=arr.length-1;
        while (i<j) {
            int sum = arr[i]+arr[j];
            if(sum==tar) {
                System.out.println("Pairs: ["+arr[i]+","+arr[j]+"]");
                break;
            }
            else if(sum<tar) i++;
            else j--;
        }
    }
}
