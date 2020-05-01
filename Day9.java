class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        
        int i=0;
        int j=0;
        while(i< S.length() && j<T.length()){
            char c1 = S.charAt(i);
            char c2 = T.charAt(j);
            if(c1 == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }else{
                stack1.push(""+c1);
            }
            
            if(c2 == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }else{
                stack2.push(""+c2);
            }
            i++;
            j++;
        }
        while(i<S.length()){
            char c1 = S.charAt(i);            
            if(c1 == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }else{
                stack1.push(""+c1);
            }
            i++;
        }
        while(j<T.length()){
            char c2 = T.charAt(j);
            if(c2 == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }else{
                stack2.push(""+c2);
            }
            j++;
        }
        
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(!stack1.pop().equals(stack2.pop())){
                return false;
            }
        }
        
        if(!stack1.isEmpty() || !stack2.isEmpty()){
            return false;
        }
        
        return true;
    }
}