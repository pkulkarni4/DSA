package others;

public class TestExceptions {

    public static void main(String[] args) {
        try {
            extracted();
        } catch (Exception e) {
            if(e.getClass().equals(RuntimeException.class)) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void extracted() throws RuntimeException {
        try {
            Exception ex1 = new RuntimeException("unknown host");
            throw new RuntimeException("I/O Error", ex1);
        }catch (RuntimeException re) {
            throw new RuntimeException("Error requesting token", re);
        }
    }
}
