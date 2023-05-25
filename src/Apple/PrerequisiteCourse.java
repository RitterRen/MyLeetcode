package Apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PrerequisiteCourse {

    public List<Integer> getCourseOrder(HashMap<Integer, List<Integer>> courseMap,
                                        int targetCourse) { // {course, prerequisite course
        List<Integer> courseOrder = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(targetCourse);

        this.bfs(queue, courseOrder, courseMap);
        this.reverseOrder(courseOrder);

        return courseOrder;
    }

    private void bfs(LinkedList<Integer> queue, List<Integer> courseOrder,
                     HashMap<Integer, List<Integer>> courseMap) {
        while (!queue.isEmpty()) {
            int course = queue.pollFirst();
            courseOrder.add(course);

            if (courseMap.containsKey(course)) { // if it still has prerequisite course
                queue.addAll(courseMap.get(course));
            }
        }
    }

    private void reverseOrder(List<Integer> courseOrder) {
        int left = 0;
        int right = courseOrder.size() - 1;

        while (left < right) {
            this.swap(courseOrder, left, right);
            left++;
            right--;
        }
    }

    private void swap(List<Integer> courseOrder, int left, int right) {
        int temp = courseOrder.get(left);
        courseOrder.set(left, courseOrder.get(right));
        courseOrder.set(right, temp);
    }

    public static void main(String[] args) {

    }
}
