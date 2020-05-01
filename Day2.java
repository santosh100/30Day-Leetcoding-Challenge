class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            int t = n;
            int sum = 0;
            while(t != 0){
                sum += (t % 10) * (t % 10);
                t /= 10;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n = sum;
        }
        return true;
    }
}