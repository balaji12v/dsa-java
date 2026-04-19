// Problem: Max consecutive ones III(1004)

// Pattern: Sliding Window 

// Approach 1:
// 1. Use temp variable to store count of "0's"
// 2. if temp >k,then move the left pointer and if l value is 0 then temp--,so the loop breaks.
// 3. calculate the max len by using math.max(maxlen,r-l+1)

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int temp =0;
        int ans =0;
        int l=0;
        for(int r=0;r<n;r++){
            if(nums[r] ==0){
                temp++;
            }
            while(temp>k){
                if(nums[l]==0){
                    temp--;
                }
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}

// Approach 2:
//1.In these i used a hashmap to store the frequency of each value and if the frequency of 0 is greater than k then move left pointer
class Solution {
    public int longestOnes(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l=0;
        int maxlen =0;
        for(int r=0;r<nums.length;r++){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.getOrDefault(0,0)>k){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
        
    }
}
