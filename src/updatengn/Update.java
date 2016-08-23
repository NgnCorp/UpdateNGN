package updatengn;

import static java.awt.EventQueue.invokeLater;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Update extends JFrame {

    private static final String ZIP_ARCHIVE = "C:\\NgnUpdater\\Updates\\"; // шлях до архіву
    public static javax.swing.JPanel LoadingPanel;
    public static javax.swing.JLabel LoadingText;
    public static javax.swing.JProgressBar LoadingBar;
    private static double NewVer;

    public static void main(String[] args) {
        JFrame NGN = new JFrame();
        invokeLater(() -> {
            Css.MainFrame(NGN);
            BeforeStart BEFORESTART = new BeforeStart(NGN);
            FindFile(ZIP_ARCHIVE); // Пошук нової версії продукту
            UnZip app = new UnZip();
            app.unZip(ZIP_ARCHIVE+"ver."+NewVer+".zip"); // розархівування нової версії
            try {  
                OpenandShut();
            } catch (InterruptedException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public static void OpenandShut() throws InterruptedException {
        try {
            Runtime.getRuntime().exec("C:\\NgnApp\\dist\\Ngn.exe"); // Запуск програми після розархівування
            Thread.sleep(500);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        Runtime.getRuntime().exit(0);
    }

    public static void FindFile(String str) {
        NewVer = 0;
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                if (Double.valueOf(s.getName().substring(4, 8)) > NewVer) {
                    NewVer = Double.valueOf(s.getName().substring(4, 8));
                }
            }
        }
    }
}
