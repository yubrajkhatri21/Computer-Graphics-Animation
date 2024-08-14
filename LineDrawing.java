import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LineDrawing {
    public static void main(String[] args) {
        JFrame f1 = new JFrame("DDA");
        f1.setSize(600, 500);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lx1 = new JLabel("x1");
        JLabel lx2 = new JLabel("x2");
        JLabel ly1 = new JLabel("y1");
        JLabel ly2 = new JLabel("y2");
        JTextField tx1 = new JTextField(5);
        JTextField tx2 = new JTextField(5);
        JTextField ty1 = new JTextField(5);
        JTextField ty2 = new JTextField(5);

        lx1.setBounds(10, 10, 50, 50);
        tx1.setBounds(70, 10, 50, 50);
        ly1.setBounds(10, 60, 50, 50);
        ty1.setBounds(70, 60, 50, 50);
        lx2.setBounds(10, 110, 50, 50);
        tx2.setBounds(70, 110, 50, 50);
        ly2.setBounds(10, 160, 50, 50);
        ty2.setBounds(70, 160, 50, 50);

        f1.add(lx1);
        f1.add(tx1);
        f1.add(ly1);
        f1.add(ty1);
        f1.add(lx2);
        f1.add(tx2);
        f1.add(ly2);
        f1.add(ty2);

        JButton b1 = new JButton("Draw");
        b1.setBounds(100, 220, 80, 35);
        f1.add(b1);

        // Create a drawing panel
        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setBounds(200, 10, 380, 440);
        f1.add(drawingPanel);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x1 = Integer.parseInt(tx1.getText());
                int y1 = Integer.parseInt(ty1.getText());
                int x2 = Integer.parseInt(tx2.getText());
                int y2 = Integer.parseInt(ty2.getText());

                drawingPanel.drawLineDDA(x1, y1, x2, y2);
            }
        });
    }
}

class DrawingPanel extends JPanel {
    private int x1, y1, x2, y2;
    private boolean drawLine = false;

    public void drawLineDDA(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.drawLine = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (drawLine) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);

            // DDA algorithm
            int dx = x2 - x1;
            int dy = y2 - y1;

            int steps = Math.max(Math.abs(dx), Math.abs(dy));

            float xIncrement = (float) dx / steps;
            float yIncrement = (float) dy / steps;

            float x = x1;
            float y = y1;

            for (int i = 0; i <= steps; i++) {
                g2d.drawRect(Math.round(x), Math.round(y), 1, 1);
                x += xIncrement;
                y += yIncrement;
            }
        }
    }
}
