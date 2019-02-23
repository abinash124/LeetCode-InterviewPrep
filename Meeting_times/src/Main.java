import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public class Interval {
      int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e)
     { start = s; end = e; }
    }

    public static int minMeetingRooms(Interval[] intervals){
    if(intervals == null || intervals.length == 0)
        return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public
            int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public
            int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        //Start with putting first meeting into the room
        pq.offer(intervals[0]);

        for (int i =1; i< intervals.length; i++){
            //get meeting room that finished the first
            Interval interval = pq.poll();

            if(intervals[i].start >= interval.end){
                //if current meeting starts right after the prev
                //we don't need a new room
                //merge the interval
                interval.end = intervals[i].end;
            }
            else{
                //if the meeting has not ended this meeting needs a new room
                pq.offer(intervals[i]);
            }

            //put the meeting room back that was required
            pq.offer(interval);




        }
        return pq.size();

    }

    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
}
