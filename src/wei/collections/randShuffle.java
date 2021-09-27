package wei.collections;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;


/**
 * @ClassName randShuffle
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class randShuffle {
    public static int[] randShuffle(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        for (int i = n -1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i));
        }
      
        return nums;
    }
    public static void swap(int[] nums, int i, int j) {
        int o = nums[i];
        nums[i] = nums[j];
        nums[j] = o;
    }

}
