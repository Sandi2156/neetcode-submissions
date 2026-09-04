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
        int n = intervals.size();

        int[] startList = new int[n], endList = new int[n];
        for(int i = 0; i < n; i++) {
            startList[i] = intervals.get(i).start;
            endList[i] = intervals.get(i).end;
        }

        Arrays.sort(startList);
        Arrays.sort(endList);

        int rooms = 0, cnt = 0;
        int i = 0, j = 0;
        
        while(i < n && j < n) {
            if(startList[i] < endList[j]) {
                cnt++;
                i++;

                rooms = Math.max(rooms, cnt);
            } else {
                cnt--;
                j++;
            }
        }

        return rooms;
    }
}
