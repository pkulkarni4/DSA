package others;

public class EnumTests {
}


enum Constants {
    PI(3.14), E(2.72), AVO(6.02);
    private double value;
    Constants(double d){
        value = d;
    }
    public String toString() {
        return "";
    }
}