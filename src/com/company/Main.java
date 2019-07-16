package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Window();
    }


}

class Window extends JFrame{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    Canvas canvas;
    public Window(){
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(WIDTH,HEIGHT);
    setResizable(false);
    setLayout(null);
    setVisible(true);
    canvas = new Canvas();
    add(canvas);
    canvas.setBounds(0,0,WIDTH,HEIGHT);
    }
}

class Canvas extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,Window.WIDTH,Window.HEIGHT);
        /*
        Рисуем изображение головы
        Рисуем нужное количество тел
        Рисуем хвост
        (Нужны картинки)
         */
    }
}