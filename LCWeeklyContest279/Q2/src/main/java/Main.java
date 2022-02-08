import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        long a=-0;
        Solution s=new Solution();
        System.out.println(s.smallestNumber(a));
    }
    static class Solution {
        Solution(){}
        public long smallestNumber(long num) {
            long ret=0;
            //符号
            boolean positive;
            if(num>0)   positive=true;
            else if(num<0)       positive=false;
            else return 0;

            //获取每一位数字
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            while(num!=0){
                numbers.add((int) (num%10));
                num/=10;
            }
            //数字按升序排列
            numbers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o1<=o2)
                        return -1;
                    else
                        return 1;
                }
            });

            //
            if(positive){
                //如果是正数，先找到第一个非0数
                int i;
                for (i= 0; i < numbers.size(); i++) {
                    if(numbers.get(i)!=0) {
                        ret=numbers.get(i);
                        numbers.remove(i);
                        break;
                    }
                }
                if(ret==0) return 0;
                //按序在ret后面添加数
                for (int j = 0; j < numbers.size(); j++) {
                    ret*=10;
                    ret+=numbers.get(j);
                }
                return ret;
            }
            else{
                //注意如果nums是负数，那么ArrayList numbers里的数都是负数，从0号索引可以直接拿到最小的数
                ret=numbers.get(0);
                numbers.remove(0);
                if(ret==0) return 0;
                for (int i = 0; i <numbers.size() ; i++) {
                    ret*=10;
                    ret+=numbers.get(i);
                }
                return ret;
            }
        }
    }
}
