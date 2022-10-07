class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]= new int[2];
        // if(nums.length==1){
        //     if(nums[0]==target){
        //         res[0]=0;res[1]=0;
        //         return res;
        //     }else{
        //         res[0]=-1;res[1]=-1;
        //         return res;
        //     }
        // }
        int si=0;int ei=nums.length;int ind=0;
        while(true){
            ind=Arrays.binarySearch(nums,si,ei,target);
          
            if(ind<0){res[0]=-1;res[1]=-1;return res;}
            if(ind==0){res[0]=0;break;}
            if((ind>0&&nums[ind]!=nums[ind-1])){
                break;
            }else if(ind>0&&nums[ind]==nums[ind-1]){
                ei=ind;
            }
        }
        res[0]=ind;
        si=ind;ei=nums.length;
        while(true){
            ind=Arrays.binarySearch(nums,si,ei,target);
              // System.out.print(ind);
            if(ind==nums.length-1){res[1]=nums.length-1;return res;}
            if((nums[ind]!=nums[ind+1])){
                break;
            }else if(nums[ind]==nums[ind+1]){
                si=ind+1;
            }
        }
        res[1]=ind;
        return res;
    }
}