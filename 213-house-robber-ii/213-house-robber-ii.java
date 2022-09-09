class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        int dp[]= new int[nums.length];
        int max=0;
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[2];
        int a=rob(nums,0,nums.length-2);
        int b=rob(nums,1,nums.length-1);
        // System.out.print(a+" "+b);
        return Math.max(a,b);
    }
    public int rob(int A[],int l,int h){
        int nums[]=Arrays.copyOfRange(A,l,h+1);
        int n=nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int arr[]=new int[n];
        arr[0]=nums[0];
        arr[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<n;i++){
            arr[i]=Math.max(arr[i-1],(nums[i]+arr[i-2]));
            //System.out.print(Arrays.toString(arr));
        }
        
        return arr[n-1];
    }
}