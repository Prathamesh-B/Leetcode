class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        Set<int[]> set = new TreeSet<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; ++i)
            set.add(new int[] { nums[i], i });
        for (int[] s : set) {
            if (nums[s[1]] == 0)
                continue;
            score += (long) s[0];
            nums[s[1]] = 0;
            if (s[1] > 0)
                nums[s[1] - 1] = 0;
            if (s[1] + 1 < nums.length)
                nums[s[1] + 1] = 0;
        }
        return score;
    }
}