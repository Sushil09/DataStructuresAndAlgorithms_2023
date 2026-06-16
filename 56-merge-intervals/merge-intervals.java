class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(int[]a,int[]b)->a[0]-b[0]);
        List<int[]> overlapps = new ArrayList<>();
        int st = intervals[0][0], end = intervals[0][1];
            
        for(int i=1;i<intervals.length;i++) {
            if(end>=intervals[i][0]){
                st = Math.min(st,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
                continue;
            }
            overlapps.add(new int[]{st,end});
            st = intervals[i][0];
            end = intervals[i][1];
        }
        
        overlapps.add(new int[]{st,end});
        int[][]ans = new int[overlapps.size()][2];
        for(int i=0;i<overlapps.size();i++) {
            ans[i]=overlapps.get(i);
        }
        return ans;
    }
}