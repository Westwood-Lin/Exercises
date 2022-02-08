import java.util.ArrayList;

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
class Bitset {
    /*
    member: ArrayList
    思路：测试用例太恶心，懒标记降低复杂度，可以多用一些空间换取时间效率
     */
    private ArrayList<Integer> content=null;
    private int len=0;
    private int sum=0;
    private boolean toFilp=false;


    public Bitset(int size) {
        this.content=new ArrayList<Integer>();
        this.len=size;
        this.sum=0;

        for (int i = 0; i < size; i++)
            content.add(0);
    }

    public void fix(int idx) {
        if(!toFilp){
            sum+=1-content.get(idx);//sum=sum+1-content.get(idx)
            content.set(idx,1);
        }
        else{
            sum+= content.get(idx);
            content.set(idx,0);
        }
    }

    public void unfix(int idx) {
        if(!toFilp){
            sum-=content.get(idx);
            content.set(idx, 0);
        }
        else{
            sum-=1-content.get(idx);
            content.set(idx,1);
        }
    }

    public void flip() {
        toFilp=!toFilp;
        sum=len-sum;
    }

    public boolean all() {
        return count()==len;
    }

    public boolean one() {
        return count()>0;
    }

    public int count() {
//        效率太低
//        int sum=content.stream().reduce(Integer::sum).orElse(0);
//        return (!toFilp)?sum:len-sum;
        return sum;
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(toFilp)
            for (Integer integer:content) sb.append(1-integer);
        else
            for (Integer integer : content) sb.append(integer);

        return sb.toString();
    }
}
