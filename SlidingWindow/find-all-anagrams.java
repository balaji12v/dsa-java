// Problem: Find All Anagrams in a String (LC 438)

// Pattern: Sliding Window (Fixed Size)

// Approach:
// 1. Maintain a fixed window of size k (length of string p).
// 2. Use a HashMap 'hmp' for the target frequencies and 'hms' for the current window frequencies.
// 3. When the window size exceeds k, "release" the character at the left pointer and remove it from the map if its count hits zero.
// 4. Use a helper function 'isanagram' to compare the two HashMaps whenever the window size is exactly k.

// Time Complexity: O(n * 26) which simplifies to O(n), where n is the length of string s.
// Space Complexity: O(1) because the HashMaps store at most 26 lowercase English letters.

class Solution {
    public static boolean isanagram(HashMap<Character,Integer>hms,HashMap<Character,Integer>hmp){
        if(hms.size() != hmp.size()){
            return false;
        }
        for(char key:hms.keySet()){
            if(!hmp.containsKey(key)){
                return false;
            }
            int a = hms.get(key);
            int b = hmp.get(key);
            if(a !=b){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> hms = new HashMap<>();
        HashMap<Character,Integer>hmp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char chp =p.charAt(i);
            hmp.put(chp,hmp.getOrDefault(chp,0)+1);
        }
        int l=0;
        int k=p.length();
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            hms.put(ch,hms.getOrDefault(ch,0)+1);
            if(r-l ==k){
                char chl = s.charAt(l);
                hms.put(chl,hms.get(chl)-1);
                if(hms.get(chl)==0){
                    hms.remove(chl);
                }
                l++;
            }
            if(r-l+1 == k){
                boolean a = isanagram(hms,hmp);
                if(a){
                    ans.add(l);
                }
            }
        }
        return ans;

    }
}
