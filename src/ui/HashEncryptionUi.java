package ui;

import data.HashEncryption;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HashEncryptionUi {
    public void  initUi(){
        JPanel mainPanel = new JPanel();
        JFrame mainFrame = createMainFrame();

        HashEncryption encriptions = new HashEncryption();

        JLabel inputTitle = new JLabel( "Введите сообщение" );
        JTextField inputText = new JTextField("",10);
        JLabel outputTitle = new JLabel( "Хэш сообщения" );
        JLabel outputText = new JLabel("");

        mainPanel.add(inputTitle);
        mainPanel.add(inputText);
        mainPanel.add(outputTitle);
        mainPanel.add(outputText);

        JButton encryptBtn = new JButton( "Зашифровать сообщение" );
        encryptBtn.addActionListener( a -> {
            try {
                outputText.setText( encriptions.encrypt( inputText.getText() ));
            } catch ( Exception e){
                outputText.setText( "Ошибка" );
            }
        } );

        JButton decryptBtn = new JButton( "Проверить подпись сообщения" );
        decryptBtn.addActionListener( a -> {
            try {
                outputText.setText( encriptions.decrypt() );
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
