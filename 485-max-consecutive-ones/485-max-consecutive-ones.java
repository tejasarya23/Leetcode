class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=-1;int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                max=Math.max(max,count);
                count=0;
            }
        }
        max=Math.max(max,count);
        return max;
    }
}