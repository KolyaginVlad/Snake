package com.company;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Move extends KeyAdapter{
    static int step = 30;

public void keyPressed(KeyEvent event){
if(event.getKeyCode()==KeyEvent.VK_DOWN&&HeadSneake.direction!=HeadSneake.UP){
HeadSneake.direction=HeadSneake.DOWN;
HeadSneake.y+=step;
}
if(event.getKeyCode()==KeyEvent.VK_UP&&HeadSneake.direction!=HeadSneake.DOWN){
HeadSneake.direction = HeadSneake.UP;
    HeadSneake.y-=step;
}

if(event.getKeyCode()==KeyEvent.VK_LEFT&&HeadSneake.direction!=HeadSneake.RRIGHT){
HeadSneake.direction = HeadSneake.LEFT;
    HeadSneake.x-=step;
}
if(event.getKeyCode()==KeyEvent.VK_RIGHT&&HeadSneake.direction!=HeadSneake.LEFT){
HeadSneake.direction = HeadSneake.RRIGHT;
    HeadSneake.x+=step;
}
if(event.getKeyCode()==KeyEvent.VK_SPACE){

}
}


    }



