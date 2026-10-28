package com.bankapp;
import javax.swing.*;import javax.swing.plaf.basic.BasicButtonUI;import java.awt.*;
public class CapsuleButtonUI extends BasicButtonUI {
 @Override public void paint(Graphics g,JComponent c){AbstractButton b=(AbstractButton)c;Graphics2D q=(Graphics2D)g.create();q.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);q.setColor(b.getModel().isPressed()?new Color(170,124,30):b.getModel().isRollover()?new Color(255,215,105):new Color(232,180,53));q.fillRoundRect(0,0,c.getWidth()-1,c.getHeight()-1,c.getHeight(),c.getHeight());q.dispose();super.paint(g,c);}
}
