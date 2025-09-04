package arrays;

import java.util.Arrays;

/*
 Give array of meeting time intervals consisting of start and end times, determine if a person could attend all meetings.
input = [[1,2], [3, 4], [4,5], [6,7]]
return true, there is no overlap

input = [[0,5], [5, 30], [10, 15], [20, 25]]
return false,
 */
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] input = {{1,2}, {3, 4}, {4,5}, {6,7}};
        MeetingRoomsSolution s = new MeetingRoomsSolution();
        boolean b = s.canAttendAllMeetings(input);
        System.out.println(b);
        int[][] input1 = {
                {0,5}, {5, 30}, {10, 15}, {20, 25}};
        b = s.canAttendAllMeetings(input1);
        System.out.println(b);

        MeetingRoomsIISolution ss = new MeetingRoomsIISolution();
        int rooms = ss.roomsToAccommodateAllMeetings(input);
        System.out.println(rooms);

        int rooms2 = ss.roomsToAccommodateAllMeetings(input1);
        System.out.println(rooms2);
    }
}

class MeetingRoomsSolution {
    public boolean canAttendAllMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}

/*
same input as above, determine minimum number of meeting rooms required to accommodate all meetings
input = [[1,2], [3, 4], [4,5], [6,7]]
return 1, one room can accommodate all meetings

input = [[0,5], [5, 30], [10, 15], [20, 25]]
return 2, two rooms can accommodate all meetings
 */
class MeetingRoomsIISolution {
    public int roomsToAccommodateAllMeetings(int[][] intervals) {

        int length = intervals.length;
        int[] start = new int[length];
        int[] end = new int[length];

        for(int i = 0; i< length; i++){
            start[i] = intervals[i][0];
        }

        for(int i = 0; i< length; i++){
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int usedRooms = 0, maxRooms = 0, startPointer=0, endPointer=0;
        while(startPointer < length) {
            if(start[startPointer] < end[endPointer]) {
                usedRooms++;
                startPointer++;
            } else {
                usedRooms--;
                endPointer++;
            }
            maxRooms = Math.max(maxRooms, usedRooms);
        }
        return maxRooms;
    }
}
