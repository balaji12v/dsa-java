//In the brute force approach we will use stack to store thr parenthesis and the t.c = O(n) and s.c = O(n)
class Solution {
    public int maxDepth(String s) {
    int ans = 0;
    Stack <Character> st = new Stack<>();
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) =='('){
            st.push('(');
        }
        else if(s.charAt(i) == ')'){
            st.pop();
        }
        ans = Math.max(ans,st.size());
    }
    return ans;   
    }
}
//In optimized approach we wil use counter variable to store the depth of the parenthesis.Here the t.c =O(n) but s.c is O(1)
class Solution {
    public int maxDepth(String s) {
    int count =0;
    int maxcount = 0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i) =='('){
            count++;
            maxcount = Math.max(maxcount,count);
        }
        else if(s.charAt(i) ==')'){
            count--;
        }
    } 
    return maxcount; 
    }
}
