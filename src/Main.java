import ui.MainFrame;

import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MainFrame ui = new MainFrame();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                ui.initUi();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }
}