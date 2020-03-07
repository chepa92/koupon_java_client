package com;

import com.model.API;
import com.model.IModel;
import com.model.Model;
import com.view.IView;
import com.view.View;
import com.viewModel.IViewModel;
import com.viewModel.ViewModel;

import javax.swing.*;
import java.net.MalformedURLException;

public class Program {
    public static void main(String[] args) throws MVVMdemoException {

        SwingUtilities.invokeLater((new Runnable() {

            @Override
            public void run() {
                IModel m = new Model();
                IView v = null;
                try {
                    v = new View();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                v.start();
                IViewModel vm = new ViewModel();
                v.setViewModel(vm);
                vm.setModel(m);
                vm.setView(v);

            }
        }));

    }

}
