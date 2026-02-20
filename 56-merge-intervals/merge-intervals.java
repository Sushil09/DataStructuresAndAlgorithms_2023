class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals,(i,j)->i[0]-j[0]);
        
        int first = intervals[0][0];
        int second = intervals[0][1];    
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]<=second) {
                second = Math.max(intervals[i][1],second);
                continue;
            }
            intervalList.add(new int[]{first,second});
            first = intervals[i][0];
            second = intervals[i][1];
        }

           intervalList.add(new int[]{first,second});

        return intervalList.toArray(new int[intervalList.size()][]);   

    }
}