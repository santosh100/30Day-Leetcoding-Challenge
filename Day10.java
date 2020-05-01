class MinStack {

    Stack<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();  
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        min = Math.min(x,min);
        stack.push(x);
    }
    
    public void pop() {
        Stack<Integer> temp = new Stack<>();
        stack.pop();
        
        while(!stack.isEmpty()){            
            temp.push(stack.pop());
        }
        
        min = Integer.MAX_VALUE;
        while(!temp.isEmpty()){
            push(temp.pop());
        }       
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */