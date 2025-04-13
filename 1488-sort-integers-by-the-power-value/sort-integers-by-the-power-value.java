class Solution {
    int[] dp = new int[1001];

    public int getKth(int lo, int hi, int k) {
        populateDp();
        List<Pair> list = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            list.add(new Pair(i, dp[i]));
        }

        Collections.sort(list, (p1, p2) -> 
            p1.val != p2.val ? p1.val - p2.val : p1.num - p2.num
        );

        return list.get(k - 1).num;
    }

    private void populateDp() {
        dp[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            dp[i] = findSteps(i);
        }
    }

    private int findSteps(int i) {
        if (i <= 1000 && dp[i] != 0) return dp[i];

        int next = (i % 2 == 0) ? i / 2 : i * 3 + 1;
        int steps = 1 + findSteps(next);

        if (i <= 1000) dp[i] = steps;
        return steps;
    }

    static class Pair {
        int num, val;
        Pair(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }
}
