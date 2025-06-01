class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int res = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int val = (s.charAt(i) - '0') + carry;
            carry = val >= 1 ? 1 : 0;
            res += val == 1 ? 1 : 0;
            res++;
        }
        return res + carry;
    }
}