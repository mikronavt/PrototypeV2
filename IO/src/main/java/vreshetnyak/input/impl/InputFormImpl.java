/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vreshetnyak.input.impl;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import vreshetnyak.input.AbstractInput;

/**
 *
 * @author Василий
 */
public class InputFormImpl extends AbstractInput{

    //private String[] CommandInput = {"Translate", "InMemory", "Statistic", "Analytics"};
    protected JButton SendDataToSensoButton;
    protected JTextArea DataJTextArea;
    protected JComboBox CommandJComboBox;

    /**
     * Унаследованный метод образует форму для ввода команд данных.
     * Команды выбираются из выпадающего списка CommandJComboBox, которые
     * принимает массив команд переменной CommandInput.
     * 
     * На кнопку SendDataToSensoButton повешен слушатель SendDataToSensor()
     * Класс которого описан здесь же. Наследует ActionListener
     * 
     * Выполняет единственный (пока!) метод actionPerformed, который
     * формирует два поля - (String)title и command. 
     * 
     * Метод вызывает метод AcceptTranslateForOutput(title, command) 
     * из объекта класса com.​artech.​prototype.​output.InitOutputForm
     */
    @Override
    public void InputGUIForm() {
        /**
         * Начинаем строить форму
         */
        
        JFrame InputFormFrame = new JFrame("Ввод данных для обработки");
        InputFormFrame.setSize(400, 500);
        InputFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputFormFrame.setLocationRelativeTo(null);
        InputFormFrame.setResizable(false);
        InputFormFrame.setLayout(new GridLayout(2, 2));
        

        /**
         * Menu
         */
        
        JMenuBar BarMenu = new JMenuBar();
        JMenu menu = new JMenu("Команда");

        JMenuItem MItemTranstate = new JMenuItem("Translate");
        JMenuItem MItemInMem = new JMenuItem("InMemory");
        JMenuItem MItemStat = new JMenuItem("Statistic");
        JMenuItem MItemAnalitic = new JMenuItem("Analytics");

        menu.add(MItemTranstate);
        menu.add(MItemInMem);
        menu.add(MItemStat);
        menu.add(MItemAnalitic);

        BarMenu.add(menu);
        InputFormFrame.add(BarMenu);
        
        /**
         * Добавляем выпадающий список
         */
        
//        CommandJComboBox = new JComboBox(CommandInput);
//        JPanel CommandJPanel = new JPanel();
//        CommandJPanel.add(CommandJComboBox);
//        CommandJPanel.setComponentOrientation(ComponentOrientation.UNKNOWN);
//        InputFormFrame.add(CommandJPanel);
        
        /**
         * Добавляем JTextArea для многострочных текстов со скролом
         */

        DataJTextArea = new JTextArea(20, 27);
        DataJTextArea.setLineWrap(true);
        DataJTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(DataJTextArea);
        scrollPane.setViewportView(DataJTextArea);

        InputFormFrame.add(scrollPane);
        InputFormFrame.setVisible(true);
        
    }
    
}
