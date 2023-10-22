import java.time.LocalDate;
import java.util.FamilyTree;
import java.util.Human;
import java.util.Gender;


public class Main {
    public static void main(String[] args)  {
        FamilyTree tree = testTree();
        System.out.print(tree);
    }

    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Human Ivan = new Human('Иван', Gender.Male, LocalDate.of(1972, 11, 04));
        Human Mari = new Human('Мария', Gender.Female, LocalDate.of(1974, 07, 03));
        tree.add(Ivan);
        tree.add(Mari);
        
        Human Alex = new Human('Алексей', Gender.Male, LocalDate.of(2003, 06, 13), Ivan, Mari);
        Human  Olga = new Human('Ольга', Gender.Female, LocalDate.of(1997, 11, 13), Ivan, Mari);
        tree.add(Alex);
        tree.add(Olga);
        return tree;
    }
}