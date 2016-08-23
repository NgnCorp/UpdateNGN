package updatengn;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author Офис
 */
public class Css {

    static java.awt.GridBagConstraints gridBagConstraints;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int windowHeight = screenSize.height;
    public static int windowWidth = screenSize.width;

    public static void MainFrame(JFrame MFrame) {
        MFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MFrame.setUndecorated(true);
        MFrame.pack();
        MFrame.setSize(windowWidth, windowHeight);
        MFrame.setLocationRelativeTo(null);
        MFrame.setLayout(new CardLayout());
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(16, 16, pixels, 0, 16));
        Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
        MFrame.setCursor(transparentCursor);
        MFrame.setVisible(true);
    }

    static void cssBeforeStart(JPanel LoadingPanel, JLabel LoadingText, JProgressBar LoadingBar) {

        LoadingPanel.setVisible(true);
        LoadingPanel.setBackground(new Color(204, 0, 0));
        LoadingPanel.setLayout(new GridBagLayout());

        LoadingPanel.setName("LoadingPanel");

        LoadingText.setFont(new Font("Candara", 1, 24)); // NOI18N
        LoadingText.setForeground(new Color(255, 255, 255));
        LoadingText.setHorizontalAlignment(SwingConstants.CENTER);
        LoadingText.setText("Подождите. Идет обновление приложения...");
        LoadingText.setToolTipText("");
        LoadingPanel.add(LoadingText, new GridBagConstraints());

        LoadingBar.setIndeterminate(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(5, 10, 5, 10);
        LoadingPanel.add(LoadingBar, gridBagConstraints);
    }
}
