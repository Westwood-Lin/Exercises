import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int X=3;
        int[] D={5,8,2,7};
        Solution s=new Solution();
        System.out.println(s.solution(D,X));
    }
    static class Solution {
        Solution(){}
        public boolean keepDoingTask(int nextTask,ArrayList<Integer> list,int limit){
            if(list.isEmpty())
                return true;
            Collections.sort(list);

            return Math.abs(list.get(0) - nextTask) <= limit && Math.abs(list.get(list.size()-1) - nextTask) <= limit;
        }

        public int solution(int[] D, int X) {
            // write your code in Java SE 8
            if(D==null||D.length<=0)
                return 0;
            else if(D.length==1)
                return 1;

            int day=1;
            int lastIndex=0;
            ArrayList<Integer> difficultInDay=new ArrayList<>();
            difficultInDay.add(D[0]);

            for(;lastIndex<D.length-1;){
                if(keepDoingTask(D[lastIndex+1],difficultInDay,X)){
                    difficultInDay.add(D[lastIndex+1]);
                    lastIndex++;
                }
                else{
                    difficultInDay.clear();
                    difficultInDay.add(D[lastIndex+1]);
                    day++;
                    lastIndex++;
                }
            }
            return day;
        }
    }

}
