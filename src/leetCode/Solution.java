package leetCode;
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String str=new String(c);
            
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
            }
            else{
                map.put(str,new ArrayList<>());
                map.get(str).add(strs[i]);
            }
        }
        return new ArrayList(map.values());
    }
}