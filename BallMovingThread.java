import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallMovingThread extends JFrame {
    private JButton startButton;
    private JPanel ballPanel;
    private BallThread ballThread;

    public BallMovingThread() {
        setTitle("Ball Moving Thread Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startBall();
            }
        });
        add(startButton, BorderLayout.NORTH);

        ballPanel = new JPanel() {
            private int yPos = 0;
            private final int BALL_SIZE = 20;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(getWidth() / 2 - BALL_SIZE / 2, yPos, BALL_SIZE, BALL_SIZE);
            }
        };
        add(ballPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void startBall() {
        if (ballThread == null || !ballThread.isAlive()) {
            ballThread = new BallThread();
            ballThread.start();
        }
    }

    class BallThread extends Thread {
        private final int DELAY = 50; // Adjust the speed here (milliseconds)
        private final int MOVE_AMOUNT = 5; // Adjust the vertical movement here

        public void run() {
            while (true) {
                moveBall();
                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void moveBall() {
            JPanel panel = ballPanel;
            int yPos = panel.getY() + MOVE_AMOUNT;
            if (yPos > panel.getHeight()) {
                yPos = 0; // Reset ball position if it reaches the bottom
            }
            panel.setLocation(panel.getX(), yPos);
            panel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BallMovingThread();
            }
        });
    }
}
