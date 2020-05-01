class Solution {
    public boolean checkAnagrams(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        
        int arr[] = new int[26];
        for(int i =0; i<s1.length();i++){
            arr[s1.charAt(i)-97]++;
            arr[s2.charAt(i)-97]--;
        }        
        for(int i : arr){
            if(i != 0)
                return false;
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean visited[] = new boolean[n];
        List<List<String>> listOfLists = new ArrayList<List<String>>();      
        
        for(int i =0; i< n ;i++){            
            List<String> list = new ArrayList<>();
            if(!visited[i]){
                list.add(strs[i]);
                visited[i] = true;
                for(int j=i+1;j<n;j++){
                    if(checkAnagrams(strs[i],strs[j])){
                        visited[j] = true;
                        list.add(strs[j]);
                    }
                }
                listOfLists.add(list);
            }            
        }       
        return listOfLists;
    }
}