package everyday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        deque.offerLast(0);
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]){
                    deque.pollLast();
                }
            deque.offerLast(i);

            while (deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            if(i+1>=k)  res[i-k+1] = nums[deque.peekFirst()];
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k =3;
        Solution239 solution239 = new Solution239();
        int[] ans  = new int[nums.length];
        ans = solution239.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));
    }
}
