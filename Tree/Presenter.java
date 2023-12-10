import FamilyTree;
import Human;
import HumanComporatorByAge;
import View;

public class Presenter {
    private View view;

    private FamilyTree<Human> familyConnect;
    private HumanComporatorByAge sortAge;

    public Presenter(View view, FamilyTree<Human> familyConnect, HumanComporatorByAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age) {
        familyConnect.addFamilyTree(new Human(name, sex, age));

        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Такого человека нет в семье !");

        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }


    public void loadFamily() {
        serialize.load("TreeFamily.data");

    }

    public void sortFamilyName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка завершена !");
    }

    public void sortFamilyAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка завершена !");
    }
}