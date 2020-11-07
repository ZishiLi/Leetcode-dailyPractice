class Solution {
public:
   
int dp[105][105];
int getLen(int i, int j, vector<int>& cuts, int n)
{
	int left = i == 0 ? 0 : cuts[i-1];
	int right = j == cuts.size() - 1 ? n : cuts[j+1];
	return right - left;
}

int minCost(int n, vector<int>& cuts) {

    sort(cuts.begin(),cuts.end());
	memset(dp, 0, sizeof(dp));
	for (int l = 0; l < cuts.size(); l++)
	{
		for (int i = 0; i + l< cuts.size(); i++)
		{
			int j = i + l;
			if (i == j)
			{
				dp[i][i] = getLen(i,j, cuts, n);
			}
			else
			{
				dp[i][j] = INT32_MAX;
				for (int k = i; k <= j; k++)
				{
					dp[i][j] = min(dp[i][j], (k==0?0:dp[i][k - 1]) + getLen(i, j, cuts, n) +  dp[k + 1][j]);
				}
			}	
		}
	}

	return dp[0][cuts.size() - 1];
}
};
