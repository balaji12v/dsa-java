//In brute force we will through the string multiple time and each time we will delete the adjacent duplicate elements and repeat the same process for the new string.
//it has t.c of O(n^2)
//for optimized we will stack,where we will compare the current character with the top element of the stack and push the current element into the stack if both are different.
//ANd for printing the stack elements into the string we will use string builder.since when we print the results of the stack they are char array.
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        String reulst = "";
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
            st.push(ch);
           }
           else{
            char top = st.peek();
            if(ch == top){
                st.pop();
            }
            else{
                st.push(ch);
            }
           }
        }
        StringBuilder result = new StringBuilder();
        for(char c:st){
            result.append(c);
        }
        return result.toString();
    }
}
