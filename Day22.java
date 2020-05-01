class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums == null || nums.length == 0)
            return 0;              
       
       /*
        int count=0;
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            int j = i+1;
            while(temp < k && j< nums.length){
                temp += nums[j++];
            }
            if(temp == k)
                count++;
        }
        return count;
        */
        int n = nums.length;
        HashMap <Integer, Integer> prevSum = new HashMap<>();  
        
        int res = 0;                 
        int currsum = 0;          
        for (int i = 0; i < n; i++) {  
                   
            currsum += nums[i];  
			
            if (currsum == k)   
                res++;          
			
            if (prevSum.containsKey(currsum - k))   
                res += prevSum.get(currsum - k);                                    
            Integer count = prevSum.get(currsum); 
            if (count == null) 
                prevSum.put(currsum, 1); 
            else
                prevSum.put(currsum, count+1);  
        }  
        
        return res;  
    }
}