package ui;

import data.ElGamalEncryption;
import data.HashEncryption;
import data.SymmetricEncryptingUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EncryptionGamalUi {

    public void  initUi(){
        JPanel mainPanel = new JPanel();
        JFrame mainFrame = createMainFrame();

        ElGamalEncryption encriptions = new ElGamalEncryption();

        JLabel inputTitle = new JLabel( "Введите сообщение" );
        JTextField inputText = new JTextField("",10);
        JLabel outputTitle = new JLabel( "Результат" );
        JLabel outputText = new JLabel("");

        mainPanel.add(inputTitle);
        mainPanel.add(inputText);
        mainPanel.add(outputTitle);
        mainPanel.add(outputText);

        JButton encryptBtn = new JButton( "Зашифровать сообщение" );
        encryptBtn.addActionListener( a -> {
            try {
                HashEncryption hash  = new HashEncryption();
                hash.encrypt( inputText.getText() );
                outputText.setText( encriptions.encrypt( inputText.getText() ));
            } catch ( Exception e){
                outputText.setText( "Ошибка" );
            }
        } );

        JButton decryptBtn = new JButton( "Расшифровать сообщение" );
        decryptBtn.addActionListener( a -> {
            try {
                outputText.setText( encriptions.decryptMessage() );
            } catch ( Exception e){
                outputText.setText( "Ошибка" );
            }
        } );

        mainPanel.add(encryptBtn);
        mainPanel.add(decryptBtn);

        mainFrame.add(mainPanel, BorderLayout.NORTH );
        mainFrame.setVisible( true );
    }

    private JFrame createMainFrame() {
        return getFrame();
    }

    @NotNull
    static JFrame getFrame() {
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

