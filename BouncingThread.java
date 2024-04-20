import java.awt.*;
import javax.swing.*;

class BouncingThread extends JFrame implements Runnable {
    Thread t;
    int x, y;

    BouncingThread() {
        super();
        t = new Thread(this);
        x = 10;
        y = 10;
        t.start();
        setSize(500, 500);
        setVisible(true);
        setTitle("BOUNCING BALL WINDOW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        try {
            while (true) {
                x += 10;
                y += 10;
                if (x >= getWidth() || y >= getHeight()) {
                    x = 10;
                    y = 10;
                }
                repaint();
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
    }

    public static void main(String a[]) throws Exception {
        new BouncingThread();
    }
}