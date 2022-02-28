public class Main {
    public static void main(String[] args) {

    }

    /**
     *  方法一：递归  太low了
     *  方法二：数学方法；求出斐波那契数列的通项公式； 过程：特征方程+f(0)=0+f(1)=1这三个条件就ok了
     *  方法三：矩阵等比：
     *  方法四
      */

    class Solution {
        public int fib(int n) {
            if(n<2)
                return n;
            else{
                int a=0;
                int b=1;
                int c=1;
                for (int i=2;i<n;i++){
                    a=b;
                    b=c;
                    c=a+b;
                }
                return c;
            }
        }
    }
//    class Solution {
//        public int fib(int n) {
//            if(n==0)
//                return 0;
//            else if(n==1)
//                return  1;
//            else
//                return fib(n-1)+fib(n-2);
//        }
//    }
}
