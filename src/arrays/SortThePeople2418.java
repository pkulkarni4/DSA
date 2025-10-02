package arrays;

import java.util.ArrayList;
import java.util.List;

public class SortThePeople2418 {
    public static void main(String[] args) {
        String[][] names = {
                {"Mary", "John", "Emma"},
                {"Alice", "Bob", "Bob"}
        };
        int[][] heights = {
                {180, 165, 170},
                {155, 185, 150}
        };
        SortThePeople2418Solution s = new SortThePeople2418Solution();
        String[] res1 = s.sortPeople(names[0], heights[0]);
        for (String s1 : res1) {
            System.out.print(s1 + " ");
        }
        System.out.println();
        String[] res2 = s.sortPeople(names[1], heights[1]);
        for (String s2 : res2) {
            System.out.print(s2 + " ");
        }
    }
}

class SortThePeople2418Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> p = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            p.add(new Person(names[i], heights[i]));
        }
        p.sort((a, b) -> {
            return b.height - a.height;
        });
        String[] res = new String[names.length];
        int i = 0;
        for (Person person : p) {
            res[i++] = person.name;
        }
        return res;
    }
}

class Person {
    String name;
    int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}