// Write a program in Java to create a Player class.
// Inherit the classes Cricket _Player,
// Football _Player and Hockey_ Player
// from Player class.

class Player {
    String name;
    int age, matches, ranking;

    Player(String a, int b, int c, int d) {
        name = a;
        age = b;
        matches = c;
        ranking = d;
    }
}

class CricketPlayer extends Player {
    int highScore, bowlAverage, batAverage;

    CricketPlayer(String a, int b, int c, int d, int e, int f, int g) {
        super(a, b, c, d);
        highScore = e;
        bowlAverage = f;
        batAverage = g;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("No. of Matches: " + matches);
        System.out.println("Cricket Ranking: " + ranking);

        System.out.println("High Score: " + highScore);
        System.out.println("Bowling Average: " + bowlAverage);
        System.out.println("Batting Average: " + batAverage);
    }
}

class FootballPlayer extends Player {
    int goals, goalAverage, pass;

    FootballPlayer(String a, int b, int c, int d, int e, int f, int g) {
        super(a, b, c, d);
        goals = e;
        goalAverage = f;
        pass = g;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("No. of Matches: " + matches);
        System.out.println("Cricket Ranking: " + ranking);

        System.out.println("No. of Goals: " + goals);
        System.out.println("Average goals: " + goalAverage);
        System.out.println("Pass Efficiency: " + pass + "%");
    }
}

class HockeyPlayer extends Player {
    int goals, goalAverage, pass;

    HockeyPlayer(String a, int b, int c, int d, int e, int f, int g) {
        super(a, b, c, d);
        goals = e;
        goalAverage = f;
        pass = g;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("No. of Matches: " + matches);
        System.out.println("Cricket Ranking: " + ranking);

        System.out.println("No. of Goals: " + goals);
        System.out.println("Average goals: " + goalAverage);
        System.out.println("Pass Efficiency: " + pass + "%");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        CricketPlayer cp = new CricketPlayer("Kohli", 27, 187, 1, 185, 2, 57);
        FootballPlayer fp = new FootballPlayer("Ronaldo", 30, 345, 2, 300, 3, 60);
        HockeyPlayer hp = new HockeyPlayer("Pillai", 32, 245, 3, 100, 3, 54);

        cp.display();
        System.out.println();
        fp.display();
        System.out.println();
        hp.display();
    }
}
