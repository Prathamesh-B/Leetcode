class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) {
                    cnt++;
                }
            }
            if (cnt == i) {
                return i;
            }
            cnt = 0;
        }
        return -1;
    }
}