import javax.swing.*;
import java.awt.event.*;
public class BresanhamsLineDrawingAlgorithm  {
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

            double x1 = Double.parseDouble(t1.getText());
            double y1 = Double.parseDouble(t2.getText());
            double x2 = Double.parseDouble(t3.getText());
            double y2 = Double.parseDouble(t4.getText());

           

            double loop = Math.max(x2 - x1, y2 - y1);
            for( int i =1; i<=loop; i++)
            {
                JOptionPane.showMessageDialog(f1, "Next("+x1+","+y1+")");
                double dx = x2-x1;
                double dy = y2-y1;
                double p = 2*dy - dx;
            

            if(p<0){
                p = p + 1*dy;
                x1 = x1 + 1;

            }
            else if(p >= 0) {
                p = p + 2*dy - 2*dx;
                x1 = x1 + 1;
                y1 = y1 + 1;


            }
            // else if (m>1){
            //     x1 = 1/m + x1;
            //     y1 = y1 + 1;
            // }

            }

            
           JOptionPane.showMessageDialog(f1,"you entered("+x1+","+x2+") &("+y1+","+y2+")");
 
            }
        });

    }

}