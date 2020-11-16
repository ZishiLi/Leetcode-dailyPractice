class Solution {
public:    
    int maxStudents(vector<vector<char>>& seats) {
        const int M = seats.size(), N = M == 0 ? 0 : seats[0].size();
        // 检查每行哪个位置是『.』，用bitvec表示
        vector<int> valid(M);
        for (int i = 0; i < M; ++i) {
            int cur = 0;
            for (int j = 0; j < N; ++j) {
                cur = (cur << 1) + (seats[i][j] == '.');
            }
            valid[i] = cur;
        }
        vector<vector<int>> dp(M + 1, vector<int>(1 << N, -1));
        dp[0][0] = 0;
        for (int i = 1; i <= M; ++i) {
            const int v = valid[i - 1];
            // 遍历当前行可能的状态
            for (int j = 0; j < (1 << N); ++j) {
                // 当当前状态是v的子集且j下没有相邻的1
                if ((j & v) == j && !(j & (j >> 1))) {
                    // 遍历上一行所有可能的状态
                    for (int k = 0; k < (1 << N); ++k) {
                        // 当右上和左上都不相邻
                        if (!(j & (k >> 1)) && !((j >> 1) & k) && dp[i - 1][k] != -1) {
                            dp[i][j] = max(dp[i][j], dp[i - 1][k] + __builtin_popcount(j));
                        }
                    }
                }
            }
        }
        return *max_element(begin(dp[M]), end(dp[M]));
    }
};
