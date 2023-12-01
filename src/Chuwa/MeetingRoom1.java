package Chuwa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MeetingRoom1 {

    public boolean canAttendMeetings(List<List<Integer>> intervals) {
        if (intervals == null || intervals.isEmpty()) return true;

        intervals.sort((arr1, arr2) -> {
            if (!Objects.equals(arr1.get(0), arr2.get(0))) {
                return arr1.get(0) - arr2.get(0);
            } else {
                return arr2.get(1) - arr1.get(1);
            }
        });
        // System.out.println(intervals);
        int endTime = intervals.get(0).get(1);

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> interval = intervals.get(i);

            if (interval.get(0) < endTime) return false;

            endTime = interval.get(1);
        }

        return true;
    }

    public static void main(String[] args) {
        MeetingRoom1 meetingRoom1 = new MeetingRoom1();
        List<List<Integer>> testCase1 = new ArrayList<>();

        testCase1.add(new ArrayList<>(List.of(0, 30)));
        testCase1.add(new ArrayList<>(List.of(5, 10)));
        testCase1.add(new ArrayList<>(List.of(15, 20)));

        System.out.println(meetingRoom1.canAttendMeetings(testCase1));

        List<List<Integer>> testCase2 = new ArrayList<>();

        testCase2.add(new ArrayList<>(List.of(7, 10)));
        testCase2.add(new ArrayList<>(List.of(2, 4)));

        System.out.println(meetingRoom1.canAttendMeetings(testCase2));

        System.out.println(meetingRoom1.canAttendMeetings(null));
    }
}
