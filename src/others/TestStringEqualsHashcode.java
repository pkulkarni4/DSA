package others;

import jdk.jshell.spi.ExecutionControl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestStringEqualsHashcode {
    public static void main(String[] args) {
        String s1 = "FB";

        String s2 = "Ea";

        System.out.println(s1.equals(s2));

        System.out.println("FB  "+s1.hashCode());

        System.out.println("Ea  "+s2.hashCode());

        ///
        StringBuffer sb1 = new StringBuffer("JBS");
        StringBuffer sb2 = new StringBuffer("JBS");

        System.out.println(sb1.equals(sb2));
        System.out.println(sb1.toString().equals(sb2.toString()));

        HashMap<StringBuffer, String> map = new HashMap<>();
        map.put(sb1, "Spring");
        map.put(sb2, "Hibernate");

        System.out.println(map);

        ///
        StringBuilder sb11 = new StringBuilder("JBS");
        StringBuilder sb22 = new StringBuilder("JBS");

        System.out.println(sb11.equals(sb22));
        System.out.println(sb11.toString().equals(sb22.toString()));

        HashMap<StringBuilder, String> map1 = new HashMap<>();
        map1.put(sb11, "Spring");
        map1.put(sb22, "Hibernate");

        System.out.println(map1);

        ///
        final char x = 99;

        byte b = 127;

       double i = true ? Integer.valueOf(3) : Double.valueOf(3.1);

       short s = 10;

        int i1 = s + b;

        short ss = true ? b : s;

       String str = "hello";
       StringBuilder sbr;

        Float infinity = Float.parseFloat("NaN");
        System.out.println(infinity);

        var xv =1 ;
        var yv =1;
        xv = 99;

        Map<String, String> m =  Map.of("Fred", "Jones", "SS", "smith");
        int in = 0;
        for(String sm: m.keySet()) {
            System.out.println(sm);
        }
    }

    public static <T extends Object & Comparable<? super T> & Serializable> T max(){
        String str = new String("hello");
        StringBuilder sbr = new StringBuilder("hello");

        return(T) (1==1 ? str : sbr);
    }

    void testException()  {
        try{
               // if(Math.random() > 0.5) throw new FileNotFoundException();
                if(Math.random() < 0.5) throw new SQLException();
        } catch( SQLException e){
           //throw new  Exception();
        }
    }

}
