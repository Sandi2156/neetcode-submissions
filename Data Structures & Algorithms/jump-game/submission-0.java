class Solution {
    public boolean canJump(int[] nums) {
        int maxiReachable = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxiReachable) return false;

            maxiReachable = Math.max(maxiReachable, i + nums[i]);
        }

        return maxiReachable >= nums.length - 1;
    }
}
