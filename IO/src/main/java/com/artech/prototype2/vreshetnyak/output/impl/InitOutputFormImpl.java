/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

import com.artech.prototype2.vreshetnyak.output.AbstractOutput;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Класс-шаблонизатор, обеспечивает вывод информации через перегруженные методы
 * (будут пополняться).
 *
 * @author Василий
 */
public class InitOutputFormImpl extends AbstractOutput {

    protected JTextArea DataJTextArea;
    protected JMenuBar menuBar;
    protected JMenu cMenu;

    /**
     * Метод принимает на вход текст.
     *
     * @param text
     */
    @Override
    public void OutputForm(String text) {
        JFrame OutputForm = new JFrame("Вывод");
        OutputForm.setSize(800, 600);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
        /**
         * Добавляем главное меню на JMenuBar
         */
        menuBar = new JMenuBar();
        cMenu = new JMenu("Меню...");
        /**
         * Устанавливаем сформированное меню на сцену.
         */
        menuBar.add(cMenu);
        OutputForm.setJMenuBar(menuBar);

        /**
         * Помещаем на сцену JTextArea, в который и будут вводиться данные.
         */
        DataJTextArea = new JTextArea(text);
        DataJTextArea.setLineWrap(true);
        DataJTextArea.setWrapStyleWord(true);
        DataJTextArea.setEditable(false);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(DataJTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        OutputForm.add(scrollPane, BorderLayout.CENTER);

        OutputForm.setVisible(true);
    }

    @Override
    public void OutputFormTable(String[] arg) {
        
        String[] columnNames = {
                    "Name",
                    "Last modified",
                    "Type",
                    "Size"
          };
           
          String[][] data = {
                    {"addins", "02.11.2006 19:15", "Folder", ""},
                    {"AppPatch", "03.10.2006 14:10", "Folder", ""},
                    {"assembly", "02.11.2006 14:20", "Folder", ""},
                    {"Boot", "13.10.2007 10:46", "Folder", ""},
                    {"Branding", "13.10.2007 12:10", "Folder", ""},
                    {"Cursors", "23.09.2006 16:34", "Folder", ""},
                    {"Debug", "07.12.2006 17:45", "Folder", ""},
                    {"Fonts", "03.10.2006 14:08", "Folder", ""},
                    {"Help", "08.11.2006 18:23", "Folder", ""},
                    {"explorer.exe", "18.10.2006 14:13", "File", "2,93MB"},
                    {"helppane.exe", "22.08.2006 11:39", "File", "4,58MB"},
                    {"twunk.exe", "19.08.2007 10:37", "File", "1,08MB"},
                    {"nsreg.exe", "07.08.2007 11:14", "File", "2,10MB"},
                    {"avisp.exe", "17.12.2007 16:58", "File", "12,67MB"},
          };
        
        JFrame OutputForm = new JFrame("Вывод");
        OutputForm.setSize(800, 600);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
        /**
         * Добавляем главное меню на JMenuBar
         */
        menuBar = new JMenuBar();
        cMenu = new JMenu("Меню...");
        /**
         * Устанавливаем сформированное меню на сцену.
         */
        menuBar.add(cMenu);
        OutputForm.setJMenuBar(menuBar);

        /**
         * Помещаем на сцену JTextArea, в который и будут вводиться данные.
         */
        JTable table = new JTable(data, columnNames);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        OutputForm.add(scrollPane, BorderLayout.CENTER);

        OutputForm.setVisible(true);
    }
}
