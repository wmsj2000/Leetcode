import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution496{
    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] num1 = new int[]{4,1,2};
        int[] num2 = new int[]{1,3,4,2};
        int[] result = solution496.nextGreaterElement(num1,num2);
        System.out.println(Arrays.toString(result));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[len1];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        stack.push(0);
        for(int i=1;i<len2;i++){
            if(nums2[i] <= nums2[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.empty()&&nums2[i] > nums2[stack.peek()]){
                    map.put(nums2[stack.peek()], nums2[i]);
                    stack.pop();
                }
                stack.push(i);
            }
        }
        for(int i=0;i<len1;i++){
            if(map.containsKey(nums1[i])){
                result[i] = map.get(nums1[i]);
            }
        }
        return result;
    }
}