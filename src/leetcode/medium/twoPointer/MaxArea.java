package leetcode.medium.twoPointer;

/**
 * @ClassName 盛最多水的容器,使用双指针
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.min(ans,area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
