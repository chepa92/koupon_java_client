package com.viewModel;

import com.MVVMdemoException;
import com.model.IModel;
import com.model.Product;
import com.view.IView;

import javax.swing.*;
import java.util.NoSuchElementException;

import org.json.*;

public class ViewModel implements IViewModel {
    private IModel model;
    private IView view;

    public void setView(IView view){
        this.view = view;
    }

//    @Override
//    public void login() {
//
//    }

    public void setModel(IModel model) {
        this.model = model;
    }

//    public ViewModel{
//        this.view = setModel();
//    }
@Override
public void login(String name, String pass) {
    new Thread( new Runnable() {
        @Override
        public void run() {

            try {
                String string = model.login(name, pass);
//                    String []texts= model.getItemsNames();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            view.loginSucces(name);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Login");
                    }
                });

            } catch (MVVMdemoException e){
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }).start();
}

    public void getSecret() {
        new Thread( new Runnable() {
            @Override
            public void run() {

                try {
                    String string = model.getSecret();
//                    String []texts= model.getItemsNames();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
//                        try {
//                            view.login();
//                        } catch (MVVMdemoException e) {
//                            e.printStackTrace();
//                        }
                            System.out.println("Login");
                        }
                    });

                } catch (MVVMdemoException e){
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }


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

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    @Override
    public void getItem( String id) {
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
    public void addItem(Product product) throws MVVMdemoException {
        new Thread( new Runnable() {
            @Override
            public void run() {

                try {
                     model.postItem(product);
//                    String []texts= model.getItemsNames();
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                view.showItem(product);
                            } catch (MVVMdemoException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (MVVMdemoException e){
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();

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
