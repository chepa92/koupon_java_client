package com.model;

import com.MVVMdemoException;

//You can add more functions
public interface IModel {
    public Product[] getItems() throws Exception;
    public Product getItem(int id) throws MVVMdemoException;

    public String[] getItemsNames() throws MVVMdemoException;
    public String[] getItemsPrice() throws MVVMdemoException;
    public String[] getItemsDesc() throws MVVMdemoException;
    public void addItem(String text) throws  MVVMdemoException;
    public void deleteItem() throws MVVMdemoException;
    public String login() throws MVVMdemoException, Exception;

    public String getSecret() throws MVVMdemoException, Exception;
}
