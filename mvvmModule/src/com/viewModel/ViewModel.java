package com.viewModel;

import com.MVVMdemoException;
import com.model.IModel;
import com.model.Product;
import com.view.IView;

import javax.swing.*;
import java.util.NoSuchElementException;

public class ViewModel implements IViewModel {
    private IModel model;
    private IView view;

    public void setView(IView view){
        this.view = view;
    }

    public void setModel(IModel model) {
        this.model = model;
    }

//    public ViewModel{
//        this.view = setModel();
//    }

    @Override
    public void getItems() {
        new Thread( new Runnable() {
            @Override
            public void run() {

                try {
                    Product[] products = model.getItems();
//                    String []texts= model.getItemsNames();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                view.showItems(products);
                            } catch (MVVMdemoException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (MVVMdemoException e){
                    e.printStackTrace();

                }


            }
        }).start();
    }

    @Override
    public void getItem( int id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Product p = model.getItem(id);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                view.showItem(p);
                            } catch (MVVMdemoException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (NoSuchElementException | MVVMdemoException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void addItem(String text) throws MVVMdemoException {

    }

    @Override
    public void deleteItem() throws MVVMdemoException {

    }

//    @Override
//    public void setModel(IModel model)  {
//        this.model = model;
//
//    }
}
