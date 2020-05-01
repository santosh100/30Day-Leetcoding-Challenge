class Solution {
    public boolean checkValidString(String s) {
        /*********** Approach 1 ******************/
        /*
        int leftCount = 0;
        int rightCount =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*')
                leftCount++;
            else
                leftCount--;
            if(leftCount < 0)
                return false;
        }
        
        if(leftCount == 0){
            return true;       
        }
        
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*')
                rightCount++;
            else
                rightCount--;
            
            if(rightCount < 0){
                return false;
            }
        }
        return true;
        */
        
        /**************** Approach 2 ******************/
        Stack<Integer> leftParenIndexStack = new Stack<>();
        Stack<Integer> astriskIndexStack = new Stack<>();
        for(int index =0; index < s.length(); index++){
            if(s.charAt(index) == '(' ){
                leftParenIndexStack.push(index);
            }else if(s.charAt(index) == '*'){
                astriskIndexStack.push(index);
            }else{
                if(!leftParenIndexStack.isEmpty()){
                    leftParenIndexStack.pop();
                }else if(!astriskIndexStack.isEmpty()){
                    astriskIndexStack.pop();
                }else{
                    return false;
                }
            }            
        }
        while(!leftParenIndexStack.isEmpty() && !astriskIndexStack.isEmpty()){
            if(leftParenIndexStack.peek() > astriskIndexStack.peek()){
                return false;
            }
            leftParenIndexStack.pop();
            astriskIndexStack.pop();
        }
        return leftParenIndexStack.size() == 0;
    }
}