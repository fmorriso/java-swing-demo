import javax.swing.*;
import java.awt.*;

public class HelloDemo extends JFrame
{    
    private JLabel lblName;
    private JTextField txtName;
    private JButton btnClick;

    private Dimension scaledSize;

    public HelloDemo(String title, Dimension scaledSize)
    {
        super(title);

        // remember our scaled size
        this.scaledSize = scaledSize;        
        
        
        setSize(scaledSize);
        setPreferredSize(scaledSize);

        setContentPane(new MainGridPanel(scaledSize));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // puts the JFrame in the middle of the physical screen
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        
    }

    private void addControls(JPanel pnl) 
    {
        lblName = new JLabel("Enter your name:");
        lblName.setBackground(Color.ORANGE);
        pnl.add(lblName);

        txtName = new JTextField();
        txtName.setBackground(Color.PINK);
        int w = (int) (scaledSize.getWidth() * 0.25);
        int h = (int) (scaledSize.getHeight() * 0.10);
        txtName.setSize(w, h);
        pnl.add(txtName);

        btnClick = new JButton("Greeting");
        btnClick.addActionListener(e -> {
            String msg = String.format("Hello %s", txtName.getText());
            JOptionPane.showMessageDialog(btnClick, msg);
        });
        pnl.add(btnClick);
    }



}
