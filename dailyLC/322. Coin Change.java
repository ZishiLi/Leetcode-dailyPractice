class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount  == 0) return 0;
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 0; 
        
        for(int i = 1; i < f.length; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                if(i >= coins[j] && f[i-coins[j]] != Integer.MAX_VALUE){
                f[i] = Math.min(f[i],f[i - coins[j]]+1);
                }
            }
        }
        
        if(f[amount] == Integer.MAX_VALUE) return -1;
        return f[amount];
    }
}       