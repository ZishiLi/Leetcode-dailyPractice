class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int n = A.length;
        int sum = 0;
        for(int x :A) sum += x;
        boolean[][] dp = new boolean[sum+1][n/2+1];
        dp[0][0] = true;
        for(int num : A){
            for(int i = sum; i>=num;i--){
                for(int j = n/2;j>=1;j--){
                    dp[i][j] = dp[i][j] || dp[i - num][j -1];
                }
            }
          
        }
        for(int i = 1;i<=n/2;i++){
            if(sum * i%n == 0 && dp[sum*i/n][i]) return true;
        }
        return false;
    }
}
