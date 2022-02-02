import java.util.LinkedList;
import java.util.Queue;

/*
啊啊啊啊！气死我了，没写出来，可恶啊
二分法+bfs……我就会写二分法
复制一份儿答案学习学习，可恶啊！

 作者：Hanxin_Hanxin
 链接：https://leetcode-cn.com/problems/last-day-where-you-can-still-cross/solution/cpython3java-1er-fen-duo-yuan-bfsran-se-1q53s/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Node
{
    int r;
    int c;

    Node(int r_, int c_)
    {
        r = r_;
        c = c_;
    }
}

class Solution
{
    public int latestDayToCross(int row, int col, int[][] cells)
    {
        int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int lo = Math.min(row, col) - 1;
        int hi = row * col;
        while (lo < hi)
        {
            int mid = lo + (hi - lo + 1) / 2;

            int [][] matrix = new int [row][col];
            for (int i = 0; i < mid; i ++)
            {
                int r = cells[i][0],  c = cells[i][1];
                r --;
                c --;
                matrix[r][c] = 1;
            }

            Queue<Node> q = new LinkedList<>();
            for (int sc = 0; sc < col; sc ++)
            {
                if (matrix[0][sc] == 0)
                {
                    q.offer(new Node(0, sc));
                    matrix[0][sc] = 1;
                }
            }

            boolean find = false;
            while (!q.isEmpty() && !find)
            {
                Node rc = q.poll();
                int r = rc.r,  c = rc.c;
                for (int di = 0; di < 4; di ++)
                {
                    int dr = dirs[di][0],  dc = dirs[di][1];
                    int nr = r + dr,  nc = c + dc;
                    if (0 <= nr && nr < row && 0 <= nc && nc < col && matrix[nr][nc] == 0)
                    {
                        if (nr == row - 1)
                        {
                            find = true;
                            break;
                        }
                        q.offer(new Node(nr, nc));
                        matrix[nr][nc] = 1;
                    }
                }
            }

            if (find == true)
                lo = mid;
            else
                hi = mid - 1;
        }

        return lo;
    }
}

