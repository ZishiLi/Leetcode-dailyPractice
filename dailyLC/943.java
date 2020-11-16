class Solution {
public:
    string shortestSuperstring(vector<string>& A) {
        int size = A.size();
        int overlaps[size][size]; //表示A[i]在前、A[j]在后，重叠的字母个数
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size;  j++) {
                int k;
                for (k = A[j].size(); k > 0; k --) {
                    int num = A[i].find(A[j].substr(0,k), A[i].size()-k);
                    //cout << A[i] << " " << A[j].substr(0,k) << " " << num << endl;
                    if (num >= 0) {
                        overlaps[i][j] = k;
                        break;
                    }
                }
                if (k == 0) overlaps[i][j] = 0;
            }
        }
        //状态方程，(1<<size)可以表示出所有集合
        string dp[(1<<size)][size] = {""};
        
        for(int i = 1; i < (1<<size); i ++) {
            for (int j = 0; j < size; j ++) {
                if (i & (1<<j)) {
                    if (i == (1<<j)) dp[i][j] = A[j];
                    else {
                        for (int k = 0; k < size; k ++) {
                            if (j == k) continue;
                            if (i & (1<<k)) {
                            	//表示在集合中去掉第j个字符串
                            	//即找出倒数第二个字符串
                                string s = dp[i-(1<<j)][k];
                                s += A[j].substr(overlaps[k][j],A[j].size()-overlaps[k][j]);
                                //状态转移
                                if (dp[i][j] == "" || s.size() < dp[i][j].size()) dp[i][j] = s;
                            }
                        }
                    }
                }
            }
        }
        
        int min = dp[(1<<size)-1][0].size();
        int index = 0;
        
        for (int i = 1; i < size; i ++) {
            if (dp[(1<<size)-1][i].size() < min) {
                min = dp[(1<<size)-1][i].size();
                index = i;
            }
        }

        return dp[(1<<size)-1][index];
    }
};

