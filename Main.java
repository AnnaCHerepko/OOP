import Units.*;
import Units.Bandit;
import Units.Crossbowman;
import Units.Farmer;
import Units.Human;
import Units.Mag;
import Units.Monk;
import Units.Names;
import Units.Sniper;
import Units.Spearman;
import Units.Vector2D;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int UNITS = 10;
    public static ArrayList<Human> allTeam = new ArrayList<>();
    public static ArrayList<Human> holyTeam = new ArrayList<>();
    public static ArrayList<Human> darkTeam = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner user_input = new Scanner(System.in)) {
            System.out.print("Press Enter to begin.");
            user_input.nextLine();
            createTeam(holyTeam, 0, 1);
            createTeam(darkTeam, 3, 10);
            allTeam.addAll(holyTeam);
            allTeam.addAll(darkTeam);
            sortTeam(allTeam);
            boolean a = true;
            int countBlue = 0;
            int countGreen = 0;
            while (a) {
                View.view();
                user_input.nextLine();
                countBlue = 0;
                countGreen = 0;
                for (Human human : allTeam) {
                    if (holyTeam.contains(human)) {
                        if (human.step(holyTeam, darkTeam))
                            countBlue++;
                    } else {
                        if ((human.step(darkTeam, holyTeam)))
                            countGreen++;
                    };
                }
                if (countBlue == UNITS || countGreen == UNITS)
                    a = false;
            }
            if (countBlue == UNITS)
                System.out.print("greenTeam wins");
            else {
                System.out.print("blueTeam wins");
            }
        }
    }

    static void createTeam(ArrayList team, int offset, int posY) {
        for (int i = 0; i < UNITS; i++) {
            int rnd = new Random().nextInt(4) + offset;
            switch (rnd) {
                case (0):
                    team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (1):
                    team.add(new Bandit(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (2):
                    // team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    team.add(new Mag(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (3):
                    team.add(new Farmer(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (4):
                    // team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    team.add(new Crossbowman(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (5):
                    // team.add(new Sniper(getName(), new Vector2D(i + 1, posY)));
                    team.add(new Monk(getName(), new Vector2D(i + 1, posY)));
                    break;
                case (6):
                    team.add(new Spearman(getName(), new Vector2D(i + 1, posY)));
                    break;
            }
        }
    }

    static void sortTeam(ArrayList<Human> team) {
        team.sort(new Comparator<Human>() {
            @Override
            public int compare(Human t0, Human t1) {
                if (t1.getSpeed() == t0.getSpeed())
                    return (int) (t1.getHp() - t0.getHp());
                else
                    return (int) (t1.getSpeed() - t0.getSpeed());
            }
        });
    }

    static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}
