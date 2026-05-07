//The brute is to find all the subarrays and check whether there sum is greater or equal to the target or not ,which has t.c of O(n^2)
// for optimized solution we will use the two pointer appraoch where we keep the left and right pointer at 0 index and then we will maintain currsum variable until the currsum < target
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_len = Integer.MAX_VALUE;
        int l=0;
        int currsum =0;
        for(int r=0;r<nums.length;r++){
            currsum +=nums[r];
            while(currsum>=target){
                min_len = Math.min(min_len,r-l+1);
                currsum -=nums[l];
                l++;
            }
        }
        return (min_len ==Integer.MAX_VALUE) ?0:min_len;
    }
}
