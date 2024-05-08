public class ExitMenuAction implements MenuAction {


    @Override
    public String getName() {
        return "Закрити програму";
    }

    @Override
    public void execute() {
        System.out.println("Програму завершено. Приходьте ще!");
    }

    @Override
    public boolean closeAfter() {
        return true;
    }
}