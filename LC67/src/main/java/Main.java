import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    static class Solution {
        Solution() {
        }

        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i, j;
            int val, carry = 0;
            for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
                val = a.charAt(i) + b.charAt(j) - '0' - '0' + carry;
                if (val >= 2) {
                    val -= 2;
                    carry = 1;
                } else
                    carry = 0;
                sb.append(val);
            }
            for (; i >= 0; i--) {
                val = a.charAt(i) - '0' + carry;
                if (val >= 2) {
                    carry = 1;
                    val -= 2;
                } else {
                    carry = 0;
                }
                sb.append(val);
            }
            for (; j >= 0; j--) {
                val = b.charAt(j) - '0' + carry;
                if (val >= 2) {
                    carry = 1;
                    val -= 2;
                } else {
                    carry = 0;
                }
                sb.append(val);
            }
            if (carry == 1)
                sb.append(1);
            return sb.reverse().toString();
        }
    }
}

/*
最好的实现实现：
{
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
*/