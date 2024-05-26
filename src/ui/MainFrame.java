package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {

    private JFrame mainFrame;
    private JPanel mainPanel;
    public void initUi(){

        mainPanel = new JPanel();
        mainFrame = createMainFrame();

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder(""));

        JButton estimateBtn = new JButton( "Открыть теорию чисел" );
        estimateBtn.addActionListener( a -> {
            CryptoMethodUI ui = new CryptoMethodUI();
            ui.initUi();
        });
        actionPanel.add(estimateBtn);
        mainFrame.add(actionPanel);
        mainFrame.add( mainPanel, BorderLayout.NORTH );
        mainFrame.setVisible( true );
    }
    private JFrame createMainFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle( "Number Theory" );
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize( 400,  500);
        mainFrame.setMaximumSize(new Dimension( 400, 500 ) );
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });

        return mainFrame;
    }
}
