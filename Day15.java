class Solution {
    public int[] productExceptSelf(int[] nums) {                       
        
        // One approach
        
        int n = nums.length;
        int leftProd[]  = new int[n];
        int rightProd[] = new int[n];
    
        int lProd = 1;
        int rProd = 1;
        for(int i=0;i<n;i++){
            lProd *= nums[i];
            rProd *= nums[n-1-i];
            leftProd[i] = lProd;
            rightProd[n-1-i] = rProd;
        }
        nums[0] = rightProd[1];
        nums[n-1] =leftProd[n-2];
        for(int i=1;i<n-1;i++){
            nums[i] = leftProd[i-1] * rightProd[i+1];
        }    
        return nums;
        

        // Another approach
        /*
        int n = nums.length;
        int leftProd[]  = new int[n];
        int rightProd[] = new int[n];
    
        int lProd = 1;
        int rProd = 1;
        for(int i=0;i<n;i++){
            leftProd[i] = lProd;
            rightProd[n-1-i] = rProd;
            lProd *= nums[i];
            rProd *= nums[n-1-i];                        
        }        
        for(int i=0;i<n;i++){
            nums[i] = leftProd[i] * rightProd[i];
        }    
        return nums;
        */
    }
}