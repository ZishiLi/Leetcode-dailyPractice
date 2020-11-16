class Solution(object):
    def minStickers(self, stickers, target):
        """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """
        from collections import Counter
        n = len(target)
        ns = (1<<n)
        dp = [-1]*ns
        dp[0] = 0
        t_count = Counter(target)
        stickers = map(lambda x:Counter(x) & t_count, stickers)
        i = 0
        while i<len(stickers):
            if any(stickers[i]&stickers[j]==stickers[i] for j in xrange(len(stickers)) if i!=j):
                stickers.pop(i)
                i -= 1
            i += 1

        for state in xrange(ns):
            if dp[state]==-1:
                continue
            for sticker in stickers:
                now = state
                for letter in sticker.elements():
                    for i in xrange(n):
                        if now & (1<<i) == 0 and target[i]==letter:
                            now |= (1<<i)
                            break
                if dp[now]==-1 or dp[now]> dp[state]+1:
                    dp[now] = dp[state]+1

        return dp[ns-1]

