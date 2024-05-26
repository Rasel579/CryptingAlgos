package ui;

import data.AilerMethod;
import data.AratosfenMethod;
import data.EwqlidMethod;
import data.LinearEstimate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CryptoMethodUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    public void initUi(){
        mainPanel = new JPanel();
        mainFrame = createMainFrame();

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(BorderFactory.createTitledBorder(""));

        JLabel firstNumberTitle = new JLabel( "Первое число"  );
        JTextField firstNumber = new JTextField("",3);
        JLabel secondNumberTitle = new JLabel( " Второе число"  );
        JTextField secondNumber = new JTextField("", 3);

        JPanel equalPanel = new JPanel();
        JLabel equalFieldTitle = new JLabel( "Результат" );
        equalPanel.add(equalFieldTitle);

        JLabel equalField = new JLabel();
        equalPanel.add(equalField);
        JPanel estimateBtnPanel = new JPanel();
        JButton estimateBtn = new JButton( "Расчитать НОД Алгоритмом Евклида." );
        estimateBtn.addActionListener( a -> {
            try {
                equalField.setText( String.valueOf(EwqlidMethod.estimate( Integer.parseInt(firstNumber.getText() ) , Integer.parseInt( secondNumber.getText() ) ) ) );
            } catch ( Exception e){
                equalField.setText( "Неправильный формат чисел" );
            }


        } );

        JButton estimateAstonBtn = new JButton( "Расчитать Последовательность первого числа" );
        estimateAstonBtn.addActionListener( a -> {
            try {
                equalField.setText(AratosfenMethod.estimate( Integer.parseInt( firstNumber.getText() ) ) );
            } catch ( Exception e){
                equalField.setText( "Неправильный формат чисел" );
            }
        } );

        JButton estimateCanonicalBtn = new JButton( "Разложить на канонические множители первого числа" );
        estimateCanonicalBtn.addActionListener( a -> {
            try {
                equalField.setText(AratosfenMethod.estimateCanonical( Integer.parseInt( firstNumber.getText() ) ) );
            } catch ( Exception e){
                equalField.setText( "Неправильный формат чисел" );
            }
        } );

        JPanel estimateAilerBtnPanel = new JPanel();
        JButton estimateAilerBtn = new JButton( "Вычислить функцию Эйлера первого числа" );
        estimateAilerBtn.addActionListener( a -> {
            try {
                equalField.setText(AilerMethod.estimate( Integer.parseInt( firstNumber.getText() ) ) );
            } catch ( Exception e){
                equalField.setText( "Неправильный формат чисел" );
            }
        } );
        estimateBtnPanel.add(estimateBtn);
        estimateBtnPanel.add(estimateAstonBtn );
        estimateBtnPanel.add( estimateCanonicalBtn );
        estimateBtnPanel.add(firstNumberTitle);
        estimateBtnPanel.add( firstNumber );
        estimateBtnPanel.add(secondNumberTitle);
        estimateBtnPanel.add( secondNumber );

        estimateAilerBtnPanel.add(estimateAilerBtn);

        actionPanel.add( estimateBtnPanel,  BorderLayout.NORTH );
        actionPanel.add( estimateAilerBtnPanel, BorderLayout.CENTER );
        mainPanel.add(actionPanel);

        JPanel southPanel = new JPanel();

        JLabel thirdNumberTitle = new JLabel( "a"  );
        JTextField thirdNumber = new JTextField("",3);
        JLabel forthNumberTitle = new JLabel( "b"  );
        JTextField forthNumber = new JTextField("", 3);
        JLabel mNumberTitle = new JLabel( "m"  );
        JTextField mNumber = new JTextField("", 3);
        JButton estimateLinearBtn = new JButton( "Расчитать Линейное уравнение" );
        estimateLinearBtn.addActionListener( a -> {
            try {
                equalField.setText( "x="+String.valueOf( LinearEstimate.estimate( Integer.parseInt(thirdNumber.getText() ) , Integer.parseInt( forthNumber.getText() ), Integer.parseInt( mNumber.getText() ) ) + "mod" + mNumber.getText() ) );
            } catch ( Exception e){
                equalField.setText( "Неправильный формат чисел" );
            }


        } );

        southPanel.add(thirdNumberTitle);
        southPanel.add(thirdNumber);
        southPanel.add(forthNumberTitle);
        southPanel.add(forthNumber);
        southPanel.add(mNumberTitle);
        southPanel.add(mNumber);
        southPanel.add(estimateLinearBtn);

        mainFrame.add( mainPanel, BorderLayout.NORTH );
        mainFrame.add( equalPanel, BorderLayout.CENTER );
        mainFrame.add( southPanel, BorderLayout.SOUTH );
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
