class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int tar = sum/2;
        boolean[] f = new boolean[sum/2 + 1];
        f[0] = true;
        for(int stone : stones){
            for(int i = tar;i>= stone;i--){
                f[i] = f[i] || f[i-stone];
            }
        }
        for(int i = tar;i>=0;i--){
            if(f[i] == true) return (sum-i) - i;
        }
        return -1;
    }
}
