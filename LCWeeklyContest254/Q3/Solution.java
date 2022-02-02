/**
 * Leetcode Question 1969.
 *
 * 本题几乎不考编程技巧，只考数学理解和数学思考'
 * 求解结果很简单，想几个例子就清楚了
 * 对数列1 2 3 到 2^(p)-1
 * 只需要不停把数交换，使其两极化， 1*(2^p-1)*(2^p-2)*……，把2和2^p-3交换一下交换成1和2^p-2,3和2^p-4交换成1和2^p-2如此如此
 * 最后写出算式即可
 *
 * 返回结果：(2 ** p - 1) * pow(2 ** p - 2, 2 ** (p - 1) - 1, 10 ** 9 + 7) % (10 ** 9 + 7)
 *
 * 本题 实际 上的难点是，计算过程中如何避免溢出
 *
 * python非常简单，直接搞就行了，毕竟动态语言；
 * class Solution:
 *     def minNonZeroProduct(self, p: int) -> int:
 *         mod=10**9+7
 *         return ( (2**p-1) %mod ) * pow(2**p-2,2**(p-1)-1,mod ) %mod
 * 但java/C++就需要用到快速幂算法,并且及时地取余，避免溢出
 * 要用到数论中的欧拉公式 （a·b)%p=((a%p)·(b%p))%p
 *
 * 快速幂链接：
 * https://zhuanlan.zhihu.com/p/95902286
 * https://www.cnblogs.com/CXCXCXC/p/4641812.html
 *
 * 快速幂取余：
 * https://www.jianshu.com/p/403105106802
 */

class Solution {
    public int minNonZeroProduct(int p) {
        long MOD= (long) (1e9+7);

        long a=(1L<<p)-1;
        long b=a-1L;
        long c=b/2L;
        long ans=((a%MOD) * (pow(b%MOD,c,MOD)) )% MOD;
        return (int)ans;
    }

    //快速幂
    public long pow(long x,long y,long MOD){
        long ans=1;
        while(y!=0L) {
            if((y&1)!=0){
                ans*=x;
                x*=x;
                //取余非常关键
                ans%=MOD;
                x%=MOD;
            }
            y>>=1;
        }
        return ans%MOD;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int c=6;
        System.out.println(c+" result:"+s.minNonZeroProduct(c));
    }
}