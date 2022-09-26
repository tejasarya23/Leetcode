class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int start[]= new int [intervals.length];
        int end[]=new int [intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        int rooms=0;
        int endptr=0;
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i=0;i<intervals.length;i++){
            if(start[i]<end[endptr]){
                rooms++;
            }else{
                endptr++;
            }
        }
        return rooms;
    }
}