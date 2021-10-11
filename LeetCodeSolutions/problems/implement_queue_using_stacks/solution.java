class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    private int front;
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(s1.isEmpty()) {
            front = x;
        }
        
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int temp = s2.pop();
        if(!s2.isEmpty()) {
            front = s2.pop();
            s2.push(front);
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        return temp;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */