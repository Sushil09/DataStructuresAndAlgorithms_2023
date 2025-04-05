class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();

        // Convert each time to minutes since midnight
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            minutesList.add(hours * 60 + minutes);
        }

        // Sort the list
        Collections.sort(minutesList);

        int minDiff = Integer.MAX_VALUE;

        // Compare adjacent times
        for (int i = 0; i < minutesList.size() - 1; i++) {
            int diff = minutesList.get(i + 1) - minutesList.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        // Edge case: difference between last and first across midnight
        int lastDiff = (1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1)) % 1440;
        minDiff = Math.min(minDiff, lastDiff);

        return minDiff;
    }
}
