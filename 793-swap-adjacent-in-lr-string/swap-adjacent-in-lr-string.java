class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int i = 0, j = 0, n = start.length();

        while (i < n && j < n) {
            // Skip Xs in both strings
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            // Both reached the end
            if (i == n && j == n) return true;
            // Only one reached the end
            if (i == n || j == n) return false;

            if (start.charAt(i) != end.charAt(j)) return false;

            // Check movement rules
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}
