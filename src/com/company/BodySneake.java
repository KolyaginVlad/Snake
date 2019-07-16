package com.company;

import javax.swing.*;
import java.awt.*;

public class BodySneake {
    //Тел будет много, поэтому не статик
    //Все файлы java  в одном пакете поэтому модификатор доступа не нужен
    ImageIcon image;
    int x;
    int y;
    public BodySneake(int x,int y){
        this.x = x;
        this.y = y;
        image = new ImageIcon("Body.jpg");
        //Присваиваем изображению файл с изображением
    }
}
