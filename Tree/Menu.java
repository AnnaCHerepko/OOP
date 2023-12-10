import java.util.ArrayList;
import java.util.List;

import AddHuman;
import Exit;
import FamilyPrint;
import HumanSearch;
import Load;
import Option;
import SaveFamily;
import SortAge;
import SortName;

public class Menu {
    private List<Option> commands;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new FamilyPrint(console));
        commands.add(new HumanSearch(console));
        commands.add(new SortName(console));
        commands.add(new SortAge(console));
        commands.add(new SaveFamily(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }

    void execute(int num) {
        Option option = commands.get(num - 1);
        option.execute();
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t- =  Меню  = -\n\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Console getConsole() {
        return console;
    }

}