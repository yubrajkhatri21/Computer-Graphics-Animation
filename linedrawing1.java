import javax.swing.*;
import java.awt.event.*;
public class linedrawing1 {
    public static void main(String[]args){
        JFrame f1 = new JFrame("DDA");
        f1.setSize(650, 550);
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel j1 = new JLabel("X1");
        j1.setBounds(10, 10, 40, 50);
        JLabel j2 = new JLabel("Y1");
        j2.setBounds(10, 60, 40, 50);
        JLabel j3 = new JLabel("X2");
        j3.setBounds(10, 110, 40, 50);
        JLabel j4 = new JLabel("Y2");
        j4.setBounds(10, 160, 40, 50);;
        JTextField  t1= new JTextField(5);
        t1.setBounds(70, 10, 50, 50);
        JTextField   t2= new JTextField (5);
        t2.setBounds (70, 60, 50, 50);
        JTextField  t3= new JTextField (5);
        t3.setBounds(70, 110, 50, 50);
        JTextField   t4= new JTextField (5);
        t4.setBounds(70, 160, 50, 50);
        f1.add(j1);
        f1.add(j2);
        f1.add(j3);
        f1.add(j4);
        f1.add(t1);
        f1.add(t2);
        f1.add(t3);
        f1.add(t4);

        JButton b1 = new JButton("Draw");
        b1.setBounds(10, 210, 100, 50);
        f1.add(b1);
        b1.addActionListener(new ActionListener() {
    
            public void actionPerformed(ActionEvent e){
            //JOptionPane.showMessageDialog(f1,"Hy");
            int x1 = Integer.parseInt(t1.getText());
            int y1 = Integer.parseInt(t2.getText());
            int x2 = Integer.parseInt(t3.getText());
            int y2 = Integer.parseInt(t4.getText());

            int loop = Math.max(x2 - x1, y2 - y1);
            for( int i =1; i<=loop; i++)
            {
                JOptionPane.showMessageDialog(f1, "Next("+x1+","+y1+")");
            int dx = x2-x1;
            int dy = y2-y1;
            int m = dy/dx;

            if(m<1){
                x1 = x1 + 1;
                y1 = y1 + 1;

            }
            else if(m == 1) {
                x1 = x1 + 1;
                y1 = y1 + 1;

            }
            else if (m>1){
                x1 = 1/m + x1;
                y1 = y1 + 1;
            }

            
            }

           JOptionPane.showMessageDialog(f1,"you entered("+x1+","+x2+") &("+y1+","+y2+")");
 
            }
        });

    }

}