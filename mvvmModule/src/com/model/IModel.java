package com.model;

import com.MVVMdemoException;

//You can add more functions
public interface IModel {
    public Product[] getItems() throws Exception;
    public Product getItem(String id) throws MVVMdemoException;
    public void  postItem(Product product) throws Exception;

    public String[] getItemsNames() throws MVVMdemoException;
    public String[] getItemsPrice() throws MVVMdemoException;
    public String[] getItemsDesc() throws MVVMdemoException;
    public void addItem(String text) throws  MVVMdemoException;
    public void deleteItem(String item) throws Exception;


//    void postItems(Product product);
    public String login(String name, String pass) throws MVVMdemoException, Exception;

    public String postCoupon(Product product) throws MVVMdemoException, Exception;
}
