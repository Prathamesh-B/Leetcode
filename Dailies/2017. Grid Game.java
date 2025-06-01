class Solution {
    public long gridGame(int[][] g) {
        long top = Arrays.stream(g[0]).asLongStream().sum(), bottom = 0, res = Long.MAX_VALUE;
        for (int i = 0; i < g[0].length; ++i) {
            top -= g[0][i];
            res = Math.min(res, Math.max(top, bottom));
            bottom += g[1][i];
        }
        return res;
    }
}