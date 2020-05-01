import java.util.HashMap;
class Solution {    
    public int findMaxLength(int[] nums) {        
        HashMap<Integer,Integer> hm = new HashMap<>();
             // count, index
        int count = 0;
        int maxSubArray = 0;
        hm.put(0, -1);
        for(int index=0; index<nums.length; index++){
            
            if(nums[index] == 1){
                count++;
            }else{
                count--;
            }
            if(hm.containsKey(count)){
                maxSubArray = Math.max(maxSubArray , index - hm.get(count));
            }else{
                hm.put(count,index);
            }
        }
        return maxSubArray;
    }
}