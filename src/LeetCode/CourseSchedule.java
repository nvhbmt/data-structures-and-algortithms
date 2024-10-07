package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int courseRequire = prerequisite[1];
            list.get(courseRequire).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0; // counting course is learned
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            count++;
            for (int nextCourse : list.get(currentCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) { // all require course to learn currentCourse is Done
                    queue.add(nextCourse);
                }
            }
        }

        return count == numCourses;
    }
}
