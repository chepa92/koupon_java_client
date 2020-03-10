package com.view;

import com.koupon.Product;
import com.viewModel.IViewModel;
import com.MVVMdemoException;

import java.net.MalformedURLException;

/**
 * Defining View interface
 */
public interface IView {
    public void setMessage(String text) throws MVVMdemoException; //No exceptions
    public void showItem(Product item) throws MVVMdemoException, MalformedURLException;
    public void showItems(Product[] items) throws MVVMdemoException;
    public void setViewModel(IViewModel ob);
    public void start();

    public void loginSucces(String name);
    public void loginFail();

    void updateFaild();

    void updateSuccess();
}
