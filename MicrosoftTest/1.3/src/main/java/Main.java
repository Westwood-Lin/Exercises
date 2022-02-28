import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int a=-5;
        int b=3;
        System.out.println(a%b);
    }

    public static void mapAdd(Integer value,HashMap<Integer, Integer> map){
        if(map.containsKey(value))
            map.put(value,map.get(value)+1);
        else
            map.put(value,1);
    }

    static class Solution {
        public int solution(int[] A, int M) {
            // write your code in Java SE 8
            //special judgement 特判
            if(A==null||A.length==0)
                return 0;
            else if(A.length==1)
                return A[0]%M==0?1:0;
            if(M==1)
                return A.length;

            //mod 取模，至关重要
            for (int i = 0; i < A.length; i++) {
                A[i]=A[i]%M;
                if(A[i]<0)
                    A[i]+=M;
            }

            //余数——次数映射，按余数对数组A做一个划分 map
            HashMap<Integer, Integer> remainFrequencyHashMap=new HashMap<>();
            for (int a:A)
                mapAdd(a,remainFrequencyHashMap);

            //找到划分map中，集合元素最多 且 集合元素超过1个 的集合。
            int max=0;
            for (Integer i: remainFrequencyHashMap.keySet()) {
                if(remainFrequencyHashMap.get(i)>=2 && remainFrequencyHashMap.get(i)>max)
                    max=remainFrequencyHashMap.get(i);
            }

            //如果找完划分map以后，发现不存在集合元素超过1的集合，那就看能不能返回一个元素，也就是本身就能被 M 整除的那个元素。
            if(max==0 && remainFrequencyHashMap.containsKey(0)){
                max=remainFrequencyHashMap.get(0)>0?
                        remainFrequencyHashMap.get(0):0;
            }

            return max;
        }
    }

}
