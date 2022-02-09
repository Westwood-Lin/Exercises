import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        int k=5;
        Solution s=new Solution();
        System.out.println(s.findKthPositive(arr,k));
    }
    static class Solution {
        Solution(){}
        public int findKthPositive(int[] arr, int k) {
            int maxLen=k+arr[arr.length-1];
            int miss=0;
            Integer[] integers=Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Set<Integer> set=new HashSet<Integer>(Arrays.asList(integers));

            for (int i = 1; i <= maxLen; i++) {
                if(!set.contains(i)){
                    miss++;
                    if(miss==k)
                        return i;
                }
            }
            return 0;
        }
        /*  笨办法：效率其实也不高，时空复杂度都较高： */
        /*
        public int findKthPositive(int[] arr, int k) {
            int miss=0;
            boolean find=false;

            for (int i = 1; i <= k+arr[arr.length-1]; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(i==arr[j]){
                        find=true;
                        break;
                    }
                }
                if(!find){
                    miss++;
                    if(miss==k)
                        return i;
                }
                find=false;
            }
            return 0;
        }
                 */

    }
}
