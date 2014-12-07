/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

import com.artech.prototype2.vreshetnyak.output.AbstractOutput;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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

    /**
     * FormReport(nameForm, countColum, название_колонки1, название_колонки2, ... , название_колонкиN, 
     * Название_таблицы) и создается форма в которую передаются данные из бд
     * 
     */
    @Override
    public void FormReport(String nameForm, String[] nameColumns, String nameTable) {
        
        String[][] data = {};
        
        JFrame OutputForm = new JFrame(nameForm);
        OutputForm.setSize(800, 600);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
        /**
         * Добавляем главное меню на JMenuBar
         */
        //menuBar = new JMenuBar();
        //cMenu = new JMenu("Меню...");
        /**
         * Устанавливаем сформированное меню на сцену.
         */
        //menuBar.add(cMenu);
        //OutputForm.setJMenuBar(menuBar);

        /**
         * Помещаем на сцену JTable, в который и будут вводиться данные.
         */
        JTable table = new JTable(data, nameColumns);
        /**
         * Полоса прокруточки
         */
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel tablePanel = new JPanel(new GridLayout(1, 1));
        tablePanel.setBorder(BorderFactory.createTitledBorder(nameTable));
        tablePanel.add(scrollPane);
        
        OutputForm.add(tablePanel, BorderLayout.CENTER);

        OutputForm.setVisible(true);
    }
}
