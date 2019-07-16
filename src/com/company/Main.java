package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        new Window();
    }


}

class Window extends JFrame{
    public Window(){
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(600,600);
    setResizable(false);
    setLayout(null);
    setVisible(true);
    }
}