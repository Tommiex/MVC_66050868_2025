import javax.swing.SwingUtilities;
import View.*;
import Controller.*;

public class Main {

    public static void main(String[] args) {
        Manage manage = new Manage();
    
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window(manage);
                new SuperheroDatabaseView(manage);
            }
        });
    }
    
}