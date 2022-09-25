class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // If there are no overlaps, add the interval to the list as is.
            if (interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // Is there a left interval we need to keep?
                if (interval[0] < toBeRemoved[0]) {
                    result.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                // Is there a right interval we need to keep?
                if (interval[1] > toBeRemoved[1]) {
                    result.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }
        return result;
    }
}