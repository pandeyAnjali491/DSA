package hashmap;

import java.util.HashMap;

public class twoSum {
    // most optimized sol if inp arr is not sorted
    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int tar = 6;
        HashMap<Integer,Integer> hp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = tar-arr[i];
            if(hp.containsKey(diff)){
                System.out.println("Pairs: ["+hp.get(diff)+","+i+"]");
                break;
            }
            hp.put(arr[i],i);
        }
    }
}