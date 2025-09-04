package chapter08;

public class TowerOfHanoi {
    public static void main(String[] args) {
        moveDisks(3, 'A', 'C', 'B');
    }

    static void moveDisks(int n, char origin, char target, char intermediate) {
        if (n <= 0) return;
        if (n == 1) {
            System.out.println("move disk 1 from rod " + origin + " to rod " + target);
            return;
        }
        moveDisks(n - 1, origin, intermediate, target);
        System.out.println("move disk " + n + " from rod "+ origin + " to rod "+ target);
        moveDisks(n - 1,  intermediate, target, origin);
    }
}
