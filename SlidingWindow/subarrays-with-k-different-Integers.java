// Problem: Subarrays with K Different Integers (LC 992)

// Pattern: Sliding Window (Advanced)

// Approach:
// 1. Use helper function to calculate "at most K"
// 2. Exactly K = atMost(K) - atMost(K-1)
// 3. Use sliding window and count subarrays using (r - l + 1)


// we will use these atmost pattern when we need to find the exactly k ,this works by at most(k) - at most(k-1)
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int atmost(int[] nums,int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l=0;
        int ans=0;
        for(int r=0;r<nums.length;r++){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.size()>k){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
      int a =  atmost(nums,k) - atmost(nums,k-1);
      return a; 
    }
}
