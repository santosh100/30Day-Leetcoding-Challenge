class Solution {
    public String stringShift(String s, int[][] shift) {
        
        
        int count = 0;
        for(int i=0;i<shift.length;i++){
            if(shift[i][0] == 0){
                count -= shift[i][1];
            }else{
                count += shift[i][1];
            }
        }
        count = count % s.length();        
        if(count < 0){
            String temp = s.substring(0,-count);
            s = s.substring(-count,s.length());
            s += temp;
        }else if(count > 0){
            String temp = s.substring(s.length()-count, s.length());            
            s = s.substring(0,s.length()-count);             
            s = temp + s;            
        }
        return s;
    }
}