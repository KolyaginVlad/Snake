package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BodySneake {
    //Тел будет много, поэтому не статик
    //Все файлы java  в одном пакете поэтому модификатор доступа не нужен
    Image image;
    int x;
    int y;
    public BodySneake(int x,int y){
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(new File("Body.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
