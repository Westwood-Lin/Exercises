一道很￥%……%&*的题，只用快慢指针还不行。啊啊啊，气死我了！

https://leetcode-cn.com/problems/linked-list-cycle-lcci/comments/

力扣面试02.08题



### 解法：快慢指针法理论证明

假设一个只有一个环路的单链表总节点数为n，我们可以假设

该链表环路分为两部分：

·Head——**无环路部分A**——·环路起始结点——**有环路部分B**——·环路结束结点

我们用2个指针fast和slow来检验有无环路：其中fast每次走2步，slow走1步。

假如无环路部分长度为a，有环路部分长度为b。

fast走的长度为F，slow走的长度为S。

显然有：
$$
\begin{align}
&
fast速度是slow的两倍:
\\
& \qquad
F=2S \qquad ①
\\
&
假如有环路，快慢指针第一次相遇时fast一定比slow多走一圈环路：
\\
& \qquad
F=a+b+s0 \qquad ②
\\
& \qquad
S=a+s0 \qquad \quad ③ 
\\
&
(s0代表slow在环路中走的路程)
\\
&
将②③代入①:
\\
& \qquad
2a+2s0=a+b+s0 \ => \ a+s0=b \ => a=b-s0 \ ④
\\
\\
&
这个等式④有什么意义呢？
&
显然左边容易理解，a代表无环路部分的长度，
\\
&
b-s0代表slow完成剩下的环路的长度；
\\
&
假如在二者相遇时，将fast丢回head，让他重新一步一步走，等他走了 距离a 时，fast相当于走到环路开始处。
\\
&
而slow同时一步一步走，因为 a=b-s0，
\\
& \qquad \qquad
S'= \ S+b-s0= \ =a+s0+b-s0\ =a+b \ 相当于走了一圈环路，也回到环路开始处。
\\
&
此时二者将再次相遇，且相遇点是环路开始处。
\end{align}
$$
