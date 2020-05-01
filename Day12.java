class Solution {
    public int lastStoneWeight(int[] stones) {  
        
        // Solution one  working fine
        
        int countN = stones.length;
        if(countN == 0){
            return 0;
        }
        if(countN == 1){
            return stones[0];
        }
        int y = 1;
        int x = 0;
        while(countN > 0){
            y = 1;
            x = 0;
            if(stones[0] > stones[1]){
                y = 0;
                x = 1;
            }            
            for(int i=2;i<stones.length;i++){
                if(stones[i] >= stones[y]){
                    x = y;
                    y = i;
                }else if(stones[i] >= stones[x]){
                    x = i;
                }
            }
            
            if(stones[x] == stones[y]){
                stones[x] = 0;
                stones[y] = 0;
                countN -= 2;
            }else{
                stones[y] = stones[y] - stones[x];
                stones[x] = 0;
                countN--;
            }
        }       
        return stones[y];        
        
        
        
        /*
        // Solution - two Using PriorityQueue ie. heap  // but takes more time than me
        PriorityQueue<Integer> maxHeap = new PriorityQueue();    // Note: priority queue is min heap by default
        for(int stone : stones){
            maxHeap.add(-stone);   // Negate the value to make maxHeap
        }
        
        while(maxHeap.size() > 1){
            int y = -maxHeap.remove();  // Negate sign to get original value back
            int x = -maxHeap.remove();  // Negate sign to get original value back
            if(y != x){
                maxHeap.add(-(y-x));    // Negate while adding to make maxHeap
            }            
        }
       return maxHeap.isEmpty() ? 0 : -maxHeap.remove();      // Negate value while returning
        */
    }
}