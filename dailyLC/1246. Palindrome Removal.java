class Solution {
    public int minimumMoves(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int k=0;k<n;k++){
            for(int i=0;i+k<n;i++){
                int j=i+k;
                dp[i][j]=1+(i+1>j?0:dp[i+1][j]);//第一个字母不合并其他
                for(int p=i+1;p<=j;p++){
                    if(arr[i]==arr[p]){//第一个字母和其他最后合并
                        int v=0;
                        v+=Math.max(dp[i+1][p-1],1);
                        if(p+1<=j)v+=dp[p+1][j];
                        dp[i][j]=Math.min(v,dp[i][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}

