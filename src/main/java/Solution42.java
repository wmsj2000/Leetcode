import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        return  res;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(heights));
    }

}
