package leetcode.medium.array.sort;

import java.util.*;

/**
 * @ClassName KSmallestPairs
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class KSmallestPairs {
    /**
     * @description:暴力
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });
        //取最小值是为了防止两个数组一个比较少的时候【1】  【1,2,3】
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() < k) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    queue.add(pair);
                }else {
                    int top = queue.peek().get(0) + queue.peek().get(1);
                    //大于K就出队列
                    if(top > nums1[i]+nums2[j]){
                        List<Integer> pair = new ArrayList<>();
                        queue.poll();
                        pair.add(nums1[i]);
                        pair.add(nums2[j]);
                        queue.add(pair);
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            res.add(queue.poll());
        }
        return res;
    }

    /**
     * @description:改进，
     * 当(u,v)为第x小的数对时，第x+1小的数对可能是(u+1,v)和(u,v+1)
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public List<List<Integer>> kSmallestPairs01(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        HashSet<String> set = new HashSet<String>();
        pq.offer(new int[]{0,0});//角标
        List<List<Integer>> ans = new ArrayList<>();
        while(k-->0&&pq.size()>0)
        {
            int[] pair = pq.poll();
            ans.add(Arrays.asList(nums1[pair[0]],nums2[pair[1]]));
            if(pair[0]+1<nums1.length)
            {
                String key = String.valueOf(pair[0]+1)+"_"+String.valueOf(pair[1]);
                if(set.add(key)) // 去重
                {
                    pq.offer(new int[]{pair[0]+1,pair[1]});
                }
            }
            if(pair[1]+1<nums2.length)
            {
                String key = String.valueOf(pair[0])+"_"+String.valueOf(pair[1]+1);
                if(set.add(key))
                {
                    pq.offer(new int[]{pair[0],pair[1]+1});
                }
            }
        }
        return ans;
    }


}
