class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0||intervals.length==1)return intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        // System.out.print(Arrays.deepToString(intervals));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=pq.peek()){
                pq.poll();
            }
                pq.offer(intervals[i][1]);
            
        }
        
        
        return pq.size();
    }
}