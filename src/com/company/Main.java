package com.company;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new HeadSneake(100, 0, 4);
        new BodySneake(50, 0);
        new GameStart();
        new Hay();

    }


}
class GameStart extends JFrame{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    static CanvasForGameStart canvas;
    static boolean play = true;
    public GameStart(){
        super("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        canvas = new CanvasForGameStart();
        add(canvas);
        canvas.setBounds(0,0,WIDTH,HEIGHT);
        JButton start = new JButton();
        start.setText("Начать игру");
        start.setBackground(Color.blue.darker());
        start.setFocusable(false);
        JButton top = new JButton("Рейтинг");
        top.setFocusable(false);
        top.setBackground(Color.CYAN.darker());
        canvas.add(start);
        canvas.add(top);
        start.setBounds(200,200,150,50);
        top.setBounds(200,300,150,50);
        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Window();
                setVisible(false);
                play=false;
                dispose();
            }
        });
        HayForStartGame.eatHay();
        HeadSneakeForStartGame.x=0;
        HeadSneakeForStartGame.y=0;
        HeadSneakeForStartGame.bodysForStartGame.add(new BodySneake(HeadSneakeForStartGame.x-HeadSneakeForStartGame.WIDTH,HeadSneakeForStartGame.y));
        HeadSneakeForStartGame.bodysForStartGame.add(new BodySneake(HeadSneakeForStartGame.x-2*HeadSneakeForStartGame.WIDTH,HeadSneakeForStartGame.y));
        new DrawForStartGameThread().start();
    }
}



class Window extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static ArrayList<BodySneake> bodySneakeArrayList;

    public static boolean game;
    static Canvas canvas;
  

    public Window() {
        super("Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        bodySneakeArrayList = new ArrayList<>();
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
                int x = e.getX();
                int y = e.getY();
                if (x>480&&x<520&&y>500&&y<530&&HeadSneake.direction!=HeadSneake.RRIGHT)
                    HeadSneake.direction=HeadSneake.LEFT;
                else if (x>550&&x<590&&y>500&&y<530&&HeadSneake.direction!=HeadSneake.LEFT)
                    HeadSneake.direction=HeadSneake.RRIGHT;
                else if (x>520&&x<550&&y>460&&y<500&&HeadSneake.direction!=HeadSneake.DOWN)
                    HeadSneake.direction=HeadSneake.UP;
                else if (x>520&&x<550&&y>530&&y<570&&HeadSneake.direction!=HeadSneake.UP)
                    HeadSneake.direction=HeadSneake.DOWN;
                else if(x>520&&x<550&&y>500&&y<530)
                    Window.game=true;
            }
        });



    }
}


class Canvas extends JPanel {
    static boolean first = true;
    @Override
    public void paintComponent(Graphics g) {
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
            HeadSneake.isSnakeEat();
            HeadSneake.isCrash();
        }
        else {
            first = false;
            Window.bodySneakeArrayList.add(new BodySneake(HeadSneake.x - HeadSneake.WIDTH, HeadSneake.y));
            Window.bodySneakeArrayList.add(new BodySneake(HeadSneake.x - (2 * HeadSneake.WIDTH), HeadSneake.y));
            Window.bodySneakeArrayList.add(new BodySneake(HeadSneake.x-(3*HeadSneake.WIDTH),HeadSneake.y));
        }
        g.setColor(Color.green.darker().darker());
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        g.setColor(Color.BLUE);
        g.drawRect(480, 500, 40, 30);
        g.drawRect(550, 500, 40, 30);
        g.drawOval(520, 500, 30, 30);
        g.drawRect(520, 460, 30, 40);
        g.drawRect(520, 530, 30, 40);
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
    }
}

class CanvasForGameStart extends JPanel{
    static boolean first = true;
    @Override
    public void paintComponent(Graphics g) {
        if (!first) {
            int x = HeadSneakeForStartGame.x;
            int y = HeadSneakeForStartGame.y;
            HeadSneakeForStartGame.sneakeMove();
            for (int i = HeadSneakeForStartGame.bodysForStartGame.size() - 1; i > 0; i--) {
                HeadSneakeForStartGame.bodysForStartGame.get(i).x = HeadSneakeForStartGame.bodysForStartGame.get(i - 1).x;
                HeadSneakeForStartGame.bodysForStartGame.get(i).y = HeadSneakeForStartGame.bodysForStartGame.get(i - 1).y;
            }
            try {
                HeadSneakeForStartGame.bodysForStartGame.get(0).y = y;
                HeadSneakeForStartGame.bodysForStartGame.get(0).x = x;
            }catch (Exception e){

            }
            HeadSneakeForStartGame.isSnakeEat();
        }
        else {
            first = false;
        }
        g.setColor(Color.green.darker().darker());
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        g.setColor(Color.orange.darker());
        g.fillRect(HeadSneakeForStartGame.x, HeadSneakeForStartGame.y, HeadSneakeForStartGame.WIDTH, HeadSneakeForStartGame.HEIGHT);
        g.setColor(Color.red.darker());
        g.drawRect(HeadSneakeForStartGame.x, HeadSneakeForStartGame.y, HeadSneakeForStartGame.WIDTH, HeadSneakeForStartGame.HEIGHT);
        for (BodySneake body : HeadSneakeForStartGame.bodysForStartGame) {
            g.setColor(Color.orange.darker());
            g.fillRect(body.x, body.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
            g.setColor(Color.red.darker());
            g.drawRect(body.x, body.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);

        }
        g.setColor(Color.red.darker());
        g.fillOval(HayForStartGame.x, HayForStartGame.y, HeadSneake.WIDTH, HeadSneake.HEIGHT);
    }
}


class DrawThread extends Thread {
    @Override
    public void run() {
        while (true)
            while (Window.game) {
                Window.canvas.repaint();
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

class DrawForStartGameThread extends Thread{
    @Override
    public void run() {
        while (GameStart.play) {
            GameStart.canvas.repaint();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}