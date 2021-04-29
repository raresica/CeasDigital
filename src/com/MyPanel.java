package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MyPanel extends JPanel {
    private final int panelWidth = 605, panelHeight = 200;


    private String stringDate, stringTime;

    private Font timeFont, dateFont;

    public MyPanel(){
        timeFont = new Font("TimesNewRoman", Font.BOLD, 50);
        dateFont = new Font("TimesNewRoman", Font.ITALIC, 50);

        Timer secondsTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        secondsTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        LocalDate localDate = LocalDate.now();
        stringDate = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

        LocalTime localTime = LocalTime.now();
        stringTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));



        int length = findMinimumBetweenTwoNumbers(this.getWidth(),this.getHeight());

        g.setColor(Color.BLACK);
        g.setFont(dateFont);
        g.drawString(stringDate,(length/10), (int) (length/1.3));

        g.setColor(Color.BLUE);
        g.setFont(timeFont);
        g.drawString(stringTime, length, length / 3);
    }


    public int findMinimumBetweenTwoNumbers(int a, int b) {
        return Math.min(a, b);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(panelWidth, panelHeight);
    }
}

