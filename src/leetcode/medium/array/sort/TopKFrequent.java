package leetcode.medium.array.sort;

import java.util.*;

/**
 * @ClassName TopKFrequent
 * @Description 出现频率最高的 k 个数字
 * @Author wyl
 * @Data
 */
public class TopKFrequent {

    /**
     * @description:堆，建立一个小顶堆，然后遍历「出现次数数组]
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {  //存入map
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

      /**
       * @description:快排
       * @author: 卫依伦
       * @date: 2021/12/10
       */
      public int[] topKFrequent01(int[] nums, int k) {
          Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
          for (int num : nums) {
              occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
          }

          List<int[]> values = new ArrayList<int[]>();
          for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
              int num = entry.getKey(), count = entry.getValue();
              values.add(new int[]{num, count});
          }
          int[] ret = new int[k];
          qsort(values, 0, values.size() - 1, ret, 0, k);
          return ret;
      }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }


}
