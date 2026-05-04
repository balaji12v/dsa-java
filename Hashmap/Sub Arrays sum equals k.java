//in Brute force we will find all the pair of subarrays using two for loops
  class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum = sum + nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}
// in the optimized approach we will solve it by using hashamp and key point to rremember is:
//at first only we will keep 0,1 into the hashmap.so that if the first element is equal to the k then we can also count it as a valid subarray
  class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int currsum =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            currsum += nums[i]; 
            
            if(hm.containsKey(currsum-k)){
                count += hm.get(currsum-k);
            }
            hm.put(currsum,hm.getOrDefault(currsum,0)+1);
        }
        return count;
    }
}
