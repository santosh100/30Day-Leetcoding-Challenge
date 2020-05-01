class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int repeated = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                repeated++;
            }else if(arr[i]+1 == arr[i+1]){
                count += 1 + repeated;
                repeated=0;
            }else{
                repeated = 0;
            }
        }
        return count;
    }
}