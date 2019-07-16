package com.company;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Move extends KeyAdapter {
    static int step = 10;

public void keyPressed(KeyEvent event){
if(event.getKeyCode()==KeyEvent.VK_DOWN&&HeadSneake.direction!=HeadSneake.UP){
HeadSneake.direction=HeadSneake.DOWN;
}
if(event.getKeyCode()==KeyEvent.VK_UP&&HeadSneake.direction!=HeadSneake.DOWN){

}

if(event.getKeyCode()==KeyEvent.VK_LEFT){

}
if(event.getKeyCode()==KeyEvent.VK_RIGHT){

}
}
    }

