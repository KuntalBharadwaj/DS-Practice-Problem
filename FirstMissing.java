class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (
                    nums[i] > 0 && nums[i] <= n &&
                            nums[nums[i] - 1] != nums[i]
            ) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    // public int firstMissingPositive(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();

    //     for(int i=0;i<nums.length;i++) {
    //         set.add(nums[i]);
    //     }

    //     int i = 1;
    //     for(;i<nums.length+1;i++) {
    //         if(!set.contains(i)) return i;
    //     }
    //     return i;
    // }
}