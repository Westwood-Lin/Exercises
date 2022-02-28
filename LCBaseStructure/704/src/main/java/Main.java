public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int search(int[] nums, int target) {
            for (int low=0,high=nums.length-1,mid=0;low<=high;){
                mid=(low+high)/2;
                if(nums[mid]==target)
                    return mid;
                else if(nums[mid]<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
            return -1;
        }
    }
}
