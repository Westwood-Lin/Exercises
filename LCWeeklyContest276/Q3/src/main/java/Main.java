public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        int[][] questions={{3,2},{4,3},{4,4},{2,5}};
        Solution solution=new Solution();
        System.out.println(solution.mostPoints(questions));
    }

    static class Solution {
        Solution(){}
        //直接做复杂度太高，n^2；逆向思考，消除后作用，降低复杂度。
        public long mostPoints(int[][] questions) {
            long[] points=new long[questions.length];
            for (int i = questions.length-1; i >=0 ; i--) {
                if(i== questions.length-1){
                    points[i]=questions[i][0];
                }
                else if(i+1+questions[i][1]>=questions.length){
                    points[i]=Math.max(points[i+1],questions[i][0]);
                }
                else {
                    points[i]=Math.max(points[i+1],questions[i][0]+points[i+1+questions[i][1]]);
                }
            }
            return points[0];
        }

    }
}
