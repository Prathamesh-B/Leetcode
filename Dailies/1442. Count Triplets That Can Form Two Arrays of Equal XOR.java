class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            int a = 0;
            for (int j = i + 1; j < n; j++) {
                a ^= arr[j - 1];
                int b = 0;
                for (int k = j; k < n; k++) { // because j <= k
                    b ^= arr[k];
                    if (a == b) {
                        res += 1;
                    }
                }
            }
        }
        return res;
    }
}