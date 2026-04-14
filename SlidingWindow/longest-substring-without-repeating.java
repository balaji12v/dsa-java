// Problem: Longest Substring Without Repeating Characters (LC 3)

// Pattern: Sliding Window

// Approach:
// 1. Use two pointers (left, right)
// 2. Use HashSet to track characters in window
// 3. If duplicate found → move left pointer
// 4. Update max length

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
                return 0;
            }
        HashMap<Character,Integer> hm = new HashMap<>();
      
        int l=0;
        int max =0;
   
        
        for(int r=0;r<s.length();r++){
            
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)+1);
            while(hm.get(s.charAt(r))>1){
                char left =s.charAt(l);
                hm.put(left,hm.get(left)-1);
                if(hm.get(left) ==0){
                    hm.remove(left);
                }
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
