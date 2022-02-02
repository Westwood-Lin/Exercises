import java.util.ArrayList;
import java.util.Arrays;

/**
 * 总结与反省
 * author：fyl
 * 独立解题：yes
 * 用时：3hour，先后尝试了4个方法，大部分时间是在想方法，力扣上这道题有超级恶心的测试用例，
 * nmd 一个数组几十万个数，我的前几个方法复杂度太高，一直过不了
 * 后来几次优化终于搞定，不禁感叹算法的重要性！
 *
 * 解题过程：
 * 首先想到把这个int数组当做一个数列，用数学关系和分而治之的思想解题
 * 第一次尝试时，想三个数一组、三个数一组的来确保每一位数满足条件，具体不说了，很蠢、不行
 *
 * 第二次对第一次思路进行优化，继续运用“分而治之”，成功解题但算法的时空复杂度都很高
 *   1.定义成功数列：满足每一位数不等于前项和后项平均值的数列，目标是让整个数列成为成功数列
 *   2.将数列排序，非常重要，可以假设排序后是升序，即A1<A2<A3<……<An
 *   3.遍历排序后的数列，将该数列A1 A2 A3 …… An 分为若干个小的成功数列，因为只有1个或2个数的数列必然是成功数列，所以这样的划分必然可行
 *      小数列1：A(1) A(2) …… A(α)
 *      小数列2：A(α+1) A(α+2) …… A(β)
 *      ……
 *      最后一个小数列：A(γ) A(γ+1） …… A(n)
 *   4.把小数列1接到小数列2的后边，形成新的数列，
 *    小数列1:A(1) A(2) …… A(α）
 *    小数列2：A(α+1) A(α+2) ……A(β-1） A(β)
 *    如果把A(1)接在A(β)后面,A(β)>A(β-1)且A(β)>A(1),A（1）<A(2)且A(1)<A（β)，内部又都是成功数列，合成以后肯定还是成功数列。
 *   5.再用新的数列接到后一个数列尾巴上，如此重复即可。
 *
 *   示例：1234579（排序后）
 *   小数列1:12
 *   小数列2:34
 *   小数列3:57
 *   小数列4:9
 *
 *   第一次：3 4 1 2
 *   第二次：573412
 *   第三次：9573412/逆序也一样 2 1 4 3 7 5 9
 *
 *   算法思想是正确的，但略显粗糙，有很大优化空间，所以第一次实现和第二次实现的时空复杂度极高
 *
 *   后来我想到了，一个数列如果只有1或2个数，那他一定是成功数列，既然如此，为何不2个2个数的划分组呢？
 *   比如 12 34 57 9
 *   然后只需颠倒每组组内顺序即可
 *   21 43 75 9 这样其实跟我的算法本质一样，但操作起来简单一万倍，这就是实现三
 */

/**
 * 方法一：
 * 复杂度极高
 *  class Solution {
 *     public int[] rearrangeArray(int[] nums) {
 *         int[] ret=new int[nums.length];
 *         //先排序数组（升序）
 *         Arrays.sort(nums);
 *
 *         //分割数组
 *         ArrayList<int[]> splitNums = new ArrayList<int[]>();
 *         for (int i = 1; i<nums.length-1;){
 *             if (nums[i]*2==nums[i-1]+nums[i+1]){
 *                 splitNums.add(Arrays.copyOfRange(nums,0,i+1));
 *                 nums=Arrays.copyOfRange(nums,i+1,nums.length);
 *                 i=1;
 *             }
 *             else
 *                 i++;
 *         }
 *         splitNums.add(Arrays.copyOfRange(nums,0,nums.length));
 *
 *         //连接几个数组
 *         int offset=0;
 *         for (int i = splitNums.size()-1; i >=0 ; i--) {
 *             int[] toCopy=splitNums.get(i);
 *             System.arraycopy(toCopy,0,ret,offset,toCopy.length);
 *             offset+=toCopy.length;
 *         }
 *         return ret;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] nums1={1,2,3,4,5};
 *         test(nums1);
 *     }
 *
 *     public static void test(int[] nums){
 *         Solution s=new Solution();
 *         nums=s.rearrangeArray(nums);
 *         for (int a: nums) {
 *             System.out.print(a+" ");
 *         }
 *         System.out.println();
 *     }
 * }
 */

/**
 * 方法二
 * 时间复杂度仍然极高，空间复杂度相对方法一降低了
 class Solution {
 public int[] rearrangeArray(int[] nums) {
 int[] ret=new int[nums.length];
 //先排序（升序）
 Arrays.sort(nums);

 //遍历一遍数列，确定不满足条件的数的下标
 ArrayList<Integer> unfit=new ArrayList<Integer>();

 unfit.add(0);
 for (int i=1,length=1;i<nums.length-1;i++,length++){
 if(nums[i]*2==nums[i+1]+nums[i-1]&&length>=2){
 unfit.add(i);
 length=0;
 }
 }
 unfit.add(nums.length);

 //没有不满足的数——for循环里没有向unfit添加数，unfit大小为2——直接返回
 if(unfit.size()==2) return nums;

 //开始构造
 int index=0;
 for(int i=1;i<unfit.size();i++){
 for (int j=unfit.get(i)-1;j>=unfit.get(i-1);j--)
 ret[index++]=nums[j];
 }

 return ret;
 }

 public static void main(String[] args) {
 int[] nums2 = {1,2,3,4,5,6,7,8};
 test(nums2);
 int[] nums1 = {4,6,7,8,10,12,20};
 test(nums1);
 }

 public static void test(int[] nums){
 Solution s=new Solution();
 nums=s.rearrangeArray(nums);
 for (int a: nums) {
 System.out.print(a+" ");
 }
 System.out.println();
 }
 }
 */

/**
 * 方法三 :实现简单易行，非常取巧，实际就4个动作：排序、遍历、交换、返回，但算法想出来却不容易
 */
class Solution {
    public int[] rearrangeArray(int[] nums) {
        //先排序（升序）
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i+=2){
            nums[i]^=nums[i-1];
            nums[i-1]^=nums[i];
            nums[i]^=nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums2 = {1,2,3,4,5,6,7,8};
        test(nums2);
        int[] nums1 = {4,6,7,8,10,12,20};
        test(nums1);
    }

    public static void test(int[] nums){
        Solution s=new Solution();
        nums=s.rearrangeArray(nums);
        for (int a: nums) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}