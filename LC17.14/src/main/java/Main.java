import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(Arrays.toString(s.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
    static class Solution {
        Solution(){}
        public int[] smallestK(int[] arr, int k) {
            Arrays.sort(arr);
            return Arrays.copyOfRange(arr,0,k);
        }
    }
}
