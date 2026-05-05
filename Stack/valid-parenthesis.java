// In brute we will find the shortest valid parenthesis and remove them and if the length after removing parenthesis is less then the past length then we will continue removing the other valid parenthesis
class Solution {
    public boolean isValid(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "")
                 .replace("[]", "")
                 .replace("{}", "");
        } while (s.length() < length); // Keep going as long as the string is getting shorter

        return s.length() == 0;
    }
}
// t.c =O(n^2)

// for optimized approach we will use stack(lifo) in which we will check the current charachter with the top of the stack and if they both form a valid parenthesis we will pop(delete) them from the stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='[' || ch == '{' || ch =='('){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if(top =='[' && ch != ']'){
                    return false;
                }
                if(top =='(' && ch != ')'){
                    return false;
                }
                if(top =='{' && ch != '}'){
                    return false;
                }
            }

        }
        return st.isEmpty();
    }
}
