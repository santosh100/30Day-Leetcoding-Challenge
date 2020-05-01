import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class FirstUnique {
    Queue<Integer> queue;
    HashMap<Integer, Integer> hm;    
    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        hm = new HashMap<>();       
        
        for(int i = 0; i<nums.length ;i++){
            add(nums[i]);
        }
    }
    
    public int showFirstUnique() {
        while(queue.size()>0 && hm.get(queue.peek())>1){
            queue.poll();
        }
        if(queue.size()==0){
            return -1;
        }else{
            return queue.peek();
        }
    }
    
    public void add(int value) {
       if(hm.containsKey(value)){
           hm.replace(value, hm.get(value)+1);
       }else{
           hm.put(value, 1);  
           queue.add(value);
       }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */