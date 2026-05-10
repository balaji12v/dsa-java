//in brute force we will use dynamic array or list and when we encouter d, we need to go to the previous index and double it .t.c is O(n^2) and s.c is O(n)
// In optimized we will use stack which follows lifo and the t.c is O(n) and s.c is O(n)
class Solution {
    public int calPoints(String[] operations) {
        StringBuilder sb = new StringBuilder();
        Stack <Integer> st = new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                st.pop();
            }
            else if(op.equals("D")){
                st.push(st.peek()*2);
            }
            else if(op.equals("+")){
                int a= st.pop();
                int b = st.peek();
                int c = a+b;
                st.push(a);
                st.push(c);
            }
            else{
                st.push(Integer.parseInt(op));
            }
        }
        int b=0;
        while(!st.isEmpty()){
            b +=st.pop();
        }
        return b;
        
    }
}
