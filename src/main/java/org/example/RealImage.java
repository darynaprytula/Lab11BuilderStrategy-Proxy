package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RealImage implements MyImage {

    private static final int MAX_SIZE = 300;
    private static final int CONFETTI_SIZE = 8;
    private static final int FALL_SPEED_MIN = 5;
    private static final int TIMER_DELAY = 30;
    private static final int STOP_TIME = 3000;

    private final JFrame frame;
    private final ConfettiPanel confettiPanel;

    public RealImage(String filename) {
        frame = new JFrame("Image with Confetti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon(filename);
        Image scaledImage = icon.getImage().getScaledInstance(MAX_SIZE, -1, Image.SCALE_SMOOTH);

        if (scaledImage.getHeight(null) > MAX_SIZE) {
            scaledImage = icon.getImage().getScaledInstance(-1, MAX_SIZE, Image.SCALE_SMOOTH);
        }

        JLabel label = new JLabel(new ImageIcon(scaledImage));
        frame.add(label, BorderLayout.CENTER);

        JButton confettiButton = new JButton("Show Confetti 🎉");
        frame.add(confettiButton, BorderLayout.SOUTH);

        confettiPanel = new ConfettiPanel();
        frame.setGlassPane(confettiPanel);

        confettiButton.addActionListener(e -> confettiPanel.startConfetti());

        frame.pack();

        Dimension size = frame.getSize();
        int width = Math.min(size.width, MAX_SIZE);
        int height = Math.min(size.height, MAX_SIZE);
        frame.setSize(width, height);
        frame.setResizable(false);
    }

    static class ConfettiPanel extends JComponent {

        private static final int CONFETTI_COUNT = 100;
        private static final Color[] CONFETTI_COLORS = {
                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE
        };

        private final Random rand = new Random();
        private final int[] x = new int[CONFETTI_COUNT];
        private final int[] y = new int[CONFETTI_COUNT];
        private final Color[] confettiColor = new Color[CONFETTI_COUNT];
        private boolean running = false;

        ConfettiPanel() {
            setOpaque(false);
            setVisible(false);

            for (int i = 0; i < CONFETTI_COUNT; i++) {
                x[i] = rand.nextInt(MAX_SIZE);
                y[i] = rand.nextInt(MAX_SIZE);
                confettiColor[i] = CONFETTI_COLORS[rand.nextInt(CONFETTI_COLORS.length)];
            }
        }

        void startConfetti() {
            running = true;
            setVisible(true);

            new Timer(TIMER_DELAY, e -> {
                if (!running) {
                    ((Timer) e.getSource()).stop();
                }

                for (int i = 0; i < CONFETTI_COUNT; i++) {
                    y[i] += FALL_SPEED_MIN + rand.nextInt(FALL_SPEED_MIN);

                    if (y[i] > getHeight()) {
                        y[i] = 0;
                        x[i] = rand.nextInt(getWidth());
                    }
                }
                repaint();
            }).start();

            new Timer(STOP_TIME, e -> {
                running = false;
                setVisible(false);
            }).start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (!running) {
                return;
            }

            for (int i = 0; i < CONFETTI_COUNT; i++) {
                g.setColor(confettiColor[i]);
                g.fillOval(x[i], y[i], CONFETTI_SIZE, CONFETTI_SIZE);
            }
        }
    }

    @Override
    public void display() {
        frame.setVisible(true);
    }
}
