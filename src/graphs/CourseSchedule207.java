package graphs;

import java.util.*;

/*
LC 207 - course schedule. Find if all courses can be completed for a given course and its prerequisites
Detect if there is a cycle, return false if there is one and true otherwise.
Example:
n=5, prereq=[ [0,1],[0,2],[2,3],[2,4],[3,4] ]
output: true
n=2, prereq=[ [1, 0], [0, 1] ]
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        int n = 5;
        int[][] prereqs = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4},
                {3, 4}
        };
        Solution207 s = new Solution207();
        boolean canFinish = s.canFinish(n, prereqs);
        System.out.println("can complete all courses? " + canFinish);

        int[][] prereqs1 = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4},
                {3, 0}
        };
        canFinish = s.canFinish(n, prereqs1);
        System.out.println("can complete all courses? " +canFinish);
    }
}

class Solution207 {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    /*
   create a map like an adjacency map for graph
   do a dfs from 0.. numCourses, find cycle
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] hasCycle = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int crs = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            List<Integer> prereqList = graph.getOrDefault(crs, new ArrayList<>());
            prereqList.add(prereq);
            graph.put(crs, prereqList);
        }

        //printGraph1();

        // do a dfs
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, hasCycle)) {
                return false;
            }
        }
        return true;
    }

    private void printGraph1() {
        Set<Integer> keys = graph.keySet();
        for (int key : keys) {
            System.out.println("course:" + key);
            List<Integer> prereqs = graph.get(key);
            for (int prereq : prereqs) {
                System.out.print("\t prereqs: " + prereq);
            }
            System.out.println();
        }
    }

    private boolean dfs(int crs, boolean[] hasCycle) {
        if (hasCycle[crs]) return false;
        if (graph.get(crs) == null || graph.get(crs).isEmpty()) {
            return true;
        }
        // set cycle to true until procedure is complete
        hasCycle[crs] = true;
        List<Integer> prereqs = graph.get(crs);
        for (Integer prereq : prereqs) {
            if (!dfs(prereq, hasCycle)) {
                return false;
            }
        }
        // update to no cycle
        hasCycle[crs] = false;
        // update to no prereq for the course
        graph.put(crs, new ArrayList<>());
        // return course can be completed
        return true;
    }
}