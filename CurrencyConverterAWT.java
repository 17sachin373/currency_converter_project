import java.awt.*;
import java.awt.event.*;

public class CurrencyConverterAWT extends Frame implements ActionListener {
    
    private Label labelFrom, labelTo, labelResult;
    private TextField textAmount, textResult;
    private Button btnConvertToINR, btnConvertToUSD, btnQuit;
    
    private static final double usdToInrRate = 74.5; // Example rate, you should use current rate
    private static final double inrToUsdRate = 1 / usdToInrRate;
    
    public CurrencyConverterAWT() {
        // Set up the frame
        setTitle("USD-INR Currency Converter");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2));
        
        // Create components
        labelFrom = new Label("Enter Amount:");
        labelTo = new Label("Result:");
        labelResult = new Label("");
        
        textAmount = new TextField();
        textResult = new TextField();
        textResult.setEditable(false);
        
        btnConvertToINR = new Button("Convert USD to INR");
        btnConvertToUSD = new Button("Convert INR to USD");
        btnQuit = new Button("Quit");
        
        // Add components to the frame
        add(labelFrom);
        add(textAmount);
        add(btnConvertToINR);
        add(btnConvertToUSD);
        add(labelTo);
        add(textResult);
        add(new Label(""));  // Empty cell
        add(labelResult);
        add(btnQuit);
        
        // Add action listeners
        btnConvertToINR.addActionListener(this);
        btnConvertToUSD.addActionListener(this);
        btnQuit.addActionListener(this);
        
        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        
        // Make the frame visible
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvertToINR) {
            convertUSDToINR();
        } else if (e.getSource() == btnConvertToUSD) {
            convertINRToUSD();
        } else if (e.getSource() == btnQuit) {
            System.exit(0);
        }
    }
    
    private void convertUSDToINR() {
        try {
            double usdAmount = Double.parseDouble(textAmount.getText());
            double inrAmount = usdAmount * usdToInrRate;
            textResult.setText(String.format("%.2f INR", inrAmount));
            labelResult.setText(usdAmount + " USD is equivalent to " + inrAmount + " INR");
        } catch (NumberFormatException ex) {
            textResult.setText("Invalid input");
        }
    }
    
    private void convertINRToUSD() {
        try {
            double inrAmount = Double.parseDouble(textAmount.getText());
            double usdAmount = inrAmount * inrToUsdRate;
            textResult.setText(String.format("%.2f USD", usdAmount));
            labelResult.setText(inrAmount + " INR is equivalent to " + usdAmount + " USD");
        } catch (NumberFormatException ex) {
            textResult.setText("Invalid input");
        }
    }
    
    public static void main(String[] args) {
        new CurrencyConverterAWT();
    }
}