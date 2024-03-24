class Solution {
    public int findDuplicate(int[] nums) {

        // start hopping from node 0
        int slow = 0, fast = 0;

        int check = 0;

        // Step 1
        // Cycle detection
        // Implement Tortoise and Hare algorithm
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // Step 2
        // Locate the start node of cycle (i.e., the duplicate number)
        while (true) {
            slow = nums[slow];
            check = nums[check];

            if (slow == check) {
                break;
            }
        }

        return check;

    }
}