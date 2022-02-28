public class Main {
    public static void main(String[] args) {
        long value=1702766719;
        int n=2126753390;
        Solution s=new Solution();
        System.out.println(s.firstBadVersion(n,value));
    }
    public static boolean isBadVersion(long version,long value){
        return version==value;
    }
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    //变种二分查找法
    //long型变量，用空间获得的惨烈的胜利……
    public static class Solution{
        public int firstBadVersion(int n,long value) {
            long mid=n;
            for(long low=1,high=n;low<high;){
                mid=(low+high)/2;
                if(isBadVersion(mid,value))
                    high=mid;
                else
                    low=mid+1;
                if(low==high)
                    return (int)low;

            }
            return (int)mid;
        }
    }
}
