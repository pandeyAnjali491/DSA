package prefixArray;
public class trappingRain {
    public static void main(String[] args) {
        int height[] = { 0,1,0,2,1,0,1,3,2,1,2,1 };
        int n = height.length;
        int pre[] = new int[n];
        int post[] = new int[n];
        pre[0] = 0;
        post[n-1] = 0;
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1],height[i-1]); 
        }
        for(int i=n-2;i>=0;i--){
            post[i] = Math.max(post[i+1],height[i+1]); 
        }
        int res = 0;
        for(int i=0;i<n;i++){
            int min = Math.min(pre[i],post[i]);
            if(height[i]>min) continue;
            res += min - height[i];
        }
        System.out.println(res);
    }
}