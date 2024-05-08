public interface MenuAction {

    String getName();

    void execute();

    boolean closeAfter();

}