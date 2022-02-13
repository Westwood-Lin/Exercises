import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
    static void test1(){
        ListNode head=new ListNode(3);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(-4);
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        Solution s=new Solution();
        System.out.print(s.detectCycle(head).val);
    }
    static void test2(){
        ListNode head=new ListNode(1);
        ListNode n2=new ListNode(2);
        head.next=n2;
        n2.next=head;
        Solution s=new Solution();
        System.out.print(s.detectCycle(head).val);
    }
    static void test3(){
        ListNode head=new ListNode(1);
        Solution s=new Solution();
        System.out.print(s.detectCycle(head).val);
    }
    /**
     * Definition for singly-linked list.
     */
    static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }

    }
    static class Solution {

        Solution(){}
        public void addFreq(HashMap<Integer,Integer> map,int key){
            if(map.containsKey(key))
                map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        //双指针法，给予两个指针前进的速度差，如果两个指针相遇，则有环。
        public ListNode detectCycle(ListNode head) {

            if(head==null || head.next==null){
                System.out.println("no cycle");
                return null;
            }
            else if(head.next.val==head.val){
                System.out.println("tail connects to node index 0");
                return head;
            }

            ListNode p1,p2;
            boolean circle=false;
            ArrayList<Integer> nodes;
            HashMap<Integer,Integer> p2Road;//key:listnode int value ; value: frequency;

            p1=p2=head;
            nodes=new ArrayList<Integer>();
            p2Road=new HashMap<Integer,Integer>();

            nodes.add(p1.val);
            p2Road.put(head.val, 1);
            while(true){
                if(p2.next==null || p2.next.next==null){
                    System.out.println("no cycle");
                    return null;
                }
                p1=p1.next;
                nodes.add(p1.val);
                p2=p2.next;
                addFreq(p2Road,p2.val);
                p2=p2.next;
                addFreq(p2Road,p2.val);

                if(p1.val==p2.val){
                    circle=true;
                    break;
                }
            }

            if(circle){
                int minIndex=9999;
                for (int i = 0; i < nodes.size(); i++) {
                    if(p2Road.get(nodes.get(i))>=2){
                        minIndex= Math.min(minIndex, i);
                        break;
                    }
                }
                System.out.println("tail connects to node index "+minIndex);
                ListNode ret=head;
                for (int i=0;i<minIndex;i++){
                    ret=ret.next;
                }
                return ret;
            }
            System.out.println("no cycle");
            return null;
        }
    }

}
