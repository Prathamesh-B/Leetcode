public class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // Edge cases for very small numbers
        if (num <= 10) return String.valueOf(num - 1);
        if (num == 11) return "9";
        
        // Generate the base (first half) and adjust for possible candidates
        long base = Long.parseLong(n.substring(0, (len + 1) / 2));
        boolean isOdd = len % 2 != 0;

        // Generate three possible candidates
        long candidate1 = createPalindrome(base - 1, isOdd); // base-1 mirrored
        long candidate2 = createPalindrome(base, isOdd);     // base mirrored
        long candidate3 = createPalindrome(base + 1, isOdd); // base+1 mirrored

        // Consider edge cases like "999", "1000"
        long candidate4 = (long) Math.pow(10, len - 1) - 1;   // All 9's case
        long candidate5 = (long) Math.pow(10, len) + 1;       // 100...001 case

        // Collect all candidates
        long[] candidates = new long[] {candidate1, candidate2, candidate3, candidate4, candidate5};

        // Initialize the closest palindrome search
        long closestPalindrome = -1;
        long minDifference = Long.MAX_VALUE;
        
        for (long candidate : candidates) {
            if (candidate == num) continue; // Skip the number itself
            
            long difference = Math.abs(candidate - num);
            
            if (difference < minDifference || (difference == minDifference && candidate < closestPalindrome)) {
                closestPalindrome = candidate;
                minDifference = difference;
            }
        }

        return String.valueOf(closestPalindrome);
    }

    // Helper function to create palindrome by mirroring the base
    private long createPalindrome(long base, boolean isOdd) {
        String baseStr = String.valueOf(base);
        String mirroredPart = new StringBuilder(baseStr).reverse().toString();
        return Long.parseLong(baseStr + mirroredPart.substring(isOdd ? 1 : 0));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nearestPalindromic("123")); // Example usage
    }
}