

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();
        

        for (String s : strs){
            // Convert to char array 
            char[] temp = s.toCharArray();
            // Sort the chars as anagrams become equal after sorting
            Arrays.sort(temp);
            // Convert back to string
            String newS = new String(temp);

            // Store the sorted value as string and append the original string to an array
            map.computeIfAbsent(newS, k-> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = sol.groupAnagrams(strs);
        System.out.println(ans);

        GroupAnagrams sol2 = new GroupAnagrams();
        String[] strs2 = {""};
        List<List<String>> ans2 = sol2.groupAnagrams(strs2);
        System.out.println(ans2);

        GroupAnagrams sol3 = new GroupAnagrams();
        String[] strs3 = {"a"};
        List<List<String>> ans3 = sol3.groupAnagrams(strs3);
        System.out.println(ans3);
    }
}
    

