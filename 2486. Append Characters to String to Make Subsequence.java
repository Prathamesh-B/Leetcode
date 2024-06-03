class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0, cnt = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j))
                i++;
            else {
                i++;
                j++;
                cnt += 1;
            }
        }
        return t.length() - cnt;
    }
}