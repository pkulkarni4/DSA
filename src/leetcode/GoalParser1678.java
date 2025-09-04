package leetcode;

public class GoalParser1678 {
    public static void main(String[] args) {
        String[] str = {"G()()()()(al)",  "(al)G(al)()()G", "(al)G(al)()()G"};
        Solution1678 s = new Solution1678();
        for (String s2: str) {
            String ret = s.interpret(s2);
            System.out.println(ret);
        }
    }
}
class Solution1678 {
    public String interpret(String command) {
        if (command == null || command.trim().length() == 0) return command;
        //return getString(command);
return interpret_0ms(command, command.length());
        //return interpret(command, command.trim().length());
    }

    public String interpret_0ms(String command, int len) {
        StringBuilder S= new StringBuilder(len);
        for(int i=0; i<len; i++){
            if(command.charAt(i)== 'G'){ S.append('G');};
            if(command.charAt(i)== '(') {
                if(command.charAt(i+1)==')'){S.append('o'); i++; }
                else{ S.append("al"); i=i+3; }
            }
        }
        return S.toString();
    }

    private String getString(String command) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< command.length(); i++){
            if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                sb.append('o');
                i++;
            }else if(command.charAt(i)=='('&& command.charAt(i+1)=='a'){
                sb.append("al");
                i=i+3;
            }else {
                sb.append(command.charAt(i));

            }
        }
        String ret =  sb.toString();

        return ret;
    }

    private String interpret(String cmd1, int len) {
        String cmd=cmd1;
        int i=0;
        StringBuffer sb = new StringBuffer();
        while(cmd.length() != 0){
            if(cmd.charAt(i) == '(' && cmd.charAt(i+1) == ')'){
                sb.append("o");
                i=i+2;
            } else if(cmd.charAt(i) == '(' && cmd.charAt(i+1) == 'a'&& cmd.charAt(i+2) == 'l'&& cmd.charAt(i+3) == ')'){
                sb.append("al");
                i=i+4;
            } else if(cmd.charAt(i) == 'G') {
                sb.append("G");
                i=i+1;
            }
            cmd=cmd.substring(i,cmd.length());
            i=0;
        }
        return sb.toString();
    }
}
