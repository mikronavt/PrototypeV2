package com.artech.prototype2.io;

import com.artech.prototype2.io.api.IOAPI;
import com.artech.prototype2.io.api.InOutApiImpl;
import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import com.artech.prototype2.vreshetnyak.output.Output;
import com.artech.prototype2.vreshetnyak.output.impl.FormReportImpl;
import com.artech.prototype2.vreshetnyak.output.impl.InitOutputFormImpl;
import com.artech.prototype2.vreshetnyak.utils.GetDataFromInputForm;

/**
 * Главный класс модуля IO
 *
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
//        Input form = new InputFormImpl();
//        form.InputGUIForm();
//        /*
//         * Спим 10 сек 
//         */
//        Thread.sleep(10000);
//        
//        /*
//         * Возвращаем текст с формы
//         */
//        GetDataFromInputForm d = new GetDataFromInputForm(form);
//        System.out.println(d.getData().toString());
//        
//        Output o = new InitOutputFormImpl();
//        o.OutputForm(args);
//
//        String[] arStrings = {"RUID", "WORLD", "COUNT"};
//        AbstractDao test = new DictionaryRuDaoImpl();
//
//        Output oForm = new FormReportImpl("Отчет по статистике", arStrings, test, "Название таблицы");
//        oForm.FormReportInit();
        
        InOutApiImpl.getInstance().registery("InputGUIForm", new InputFormImpl());
        InOutApiImpl.getInstance().getCommon("InputGUIForm");
        

    }
    
    
}
