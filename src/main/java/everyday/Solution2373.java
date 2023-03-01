package everyday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2373 {
    //这个方法wrong了，只通过部分用例
    public int[][] largestLocal(int[][] grid) {
        int[][] slide1 = new int[grid.length][grid[0].length-2];
        int[][] slide2 = new int[grid.length-2][grid[0].length-2];
        for (int i = 0; i < grid.length; i++) {
            //使用Deque实现单调队列，可以类比单调栈，事实上单调栈也可以用Deque实现。
            //队列中维护单调递减队列，可以类比单调栈，保证队首是最大值，且往队尾单调递减
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < grid[0].length; j++) {
                while (!deque.isEmpty()&&grid[i][j]>grid[i][deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(j);

                //判断队首在不在窗口，不在就pollFirst,这里while可以换if
                while (deque.peekFirst()<j-2){
                    deque.pollFirst();
                }
                //取队首值为窗口最大值
                if(j>=2){
                    slide1[i][j-2] = grid[i][deque.peekFirst()];
                }
            }
        }
        for (int i = 0; i < slide1[0].length; i++) {
            //使用Deque实现单调队列，可以类比单调栈，事实上单调栈也可以用Deque实现。
            //队列中维护单调递减队列，可以类比单调栈，保证队首是最大值，且往队尾单调递减
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < slide1.length; j++) {
                while (!deque.isEmpty() && slide1[j][i] > grid[deque.peekLast()][i]) {
                    deque.pollLast();
                }
                deque.offerLast(j);

                //判断队首在不在窗口，不在就pollFirst,这里while可以换if
                while (deque.peekFirst() < j - 2) {
                    deque.pollFirst();
                }
                //取队首值为窗口最大值
                if (j >= 2) {
                    slide2[j - 2][i] = slide1[deque.peekFirst()][i];
                }
            }
        }

        return  slide2;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}} ;
        Solution2373 solution2373 = new Solution2373();
        int[][] res = solution2373.largestLocal(grid);
        for(int[] r:res){
            System.out.printf(Arrays.toString(r));

        }
    }
}

