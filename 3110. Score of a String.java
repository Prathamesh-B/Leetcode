class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sum += (s.charAt(i) - s.charAt(i + 1));
            }
            if (s.charAt(i + 1) > s.charAt(i)) {
                sum += (s.charAt(i + 1) - s.charAt(i));
            }
        }
        return sum;
    }
}