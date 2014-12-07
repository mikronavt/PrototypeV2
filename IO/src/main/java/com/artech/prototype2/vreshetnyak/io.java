/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak;

import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import com.artech.prototype2.vreshetnyak.output.Output;
import com.artech.prototype2.vreshetnyak.output.impl.InitOutputFormImpl;
import com.artech.prototype2.vreshetnyak.output.impl.FormReportImpl;


/**
 *
 * @author Vasilij
 */
public class io {

    public static void main(String[] args) {

//        Input form = new InputFormImpl();
//        form.InputGUIForm();

//        Output o = new InitOutputFormImpl();
//        o.OutputFormTable(args);
        String[] arStrings = {"title", "id"};
        Output oForm = new FormReportImpl("Отчет по статистике", arStrings, null, "Название таблицы");
        oForm.FormReportInit();
    }
}
