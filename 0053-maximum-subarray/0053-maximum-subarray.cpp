class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = INT_MIN;
        // how could I all the possible matches without looping it twice
        // we could use dp to calculate the max of array ending with idx i
        int last = 0;
        for(int end = 0; end < nums.size();end++){
            last = nums[end] + max(last,0);
            res = max(last,res);
        }
        return res;
    }
};