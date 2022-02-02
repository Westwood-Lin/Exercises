import java.util.Arrays;

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (int i=0;i<patterns.length;++i){
            if(isSub(patterns[i],word))
                count++;
        }
        return count;
    }

    boolean isSub(String a,String b){
//     1: return b.contains(a);
//        2:
        if(a.length()>b.length())
            return false;
        for (int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] p={"abc","ab","a","abcd"};
        String w="abc";
        Solution s=new Solution();
        System.out.println(s.numOfStrings(p,w));
    }
}

/*提交版本：
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (int i=0;i<patterns.length;++i){
            if(word.contains(patterns[i]))
                count++;
        }
        return count;
    }
}
 */