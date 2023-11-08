import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainGridPanel extends JPanel 
{
    private Dimension scaledSize;
    private JTextField txtName;

    public MainGridPanel(Dimension scaledSize)
    {
        this.scaledSize = scaledSize;
        
        setLayout(new GridLayout(5, 1));
        setSize(scaledSize);
        setPreferredSize(scaledSize);
        add(generateNameInputArea());
        add(generateSubmitButtonArea());
    }

    private Component generateSubmitButtonArea() 
    {        
        JPanel subpanel = new JPanel(new GridLayout(1, 3));
        
        // put an unused dummy label in row 1, col 0
        JLabel dummyLeft = new JLabel();
        subpanel.add(dummyLeft);

        // put a button in row 1, col 1
        JButton btn = new JButton("Submit");        
        btn.addActionListener(e -> {
            String msg = String.format("Hello %s", txtName.getText());
            JOptionPane.showMessageDialog(btn, msg);
        });
        subpanel.add(btn);

        // put a dummy label in row 1, col 2
        JLabel dummyRight = new JLabel();
        subpanel.add(dummyRight);

        return subpanel;
    }

    private Component generateNameInputArea() 
    {
        // use a grid layout with one row, two columns
        JPanel subpanel = new JPanel(new GridLayout(1, 2));
        
        JLabel lbl = new JLabel("Enter your name: ");
        // make the text of the label right-justified        
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        subpanel.add(lbl);

        txtName = new JTextField();        
        subpanel.add(txtName);

        return subpanel;
    }
}
