package com.model;

import com.MVVMdemoException;

//You can add more functions
public interface IModel {
    public Product[] getItems() throws Exception;
    public Product getItem(int id) throws MVVMdemoException;
    public void  postItem(Product product) throws Exception;

    public String[] getItemsNames() throws MVVMdemoException;
    public String[] getItemsPrice() throws MVVMdemoException;
    public String[] getItemsDesc() throws MVVMdemoException;
    public void addItem(String text) throws  MVVMdemoException;
    public void deleteItem() throws MVVMdemoException;
<<<<<<< HEAD


//    void postItems(Product product);
=======
    public String login() throws MVVMdemoException, Exception;

    public String getSecret() throws MVVMdemoException, Exception;
>>>>>>> 8d3762b9924f0b5af37b6712627b3a1ab86c2439
}
