// Problem: Fruit Into Baskets (LC 904)

// Pattern: Sliding Window

// Approach:
// 1. Use sliding window with two pointers
// 2. Maintain a hashmap to track fruit count
// 3. If distinct fruits > 2 → shrink window
// 4. Track max window size

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int totalFruit(int[] fruits) {
       int l=0;
       HashMap<Integer,Integer> hm = new HashMap<>();
       int maxlen = 0;
       for(int r=0;r<fruits.length;r++){
        int chr = fruits[r]; 
        hm.put(chr,hm.getOrDefault(chr,0)+1);
        while(hm.size()>2){
            int chl = fruits[l];
            hm.put(chl,hm.get(chl)-1);
            if(hm.get(chl) ==0){
                hm.remove(chl);
            }
            l++;
        }
        maxlen = Math.max(maxlen,r-l+1);
       } 
       return maxlen;
    }
}
