import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application implements ActionListener {
    private int cnt = 0;
    private JFrame frame;
    private JPanel panel;
    private JLabel label, lbl;
    
    public Application(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("Number of clicks: 0");
        lbl = new JLabel("");
        JButton button = new JButton("Click me, if you dare");
        
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(lbl);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Application");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Application();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cnt++;
        label.setText("Number of clicks: " + cnt);
        if(cnt % 10 == 0){
            panel.setBackground(new Color(255, 215, 0));
            lbl.setText("YOU FOUND A MYSTERY!!!");
            lbl.setBackground(new Color(0, 0, 255));
        }else{
            lbl.setText("");
            Random num = new Random();
            panel.setBackground(new Color(num.nextInt(256), num.nextInt(256), num.nextInt(256)));
        }
    }
}