import java.util.Scanner;

public class PoliceRecruits {
    public static void main(String[] args) {
        int unAttendedCrime = 0, runningRecruitCount = 0;

        ///  test data
        // int[] events = {-1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1};
        ///
        // int n = events.length;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] events = new int[n];
        for (int i = 0; i < n; i++) {
            events[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (events[i] >= 1) {
                runningRecruitCount += events[i];
            } else if (events[i] < 0 && runningRecruitCount > 0) {
                runningRecruitCount -= 1;
            } else if (events[i] < 0 && runningRecruitCount < 1) {
                unAttendedCrime++;
            }
        }
        System.out.println(unAttendedCrime);
    }
}
