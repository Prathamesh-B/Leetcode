class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int k = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1 && k < ans.length; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                ans[k] = nums[i];
                k++;
                i = i - 1;
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            ans[1] = nums[nums.length - 1];
        }
        return ans;
    }
}