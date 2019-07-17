package com.company;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Move extends KeyAdapter {
    public void keyPressed(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_DOWN && HeadSneake.direction != HeadSneake.UP) {
            HeadSneake.direction = HeadSneake.DOWN;

        }
        if (event.getKeyCode() == KeyEvent.VK_UP && HeadSneake.direction != HeadSneake.DOWN) {
            HeadSneake.direction = HeadSneake.UP;

        }

        if (event.getKeyCode() == KeyEvent.VK_LEFT && HeadSneake.direction != HeadSneake.RRIGHT) {
            HeadSneake.direction = HeadSneake.LEFT;

        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT && HeadSneake.direction != HeadSneake.LEFT) {
            HeadSneake.direction = HeadSneake.RRIGHT;

        }
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            Window.game = true;
        }
    }
}

