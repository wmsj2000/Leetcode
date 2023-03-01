import java.util.Stack;

public class Solution42 {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0;i<height.length;i++){
            if(height[i]<height[stack.peek()]){
                stack.push(i);
                res -= height[i];
            }
            else {
                while (!stack.empty()&&height[i]>=height[stack.peek()]){
                    lastPop = stack.peek();
                    lastHeight = height[stack.peek()];
                    res -= height[stack.peek()];
                    stack.pop();
                }
                stack.push(i);
                res += height[lastPop]*(i-lastPop);
            }

        }


        return  res;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(heights));
    }

}
