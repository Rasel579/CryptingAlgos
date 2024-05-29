package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static ui.EncryptingUI.getFrame;

public class MainFrame {

    public void initUi(){

        JPanel mainPanel = new JPanel();
        JFrame mainFrame = createMainFrame();

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder(""));

        JButton chooseBtn = new JButton( "Открыть теорию чисел" );
        chooseBtn.addActionListener( a -> {
            CryptoMethodUI ui = new CryptoMethodUI();
            ui.initUi();
        });

        JButton encryptUiBtn = new JButton( "Открыть Шифрование Сообщений" );
        encryptUiBtn.addActionListener(MainFrame::actionPerformed);

        JButton encryptUiBtnElGamal = new JButton( "Открыть Шифрование Сообщений El Gamal" );
        encryptUiBtnElGamal.addActionListener( a -> {
            EncryptionGamalUi uiSEncrypt = new EncryptionGamalUi();
            uiSEncrypt.initUi();
        });

        JButton hashEncryptUiBtnElGamal = new JButton( "Открыть Проверку подписей сообщений" );
        hashEncryptUiBtnElGamal.addActionListener( a -> {
            HashEncryptionUi uiSEncrypt = new HashEncryptionUi();
            uiSEncrypt.initUi();
        });

        actionPanel.add(chooseBtn);
        actionPanel.add(encryptUiBtn);
        actionPanel.add(encryptUiBtnElGamal);
        actionPanel.add(hashEncryptUiBtnElGamal);
        mainFrame.add(actionPanel);
        mainFrame.add(mainPanel, BorderLayout.NORTH );
        mainFrame.setVisible( true );
    }
    private JFrame createMainFrame() {
        return getFrame();
    }

    private static void actionPerformed(ActionEvent a) {
        EncryptingUI uiSEncrypt = new EncryptingUI();
        uiSEncrypt.initUi();
    }
}
