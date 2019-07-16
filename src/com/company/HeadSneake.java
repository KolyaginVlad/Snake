package com.company;

public class HeadSneake {
    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RRIGHT = 4;
    static final int WIDTH = 20;//Длинна и ширина одного блока змеи, будет использоваться в Body
    static final int HEIGHT = 20;
    static int direction;
    //Всё статическое т.к. голова одна
    static int x;
    static int y;

    public HeadSneake(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        //Присваиваем изображению файл с изображением
    }
}
