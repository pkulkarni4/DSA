import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        int sameUniformColor = getSameUniformColorOOP();
        System.out.println(sameUniformColor);

        sameUniformColor = getSameUniformColorArray();
        System.out.println(sameUniformColor);
    }

    private static int getSameUniformColorArray() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] home = new int[n];
        int[] guest = new int[n];
        int sameUniformColor = 0;

        for(int i=0;i<n;i++) {
            home[i] = sc.nextInt();
            guest[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(home[i] == guest[j]){
                    sameUniformColor++;
                }
            }
        }
        return sameUniformColor;
    }

    private static int getSameUniformColorOOP() {
        List<TeamUniform> teamUniformList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int home = sc.nextInt();
            int guest = sc.nextInt();
            TeamUniform team = new TeamUniform("t" + i, home, guest);
            teamUniformList.add(team);
        }

        // test code
        /*TeamUniform t1 = new TeamUniform("t1", 100, 42);
        TeamUniform t2 = new TeamUniform("t2", 42, 100);
        TeamUniform t3 = new TeamUniform("t3", 5, 42);
        TeamUniform t4 = new TeamUniform("t4", 100, 5);

        teamUniformList.add(t1);
        teamUniformList.add(t2);
        teamUniformList.add(t3);
        teamUniformList.add(t4);*/
        //
        int sameUniformColor = 0;
        for (int i = 0; i < n; i++) {
            TeamUniform homeTeam = teamUniformList.get(i);
            for (int j = 0; j < n; j++) {
                TeamUniform guestTeam = teamUniformList.get(j);
                if (!homeTeam.teamName.equals(guestTeam.teamName) && homeTeam.homeColor == guestTeam.guestColor) {
                   // System.out.println(homeTeam.teamName + " is playing home ground with " + guestTeam.teamName);
                    sameUniformColor++;
                }
            }
        }
        return sameUniformColor;
    }
}

class TeamUniform {
    String teamName;
    int homeColor;
    int guestColor;

    public TeamUniform(String teamName, int homeColor, int guestColor) {
        this.teamName = teamName;
        this.homeColor = homeColor;
        this.guestColor = guestColor;
    }
}