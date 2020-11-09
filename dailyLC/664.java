class Solution {
public:
    int dp[100][100];
    int dfs(const string &s, int i,int j)
    {
        if(i>j)return 0;
        if(dp[i][j])return dp[i][j];
        dp[i][j]=dfs(s,i,j-1)+1;
        for(int k=i;k<j;++k)
        {
            if(s[k]==s[j])dp[i][j]=min(dp[i][j],dfs(s,i,k)+dfs(s,k+1,j-1));
        }
        return dp[i][j];
    }
    int strangePrinter(string s) {
        if(s.empty())return 0;
        return dfs(s,0,s.size()-1);
    }
};
