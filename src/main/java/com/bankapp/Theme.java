package com.bankapp;
import javax.swing.*;import javax.swing.plaf.ColorUIResource;import java.awt.*;
public final class Theme {
 public static final Color BLACK=new Color(12,13,17),PANEL=new Color(25,26,31),GOLD=new Color(232,180,53);
 private Theme(){}
 public static void install(){UIManager.put("OptionPane.background",new ColorUIResource(BLACK));UIManager.put("Panel.background",new ColorUIResource(BLACK));UIManager.put("OptionPane.messageForeground",new ColorUIResource(GOLD));UIManager.put("Label.foreground",new ColorUIResource(GOLD));UIManager.put("TextField.background",new ColorUIResource(PANEL));UIManager.put("TextField.foreground",new ColorUIResource(Color.WHITE));UIManager.put("PasswordField.background",new ColorUIResource(PANEL));UIManager.put("PasswordField.foreground",new ColorUIResource(Color.WHITE));UIManager.put("Button.background",new ColorUIResource(GOLD));UIManager.put("Button.foreground",new ColorUIResource(Color.BLACK));UIManager.put("ButtonUI","com.bankapp.CapsuleButtonUI");UIManager.put("OptionPane.buttonFont",new Font("SansSerif",Font.BOLD,13));UIManager.put("OptionPane.messageFont",new Font("SansSerif",Font.PLAIN,14));}
 public static void button(JButton b){b.setUI(new CapsuleButtonUI());b.setBackground(GOLD);b.setForeground(Color.BLACK);b.setFocusPainted(false);b.setBorderPainted(false);b.setContentAreaFilled(false);b.setFont(new Font("SansSerif",Font.BOLD,15));b.setPreferredSize(new Dimension(180,48));b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));}
}
