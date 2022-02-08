public class Main {
    public static void main(String[] args) {
        Bitset b=new Bitset(5);
        b.fix(3);//00010
        b.fix(1);//01010
        b.flip();//10101// 01010 flip=T
        System.out.println(b.all());
        b.unfix(0);//00101//  11010 flip=T
        b.flip();//11010 flip=F
        System.out.println(b.one());
        b.unfix(0);//01010
        System.out.println(b.count());//2
        System.out.println(b.toString());
    }

}
