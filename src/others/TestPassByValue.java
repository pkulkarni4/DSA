package others;

public class TestPassByValue {
    public static void main(String[] args) {
        int[] a = {2,1};
        square(a, 2);
        System.out.println(System.identityHashCode(a));
        System.out.println(a[0] + ", " + a[1]);

        Integer in = Integer.valueOf(2);
        System.out.println(System.identityHashCode(in));
        modify(in);

        person p = new person();
        p.setFname("P");
        p.setLname("K");
        p.setMname("A");

        System.out.println(p);

        updateName(p);

        System.out.println(p);
    }

    static void updateName(person p) {
        p.setFname("T");
        p.setMname("P");
        p.setLname("k");
    }

    private static void modify(Integer in) {
        System.out.println(System.identityHashCode(in));
    }

    static void square(int[] a, int n) {
        System.out.println(System.identityHashCode(a));
        for(int i=0;i<n;i++){
            a[i] = a[i] * a[i];
        }
    }
}

class person {
    private String fname;
    private String lname;
    private String mname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String toString() {
        return this.fname +" " + this.mname + " " + this.lname;
    }

    public static void test(){
        System.out.println("test from person");
    }
}

class Employee extends person{
    public static void test(){
        System.out.println("test from employee");
    }
}