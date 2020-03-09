package com.model;

import com.MVVMdemoException;

//You can add more functions
public interface IModel {
    public Product[] getItems() throws Exception;
    public Product getItem(String id) throws MVVMdemoException;
    public void  postItem(Product product) throws Exception;
    public boolean updateItem(String id , Product product) throws Exception ;
    public void deleteItem(String item) throws Exception;
    public Boolean login(String name, String pass) throws Exception;
    public String postCoupon(Product product) throws Exception;
}
