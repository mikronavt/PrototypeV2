/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output.impl;

import com.artech.prototype2.saver.titov.dao.DAO;
import com.artech.prototype2.vreshetnyak.output.AbstractOutput;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Василий
 */
public class FormReportImpl extends AbstractOutput{
    protected String nameForm;
    protected String[] nameColumns;
    protected DAO inTable;
    protected String nameTable;

    public FormReportImpl(String nameForm, String[] nameColumns, DAO inTable, String nameTable) {
        this.nameForm = nameForm;
        this.nameColumns = nameColumns;
        this.inTable = inTable;
        this.nameTable = nameTable;
    }
    
    @Override
    public void OutputForm(String text) {
        
    }

     /**
     * FormReport(nameForm, countColum, название_колонки1, название_колонки2, ... , название_колонкиN, 
     * Название_таблицы) и создается форма в которую передаются данные из бд
     * 
     */
    @Override
    public void FormReportInit() {
        
        String[][] data = {};
        
        JFrame OutputForm = new JFrame(nameForm);
        OutputForm.setSize(800, 600);
        OutputForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OutputForm.setLocationRelativeTo(null);
        OutputForm.setResizable(false);
        OutputForm.setLayout(new BorderLayout());
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
