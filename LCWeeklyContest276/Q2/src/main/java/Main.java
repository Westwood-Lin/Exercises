public class Main {
    public static void main(String[] args) {
        test();
    }



    public static void test(){
        Solution solution=new Solution();
        int target[]={5,19,10,1000};
        int maxDoubles[]={0,2,4,0};
        for (int i = 0; i < target.length; i++) {
            System.out.println(solution.minMoves(target[i],maxDoubles[i]));
        }
    }

    static class Solution {
        Solution(){}
        public int minMoves(int target, int maxDoubles) {
            //逆向思维轻松解决 将从1到target转化为从target凑到1即可
            //注意加一些优化和判断降低复杂度
            int min=0;
            int doubleTime=0;
            int value=target;

            //节省时间的特判
            if(maxDoubles==0){
                return target-1;
            }

            while (value!=1){
                if(value%2==0 && doubleTime<maxDoubles){//even & doubleTime<maxDoubles
                    //use half ( reverse double)
                    value/=2;
                    doubleTime++;
                    min++;
                    if(doubleTime==maxDoubles){
                        min+=value-1;
                        value=1;
                        break;
                    }

                }
                else{//odd
                    value--;
                    min++;
                }
            }

            return min;
        }
    }
}
