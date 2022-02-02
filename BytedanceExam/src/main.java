import java.util.ArrayList;
import java.util.Arrays;

public class main {
    static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(){}
        TreeNode(int v){
            this.val=v;
        }
        public static TreeNode mkTreeNode(int[] s){
            TreeNode[] list=new TreeNode[s.length];
            TreeNode n,l,r;
            for(int i=0;i<s.length;i++) {
                if (s[i] != -999){
                    n= new TreeNode(s[i]);
                    list[i]=n;
                }
                else{
                    list[i]=null;
                }
            }
            for (int i = 0; i <s.length ; i++) {
                l=null;
                r=null;
                n=list[i];
                if(i*2+1<s.length) l=list[2*i+1];
                if(i*2+2<s.length) r=list[2*i+2];
                if(l!=null) n.left=l;
                if(r!=null) n.right=r;
            }
            return list[0];
        }
    }

    public static int[][] calculatePaths(TreeNode n,int m){
        ArrayList<int[]> paths=new ArrayList<int[]>();

        findAllPaths(n,m,paths);
        //
        return paths.toArray(new int[0][0]);
    }

    public static void findAllPaths(TreeNode n,int m,ArrayList<int[]> paths){
        if(n.left!=null)
            findAllPaths(n.left,m,paths);
        if(n.right!=null)
            findAllPaths(n.right,m,paths);
        calculateOnePath(n,m,new ArrayList<>(),paths);
    }

    public static void calculateOnePath(TreeNode n,int m,ArrayList<Integer> p,ArrayList<int[]> paths){
        m-=n.val;
        p.add(n.val);

        if(n.left!=null){
            ArrayList<Integer> lp= (ArrayList<Integer>) p.clone();
            calculateOnePath(n.left,m,lp,paths);
        }
        if(n.right!=null){
            ArrayList<Integer> rp= (ArrayList<Integer>) p.clone();
            calculateOnePath(n.right,m,rp,paths);
        }
        if(m==0){
            if(paths!=null){
                paths.add(p.stream().mapToInt(Integer::valueOf).toArray());
            }
            else{
                paths=new ArrayList<int[]>();
                paths.add(p.stream().mapToInt(Integer::valueOf).toArray());
            }
        }
    }

    public static void main(String[] args) {
        int[] s = {3, 6, -1, 1, 4, -3, 4, -999, -999, -999, -999, 11};
        int m = 10;
        TreeNode n= TreeNode.mkTreeNode(s);
        int[][] ans=calculatePaths(n,m);
        System.out.println(Arrays.deepToString(ans));
    }

}
