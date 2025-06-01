class Solution {
    public void recur(String s, int start, int idx, String sub, HashSet<String> hash, List<String> res) {
        if (idx == s.length()) {
            if (start == s.length())
                res.add(sub);
            return;
        }

        if (hash.contains(s.substring(start, idx + 1))) {

            recur(s, idx + 1, idx + 1,
                    sub.isEmpty() ? s.substring(start, idx + 1) : sub + " " + s.substring(start, idx + 1), hash, res);
        }
        recur(s, start, idx + 1, sub, hash, res);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hash = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        recur(s, 0, 0, "", hash, res);
        return res;
    }
}