package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {
        final String s = "cbaebabacd";
        final String p = "abc";
        Find_All_Anagrams_in_a_String entity = new Find_All_Anagrams_in_a_String();
        System.out.println(entity.findAnagrams(s, p));

    }

    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (p.length() > s.length()) {
            return ret;
        }
        Map<Character, Integer> map = new HashMap<>();
        // put all char in t to array
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0;
        int end = 0;
//        int head = 0;
//        int len = Integer.MAX_VALUE;

        while (end<s.length()) {
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            System.out.println("map: " + map);
            end++;

            while(counter == 0) {
                System.out.println("map when counter ==0: " + map);
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                System.out.println("map after contains: " + map);
                if(end-begin == p.length()){
                    System.out.println("add to result: " + begin);
                    ret.add(begin);
                }
                begin++;
            }
        }
        return ret;
    }
}
