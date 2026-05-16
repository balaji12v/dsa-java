// for these solution i have used two stacks.one as st and other is temp named stacks.if st is empty i will push the input to the st,if it is not empty then i will
//pop elements from the st until it is empty and push them paralley to the temp and then push the input to the st and then same again i will pop elements from temp and
// push them to st for every element i will do these so the st is going to behave like a queue.
class MyQueue {
    Stack<Integer>st;
    Stack<Integer>temp;
    public MyQueue() {
        st = new Stack<>();
        temp = new Stack<>();
        
    }
    
    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
        }
        else{
            while(!st.isEmpty()){
                int a=st.pop();
                temp.push(a);
            }
            st.push(x);
            while(!temp.isEmpty()){
                int b =temp.pop();
                st.push(b);
            }
        }
        
    }
    
    public int pop() {
        return st.pop();
        
    }
    
    public int peek() {
        return st.peek();
        
    }
    
    public boolean empty() {
        return st.isEmpty();
        
    }
}

