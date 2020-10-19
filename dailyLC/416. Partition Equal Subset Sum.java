class Solution {
    public boolean canPartition(int[] nums) {
        //取和除以二，这题等同于求能否取数字，得到半值
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;
        int tar = sum/2;
       
        boolean[] f = new boolean[tar + 1];
        int n = nums.length;
        f[0] = true;
        
        //但这个题和取硬币的题不同之处在于，不能从小到大更新，因为硬币题的硬币是无限的，
        //但是这题中每个数字是有限的。
        //所以需要逆序更新。
        for(int num : nums){
            for(int i = tar; i >=num; i--){
                f[i] = f[i] || f[i - num];
            }
        }
        return f[tar];
    }
}