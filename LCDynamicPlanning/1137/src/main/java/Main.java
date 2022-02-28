public class Main {
    public static void main(String[] args) {

    }
    class Solution {
        public int tribonacci(int n) {
            //T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
            if(n<3)
                return n<2?n:1;
            else{
                int a,b,c,d;
                a=0;
                b=1;
                c=1;
                d=2;
                for (int i = 3; i < n; i++) {
                    a=b;
                    b=c;
                    c=d;
                    d=a+b+c;
                }
                return d;
            }
        }
    }
}
