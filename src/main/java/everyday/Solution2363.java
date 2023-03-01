package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int[] ints : items1) {
            hashMap.put(ints[0], hashMap.containsKey(ints[0])?hashMap.get(ints[0])+ints[1]:ints[1]);
        }
        for (int[] ints : items2) {
            hashMap.put(ints[0], hashMap.containsKey(ints[0])?hashMap.get(ints[0])+ints[1]:ints[1]);
        }
        int len = hashMap.size();
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            List<Integer> tem = new ArrayList<>();
            tem.add(entry.getKey());
            tem.add(entry.getValue());
            res.add(tem);
        }
        res.sort((a, b) -> a.get(0) - b.get(0));
        return res;

    }

    public static void main(String[] args) {
        Solution2363 solution2363 = new Solution2363();
        int[][] items1 = new int[][]{{1,1},{4,5},{3,8}};
        int[][] items2 = new int[][]{{3,1},{1,5}};
        List<List<Integer>> result = solution2363.mergeSimilarItems(items1, items2);
        System.out.println(result);
    }
}
