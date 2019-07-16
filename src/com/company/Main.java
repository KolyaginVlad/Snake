package com.company;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new HeadSneake(100, 0, 4);
        new BodySneake(50, 0);
        new Window();
        new Hay();

    }


}

class Window extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static ArrayList<BodySneake> bodySneakeArrayList;

    public static boolean game;
    static Canvas canvas;

    public Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        bodySneakeArrayList = new ArrayList<>();
        bodySneakeArrayList.add(new BodySneake(HeadSneake.x - HeadSneake.WIDTH, HeadSneake.y));
        bodySneakeArrayList.add(new BodySneake(HeadSneake.x - (2 * HeadSneake.HEIGHT), HeadSneake.y));
        Hay.eatHay();
        HeadSneake.x = 100;
        HeadSneake.y = 0;
        HeadSneake.direction = HeadSneake.RRIGHT;
        canvas = new Canvas();
        add(canvas);
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setFocusable(true);
        canvas.addKeyListener(new Move());
        new DrawThread().start();
    }
}


class Canvas extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.green.darker().darker());
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        g.setColor(Color.orange.darker());
        g.fillRect(HeadSneake.x, HeadSneake.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
        g.setColor(Color.red.darker());
        g.drawRect(HeadSneake.x, HeadSneake.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
        for (BodySneake body : Window.bodySneakeArrayList) {
            g.setColor(Color.orange.darker());
            g.fillRect(body.x, body.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
            g.setColor(Color.red.darker());
            g.drawRect(body.x, body.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);

        }
        g.setColor(Color.orange);
        g.fillOval(Hay.x, Hay.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);


        HeadSneake.sneakeMove();

        /*
        Рисуем изображение головы
        Рисуем нужное количество тел
        Рисуем хвост
        Рисуем сено
        (Нужны картинки)
         */
    }
}

class DrawThread extends Thread {
    @Override
    public void run() {
        while (true)
        while (Window.game) {
            Window.canvas.repaint();
            try {
                sleep(125);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}