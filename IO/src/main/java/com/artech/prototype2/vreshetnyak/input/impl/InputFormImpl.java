/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.input.impl;

import javax.swing.*;
import com.artech.prototype2.vreshetnyak.input.AbstractInput;
import com.artech.prototype2.vreshetnyak.utils.ValidationPathAndUrl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author Василий
 */
public class InputFormImpl extends AbstractInput {

    protected String command = null;
    protected int maskTypeData;
    protected String[] item = {"Translate", "InMemory", "Statistic", "Analytics"};
    protected JButton SendDataToSensorButton;
    protected JTextArea DataJTextArea;
    protected JMenuBar menuBar;
    protected JMenu commandMenu;
    protected JMenuItem translateItem;
    protected JMenuItem inMemoryItem;
    protected JMenuItem statisticItem;
    protected JMenuItem analyticsItem;
    
    protected ValidationPathAndUrl validator;

    /**
     * Унаследованный метод образует форму для ввода команд данных. Команды
     * выбираются из выпадающего списка CommandJComboBox, которые принимает
     * массив команд переменной CommandInput.
     *
     * На кнопку SendDataToSensoButton повешен слушатель SendDataToSensor()
     * Класс которого описан здесь же. Наследует ActionListener
     *
     * Выполняет единственный (пока!) метод actionPerformed, который формирует
     * два поля - (String)title и command.
     *
     * Метод вызывает метод AcceptTranslateForOutput(title, command) из объекта
     * класса com.​artech.​prototype.​output.InitOutputForm
     */
    @Override
    public void InputGUIForm() {
        /**
         * Начинаем строить форму
         */
        JFrame InputFormFrame = new JFrame("Ввод данных для обработки");
        InputFormFrame.setSize(800, 600);
        InputFormFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InputFormFrame.setLocationRelativeTo(null);
        InputFormFrame.setResizable(false);
        InputFormFrame.setLayout(new BorderLayout());

        /**
         * JMenuBar
         */
        menuBar = new JMenuBar();
        commandMenu = new JMenu("Команды");

        translateItem = new JMenuItem(item[0]);
        translateItem.addActionListener(new MenuActionListener());
        commandMenu.add(translateItem);

        inMemoryItem = new JMenuItem(item[1]);
        inMemoryItem.addActionListener(new MenuActionListener());
        commandMenu.add(inMemoryItem);

        statisticItem = new JMenuItem(item[2]);
        statisticItem.addActionListener(new MenuActionListener());
        commandMenu.add(statisticItem);

        analyticsItem = new JMenuItem(item[3]);
        analyticsItem.addActionListener(new MenuActionListener());
        commandMenu.add(analyticsItem);

        menuBar.add(commandMenu);
        InputFormFrame.setJMenuBar(menuBar);

        /**
         * JTextArea
         */
        JPanel panel = new JPanel();
        SendDataToSensorButton = new JButton("Send");
        SendDataToSensorButton.addActionListener(new SendActionListener());
        panel.add(SendDataToSensorButton);
        InputFormFrame.add(panel, BorderLayout.SOUTH);

        DataJTextArea = new JTextArea();
        DataJTextArea.setLineWrap(true);
        DataJTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(DataJTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        InputFormFrame.add(scrollPane, BorderLayout.CENTER);

        InputFormFrame.setVisible(true);
    }

    class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            command = e.getActionCommand();

        }
    }

    class SendActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            /*
             * item = {"Translate", "InMemory", "Statistic", "Analytics"};
             */
            String s[] = DataJTextArea.getText().split("\n");
            File file = new File(s[0]);
            /**
             * Проверяем, выбрана ли команда.
             */
            if (command != null) {
                /**
                 * Проверка на короткие тексты. Если коротки, то выводим JOptionPane
                 */
                if (DataJTextArea.getText().length() >= 20) {
                    /**
                     * В разбитом тексте по сплиту берем первый элемент
                     * и проверяем валидность пути к папке/файлу через exists();
                     * и сравнимаем выбранную команду.
                     * Когда все удачно, полю @maskTypeData присваивается 0. 
                     */
                    if (file.exists() && (command.equals(item[1]) | command.equals(item[2]))) {
                        maskTypeData = 0;
                        validator = new ValidationPathAndUrl();
                        validator.printArrayList(validator.validation(s, maskTypeData));
                    }
                    /**
                     * В разбитом тексте по сплиту берем первый элемент
                     * и проверяем валидность url-пути;
                     * и сравнимаем выбранную команду.
                     * Когда все удачно, полю @maskTypeData присваивается 1. 
                     */                    
                    else if (s[0].startsWith("http") && (command.equals(item[1]) | command.equals(item[2]))) {
                        maskTypeData = 1;
                        validator = new ValidationPathAndUrl();
                        validator.printArrayList(validator.validation(s, maskTypeData));
                    } 
                    /**
                     * При остальных условиях берется просто текст.
                     * Полю @maskTypeData присваивается -1. 
                     */
                    else {
                        maskTypeData = -1;
                        /**
                         * Принимаем текст как есть из JTextArea.
                         */
                        String DataToSensor = DataJTextArea.getText();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Введенный текст слишком короткий!",
                            "Внимание!",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Команда не выбрана!",
                        "Внимание!",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
