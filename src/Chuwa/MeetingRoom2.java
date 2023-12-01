package Chuwa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public int solution(List<List<Integer>> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        Comparator<List<Integer>> comparator = (arr1, arr2) -> {
            if (arr1.get(0) != arr2.get(0)) {
                return arr1.get(0) - arr2.get(0);
            } else {
                return arr2.get(1) - arr1.get(1);
            }
        };

        intervals.sort(comparator);

        PriorityQueue<List<Integer>> maxHeap =
                new PriorityQueue<>(Comparator.comparingInt(arr -> arr.get(1)));

        maxHeap.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> interval = intervals.get(i);

            if (interval.get(0) >= maxHeap.peek().get(1)) {
                List<Integer> temp = maxHeap.poll();
                interval.set(0, Math.min(interval.get(0), temp.get(0)));
                interval.set(1, Math.max(interval.get(1), temp.get(1)));
            }

            maxHeap.add(interval);
        }

        return maxHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoom2 meetingRoom2= new MeetingRoom2();
        List<List<Integer>> testCase1 = new ArrayList<>();

        testCase1.add(new ArrayList<>(List.of(0, 30)));
        testCase1.add(new ArrayList<>(List.of(5, 10)));
        testCase1.add(new ArrayList<>(List.of(18, 20)));

        System.out.println(meetingRoom2.solution(testCase1));

        List<List<Integer>> testCase2 = new ArrayList<>();
        testCase2.add(new ArrayList<>(List.of(6, 10)));
        testCase2.add(new ArrayList<>(List.of(1, 5)));

        System.out.println(meetingRoom2.solution(testCase2));
    }
}
