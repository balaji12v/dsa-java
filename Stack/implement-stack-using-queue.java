//In brute force approach we will use two queue,the second one as temporary storage to store the reverse order of the elements.t.c is O(n) and s.c is O(2n)
//in the optimized approach instead of 2 queues, we only use one queue and when we need to perform a push operation we will remove and add the elements of queue.size()-1 times
//so that it will also behave like a stack and here t.c is same and s.c is O(n)
class MyStack {
    Queue<Integer> q;
    public MyStack() {
       q= new LinkedList<>(); 
    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            int a =q.poll();
            q.add(a);
        }
        
    }
    
    public int pop() {
        return q.poll();
        
    }
    
    public int top() {
       return q.peek();
        
    }
    
    public boolean empty() {
       return q.isEmpty();
        
    }
}

