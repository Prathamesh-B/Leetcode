class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0)
                nums[j++] = nums[i];
            if (j <= i)
                nums[i] = 0;
        }
        return nums;
    }
}