// Разбойник
package Units;

import java.util.ArrayList;

public class Bandit extends Warrior {
    public Bandit(String name, Vector2D coords) {
        super(name, 80.f, 80, 11, 3, 5, 11,
                7, coords.posX, coords.posY);
    }

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Разбойник:\t").append(Bandit.super.name)
                .append("\t| ATK:\t").append(Bandit.super.attack)
                .append("\t| HP:\t").append(Bandit.super.hp)
                .append(" \t|\t\t\t|").append("\t| (X.Y) : ").append(Bandit.super.coords.posX).append(".").append(Bandit.super.coords.posY);
    }
}