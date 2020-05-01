class Solution {
    
    //NOTE: Remember always, Either left will be sorted or right will be sorted in case of rotated sorted array
    
    // Modified Binary Search
    public int helper(int nums[], int target, int low ,int high){
        if(nums == null || nums.length == 0 || low > high)
            return -1;        
            
        int mid = (low + high)/2;
        if(target == nums[mid]){
            return mid;
        }
        
        if(nums[low] <= nums[mid]){     // Left Half is sorted
            if(target >= nums[low] && target <= nums[mid])  
                return helper(nums, target, low, mid-1);           // Key is present in left side
            else                                            
                return helper(nums, target, mid+1, high);          // Key may present in right side
            
        }else{               // Right must be sorted(i.e. if left is not sorted then right will always be sorted)
            if(target >= nums[mid+1] && target <= nums[high])  
                return helper(nums, target, mid+1, high);          // Key is present in left side
            else                                            
                return helper(nums, target, low, mid-1);           // Key may present in right side
        }
    }
    public int search(int[] nums, int target) {
        return helper(nums,target, 0, nums.length-1);
    }
}