class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
    
    if (finalSum % 2 != 0) return result;

    long curr = 2;
    
    while (finalSum >= curr) {
        result.add(curr);
        finalSum -= curr;
        curr += 2;
    }

    // Add the remaining to the last element to adjust the total sum
    if (!result.isEmpty()) {
        long last = result.remove(result.size() - 1);
        result.add(last + finalSum);
    }

    return result;
    }
}


