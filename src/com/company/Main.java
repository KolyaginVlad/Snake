package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        bodySneakeArrayList.add(new BodySneake(HeadSneake.x - (2 * HeadSneake.WIDTH), HeadSneake.y));
        bodySneakeArrayList.add(new BodySneake(HeadSneake.x-(3*HeadSneake.WIDTH),HeadSneake.y));
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
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX()>480&&e.getX()<520&&e.getY()>500&&e.getY()<520&&HeadSneake.direction!=HeadSneake.RRIGHT)
                    HeadSneake.direction=HeadSneake.LEFT;
                else if (e.getX()>540&&e.getX()<580&&e.getY()>500&&e.getY()<520&&HeadSneake.direction!=HeadSneake.LEFT)
                    HeadSneake.direction=HeadSneake.RRIGHT;
                else if (e.getX()>520&&e.getX()<540&&e.getY()>460&&e.getY()<500&&HeadSneake.direction!=HeadSneake.DOWN)
                    HeadSneake.direction=HeadSneake.UP;
                else if (e.getX()>520&&e.getX()<540&&e.getY()>520&&e.getY()<560&&HeadSneake.direction!=HeadSneake.UP)
                    HeadSneake.direction=HeadSneake.DOWN;
                else if(e.getX()>520&&e.getX()<540&&e.getY()>500&&e.getY()<520)
                    Window.game=true;
            }
        });

    }
}


class Canvas extends JPanel {
    static boolean first = true;
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.green.darker().darker());
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        g.setColor(Color.BLUE);
        g.drawRect(480, 500, 40, 20);
        g.drawRect(540, 500, 40, 20);
        g.drawOval(520, 500, 20, 20);
        g.drawRect(520, 460, 20, 40);
        g.drawRect(520, 520, 20, 40);
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
        g.setColor(Color.red.darker());
        g.fillOval(Hay.x, Hay.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
        g.setColor(Color.orange);
        g.drawOval(Hay.x, Hay.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
        if (!first) {
            int x = HeadSneake.x;
            int y = HeadSneake.y;
            HeadSneake.sneakeMove();
            for (int i = Window.bodySneakeArrayList.size() - 1; i > 0; i--) {
                Window.bodySneakeArrayList.get(i).x = Window.bodySneakeArrayList.get(i - 1).x;
                Window.bodySneakeArrayList.get(i).y = Window.bodySneakeArrayList.get(i - 1).y;
            }
            Window.bodySneakeArrayList.get(0).y = y;
            Window.bodySneakeArrayList.get(0).x = x;
        }
        else first=false;
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