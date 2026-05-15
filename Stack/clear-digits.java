//in brute firce approach for these problem we will go through the string and when we see a digit we will delete it and the (i-1) element also and again 
//start from the start of the string (shorter).so these has a t.c of O(n^2) and for storing the string(ans) s.c O(n)

//In the optimized approach we will use stack and when we encounter a digit we will do pop operation,so it will remove the (i-1) element automatically and the 
//t.c is O(n) and s.c is O(n)

class Solution {
    public String clearDigits(String s) {
    Stack <Character> st = new Stack<>();
    StringBuilder ab = new StringBuilder();
    for(int i=0;i<s.length();i++){
        if(Character.isDigit(s.charAt(i))){
            st.pop();
        }
        else{
            st.push(s.charAt(i));
        }
    } 
    for(char c:st){  //while(!st.isEmpty())
        ab.append(c);//ab.append(st.pop());
    }
    return ab.toString();
    }
}
