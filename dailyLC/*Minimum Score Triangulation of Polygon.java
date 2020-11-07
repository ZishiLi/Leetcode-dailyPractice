class Solution {
    public int minScoreTriangulation(int[] arr) {
        int len = arr.length;
        int[][] lookup = new int[len][len];
        return minScoreFromTo(arr, 0, len - 1, lookup);
    }

    private int minScoreFromTo(int[] arr, int from, int to, int[][] lookup) {
        if (from >= to || from + 1 == to) {
            return 0;
        }
        if (lookup[from][to] > 0) {
            return lookup[from][to];
        }
        lookup[from][to] = Integer.MAX_VALUE;
        for (int mid = from + 1; mid < to; mid++) {
            lookup[from][to] = Math.min(lookup[from][to], arr[mid] * arr[from] * arr[to] + minScoreFromTo(arr, from, mid, lookup)
                    + minScoreFromTo(arr, mid, to, lookup));
        }
        return lookup[from][to];
    }
}
