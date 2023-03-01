import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i=1;i<len+len-1;i++){
            if(nums[i%len]<=nums[stack.peek()]){
                stack.push(i%len);
            }

            else {
                while (!stack.empty()&&nums[i%len]>nums[stack.peek()]){
                    result[stack.peek()] = nums[i%len];
                    stack.pop();
                }
                stack.push(i%len);
            }
        }
        
        
        return result;
        
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] num = new int[]{1,2,3,4,2,1};
        int[] result = solution503.nextGreaterElements(num);
        System.out.println(Arrays.toString(result));
    }
    
}
