import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        String A="dBacaAA";
        String B="caBdaaA";
        System.out.println(s.solution(A,B));
    }
    static class Solution {
        Solution(){}
        public int solution(String A, String B) {
            // write your code in Java SE 8

            //special judgement
            if(A==null||B==null||A.equals("")||B.equals(""))
                return 0;
            if(A.equals(B))
                return A.length()*(A.length()+1)/2;

            //hashmap
            HashMap<Character, Integer> map=new HashMap<>();
            char i1='a';
            char i2='A';
            for (int i = 0; i < 26; i++) {
                map.put(i1,0);
                i1++;
            }
            for (int i = 0; i < 26; i++) {
                map.put(i2,0);
                i2++;
            }

            //
            int cnt=0;
            for (int len = 1; len <= A.length() ; len++) {
                for (int index = 0; index + len <= A.length(); index++) {
                    if(fragEquals(A.substring(index,index+len),B.substring(index,index+len),map)){
                        cnt++;
                    }
                    //reset map
                    map.forEach( (key,value) -> {
                        map.put(key,0);
                    });
                }

                map.forEach( (key,value) -> {
                    map.put(key,0);
                });
            }
            return cnt;
        }

        public boolean fragEquals(String a,String b,HashMap<Character, Integer> map){
            for (int i = 0; i < a.length(); i++) {
                map.put(a.charAt(i),map.get(a.charAt(i))+1);
                map.put(b.charAt(i),map.get(b.charAt(i))-1);
            }
            for (Character c:map.keySet()) {
                if(map.get(c)!=0)
                    return false;
            }
            return true;
        }

    }
}
