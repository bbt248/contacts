import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private MenuAction[] actions;
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.actions = new MenuAction[0];
        this.scanner = scanner;
    }

    public void addAction(MenuAction action){
        actions = Arrays.copyOf(actions,actions.length + 1);
        actions[actions.length - 1] = action;
    }

    public void run(){
        while (true) {
            showMenu();
            int choice = getMenuIndexFromUser(scanner);
            if (!(validateUserInput(choice))) {
                System.out.println("Ви обрали невірний пункт меню");
                continue;
            }
            actions[choice].execute();
            if (actions[choice].closeAfter()) break;
        }
    }

    private boolean validateUserInput(int choice){
        return choice >= 0 && choice < actions.length;
    }

    private int getMenuIndexFromUser(Scanner scanner){
        System.out.println("Виберіть пункт меню");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice - 1;
    }



    private void showMenu() {
        for (int i = 0; i < actions.length; i++) {
            String actionName = actions[i].getName();
            System.out.println(i+1 + " " + actionName);
        }
    }


}