package com.view;

import com.model.Product;
import com.viewModel.IViewModel;
import com.MVVMdemoException;

/**
 * Drfinig function for UI
 */
public interface IView {
    public void setMessage(String text) throws MVVMdemoException;
    public void showItem(Product item) throws MVVMdemoException;
    public void showItems(Product[] items) throws MVVMdemoException;
    public void setViewModel(IViewModel ob);
    public void start();
    }
