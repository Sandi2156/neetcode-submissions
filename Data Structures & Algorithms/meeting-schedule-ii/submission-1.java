/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> startTime, endTime;
        startTime = new ArrayList<>();
        endTime = new ArrayList<>();

        for(Interval interval: intervals) {
            startTime.add(interval.start);
            endTime.add(interval.end);
        }

        Collections.sort(startTime);
        Collections.sort(endTime);

        int i = 0, j = 0, minRooms = 0, cur = 0;
        while(i < startTime.size() && j < endTime.size()) {
            if(startTime.get(i) < endTime.get(j)) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }
            minRooms = Math.max(minRooms, cur);
        }

        return minRooms;

        
    }
}
