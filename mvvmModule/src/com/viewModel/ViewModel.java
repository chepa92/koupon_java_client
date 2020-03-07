package com.viewModel;

import com.MVVMdemoException;
import com.model.IModel;
import com.model.Product;
import com.view.IView;

import javax.swing.*;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class ViewModel implements IViewModel {
    private IModel model;
    private IView view;

    public void setView(IView view) {
        this.view = view;
    }


    public void setModel(IModel model) {
        this.model = model;
    }


    @Override
    public void login(String name, String pass) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Boolean statusLogin = model.login(name, pass);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if(statusLogin) {
                                    view.loginSucces(name);
                                }else{
                                    view.loginFail();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (MVVMdemoException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    @Override
    public void postCoupon(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String string = model.postCoupon(product);
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

                } catch (MVVMdemoException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }


    @Override
    public void getItems() {
        new Thread(new Runnable() {
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

                } catch (MVVMdemoException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    @Override
    public void getItem(String id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Product p = model.getItem(id);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                view.showItem(p);
                            } catch (MVVMdemoException | MalformedURLException e) {
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
        new Thread(new Runnable() {
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
                            } catch (MVVMdemoException | MalformedURLException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (MVVMdemoException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }

    @Override
    public void deleteItem(String item_id) throws MVVMdemoException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    model.deleteItem(item_id);
                } catch (MVVMdemoException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

//    @Override
//    public void setModel(IModel model)  {
//        this.model = model;
//
//    }
}
