

import java.io.IOException;

import FamilyTree;
import Human;
import HumanComporatorByAge;
import Presenter;
import Console;
import View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        familyTree.addFamilyTree(new Human("Алексей", "муж", 27));
        familyTree.addFamilyTree(new Human("Иван Иванович Иванов", "муж", 70));
        familyTree.getByName("алекс");
        View view = new Console();
        HumanComporatorByAge sortAge =  new HumanComporatorByAge();
        new Presenter(view, familyTree, sortAge);
        view.start();

    }
}