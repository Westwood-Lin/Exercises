import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] arr={{0,2},{0,3},{1,2}};
        String string="aeed";
        System.out.println(Arrays.toString(s.countSubTrees(4, arr, string)));
    }

    static class node{
        private int pos=0;
        public ArrayList<Integer> children;
        public HashMap<Character,Integer> freq;
        node(){}
        public boolean hasNextChild(){
            return pos<children.size();
        }

        public Integer nextChild(){
            return children.get(pos++);
        }
        public void mergeMap(HashMap<Character,Integer> map){
            for (Character c: map.keySet()) {
                if(freq.containsKey(c))
                    freq.put(c,freq.get(c)+map.get(c));
                else
                    freq.put(c,map.get(c));
            }
        }
        public void addChild(Integer i){
            if(children==null)
                children=new ArrayList<Integer>();
            children.add(i);
        }
    }
    static class Solution {

        Solution(){}
        public int[] countSubTrees(int n, int[][] edges, String labels) {
            int[] ret=new int[n];
            boolean[] edge_used=new boolean[n];
            int key,value;
            node[] nodes=new node[n];
            for (int i = 0; i <n ; i++) {
                nodes[i]= new node();
                nodes[i].children=new ArrayList<Integer>();
                nodes[i].freq=new HashMap<Character,Integer>();
            }

            for(int used_count=0,root=0;used_count<n;){
                for (int i = 0; i < edges.length && !edge_used[i] ; i++) {
                    if(root==edges[i][0]){
                        key=edges[i][0];
                        value=edges[i][1];
                        nodes[key].addChild(value);
                        edge_used[i]=true;
                        used_count++;
                    }
                    else if(root==edges[i][1]){
                        value=edges[i][0];
                        key=edges[i][1];
                        nodes[key].addChild(value);
                        edge_used[i]=true;
                        used_count++;
                    }
                }
                if(nodes[root].hasNextChild())
                    root=nodes[root].nextChild();
            }


            for (int i = n-1; i >= 0 ; i--) {
                nodes[i].freq.put(labels.charAt(i),1);

                if(nodes[i].children.size()!=0){//有子结点
                    for (int j = 0; j < nodes[i].children.size(); j++) {
                        HashMap<Character,Integer> childrenFreq= nodes[nodes[i].children.get(j)].freq;
                        for (Character c:childrenFreq.keySet()) {
                            if(nodes[i].freq.get(c)==null)
                                nodes[i].freq.put(c,childrenFreq.get(c));
                            else
                                nodes[i].freq.put(c,nodes[i].freq.get(c)+childrenFreq.get(c));
                        }
                        ret[i]=nodes[i].freq.get(labels.charAt(i));
                    }
                }
                else
                    ret[i]=1;
            }

            return ret;
        }
    }
}
