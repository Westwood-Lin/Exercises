import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,1};
        solution.sortEvenOdd(nums);
        System.err.println(1);
    }
    static class Solution {
        Solution(){}
        public int[] sortEvenOdd(int[] nums) {
            ArrayList<Integer> odd= new ArrayList<Integer>(),even = new ArrayList<Integer>();
            for (int i = 0,j=0,k=0; i < nums.length; i++) {
                if(i%2==0)
                    even.add(nums[i]);
                else
                    odd.add(nums[i]);
            }

            odd.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1>=o2)
                        return -1;
                    else
                        return 1;
                }
            });
            even.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1<=o2)
                        return -1;
                    else
                        return 1;
                }
            });
            for (int i = 1, j = 0 ; j<odd.size() ; j++,i+=2) {
                even.add(i,odd.get(j));
            }
            return even.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
