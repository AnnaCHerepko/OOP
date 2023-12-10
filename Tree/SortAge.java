import Console;

public class SortAge extends Command {
    public SortAge(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировка семьи по возрасту. ";
    }

    @Override
    public void execute() {
        getConsole().sortFamilyAge();

    }
}