class Solution {
    public int minimumTime(String s) {
        if(s==null||s.length()<=0||!s.contains("1"))
            return 0;

        int leftPos,rightPos,Times=0;
        for (leftPos=0 ;
             leftPos < s.length() && s.charAt(leftPos)!='0' ;
             leftPos++,Times++);
        for (rightPos = s.length()-1;
             rightPos >=0 && rightPos > leftPos && s.charAt(rightPos) != '0' ;
             rightPos--,Times++);

        if(leftPos<rightPos)
            Times+=calMin(s.substring(leftPos,rightPos+1));

        return Math.min(Times, s.length());
    }
    public int calMin(String s){
        if(!s.contains("1")) return 0;
        int ret=0;

        double ratio,maxRatioLeft,maxRatioRight;
        int idxMaxRatioLeft,idxMaxRatioRight;
        ratio=maxRatioLeft=maxRatioRight=idxMaxRatioLeft=idxMaxRatioRight=0;

        for (int i = 0, cnt = 0 ; i < s.length() ; i++) {
            if(s.charAt(i)=='1'){
                cnt++;
                ratio=1.0*cnt/(i+1);
                if(ratio>maxRatioLeft){
                    maxRatioLeft=ratio;
                    idxMaxRatioLeft=i;
                }
            }
        }
        for (int i = 0, cnt = 0 ; i < s.length() ; i++) {
            if(s.charAt(s.length()-1-i)=='1'){
                cnt++;
                ratio=1.0*cnt/(i+1);
                if(ratio>maxRatioRight){
                    maxRatioRight=ratio;
                    idxMaxRatioRight=s.length()-1-i;
                }
            }
        }
        String remain;

        //走性价比最高的一路
        if(maxRatioLeft>=maxRatioRight){
            //走左路，然后交给下一轮递归
            if(maxRatioLeft>=0.5){
                ret+=(1+idxMaxRatioLeft);
                remain=s.substring(idxMaxRatioLeft+1,s.length());
            }
            else
                return ret+2*(s.length()-s.replaceAll("1","").length());
        }
        else{
            //走右路，然后交给下一轮递归
            if(maxRatioRight>=0.5){
                ret+=s.length()-idxMaxRatioRight;
                remain=s.substring(0,idxMaxRatioRight);
            }
            else
                return ret+2*(s.length()-s.replaceAll("1","").length());
        }

        //这里需要递归求出最佳路线
        return ret+=calMin(remain);
    }
}