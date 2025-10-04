package others;

/*
LC # 1344: Angles between the clock hands
 */
public class ClockAngle1344 {
    public static void main(String[] args) {
        ClockAngle1344Solution sol = new ClockAngle1344Solution();
        int[] hours = {12, 3, 3, 10, 9, 4};
        int[] min = {30, 30, 15, 10, 40, 40};
        for (int i = 0; i < hours.length; i++) {
            double angle = sol.angleClock(hours[i], min[i]);
            System.out.println("Smaller angle between: hour: " + hours[i] + "  min : " + min[i] + " is ==> " + angle + " degrees ");
        }
    }
}

class ClockAngle1344Solution {
    public double angleClock(int hour, int minutes) {
        // hour hand: hour * 30 + min * .5
        // minute hand: min * 6
        // abs(hour hand - min hand) > 180, then return 360 - abs(hour hand - min hand)
        // 12, 30 = 12*30 + 30*.5 = 375
        // 30 * 6= 180
        // abs(375-180)= 195> 180, return 360 - 195 = 165
        double hourHandDegree = hour * 30 + minutes * 0.5;
        double minuteHandDegree = minutes * 6;
        double deg = Math.abs(hourHandDegree - minuteHandDegree);
        if (deg >= 180) {
            return 360 - deg;
        }
        return deg;
    }
}