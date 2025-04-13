class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // Descending attack
            return a[1] - b[1]; // Ascending defense
        });

        int maxDefense = 0;
        int count = 0;

        for (int[] p : properties) {
            if (p[1] < maxDefense) {
                count++;
            } else {
                maxDefense = p[1];
            }
        }

        return count;
    }
}
