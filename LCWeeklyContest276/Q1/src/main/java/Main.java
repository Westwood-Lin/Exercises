import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(Arrays.toString(solution.divideString("abcdefgh", 3, 'x')));
    }
    static class Solution {
        Solution(){}
        public String[] divideString(String s, int k, char fill) {
            int len;

            if(s.length()%k==0){//s=k * len
                len=s.length()/k;
            }
            else{//s=k*(len-1)+ remain (1<=remain<k)
                len=s.length()/k+1;
            }

            String[] ret=new String[len];
            //s.len=11 k=3 len=4;
            //[0 3) [3 6) 6 9) [9 12)
            String tmp="";
            for (int i = 0; i < len; i++) {
                if(i*k+k<s.length())
                    tmp=s.substring(i*k,i*k+k);
                else{
                    for (int j = i*k; j < i*k+k; j++) {
                        if(j<s.length())
                            tmp+=s.charAt(j);
                        else
                            tmp+=fill;
                    }
                }
                ret[i]=tmp;
                tmp="";
            }
            return ret;
        }
    }
}

