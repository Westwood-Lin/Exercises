class Solution {
    Solution(){};
    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null) return -1;
        if(needle.equals("")) return 0;

        if(!haystack.contains(needle))
            return -1;
        else{
            String[] res=haystack.split(needle,2);
            return res[0].length();
        }
    }

}
//    public int strStr(String haystack, String needle) {
//        if(haystack==null||needle==null) return -1;
//        if(haystack.equals(needle)) return 0;
//        if(needle.equals("")) return 0;
//        if(haystack.length()<needle.length()) return -1;
//        if(haystack.equals("")) return -1;
//
//        int begin=0;
//        boolean find=false;
//
//        for (int i = 0 ; i < haystack.length(); i++) {
//
//            if(haystack.charAt(i)==needle.charAt(0)){//check
//                begin=i;
//                for (int j = 0; j < needle.length() ; j++) {
//                    if( i + j >= haystack.length() ||  haystack.charAt(i+j) != needle.charAt(j)) {
//                        find=false;
//                        break;
//                    }
//                    else
//                        find=true;
//                }
//                if(find) return begin;
//            }
//            begin=0;
//            find=false;
//        }
//        return -1;
//    }

