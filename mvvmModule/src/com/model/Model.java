package com.model;

import com.MVVMdemoException;

import java.util.NoSuchElementException;

public class Model implements IModel {

    Product[] computerProducts = {
            new Product("Lenovo", 2000, "L1222 Lenovo i7 Pc" ),
            new Product("Samsung", 1850, "Samsung new Computer"),
            new Product("HP", 1200, "HP Computer")
    };

    @Override
    public Product[] getItems() throws MVVMdemoException {
        return computerProducts;
    }

    @Override
    public Product getItem(int id) throws NoSuchElementException {
        for (Product product: computerProducts) {
            if (product.getId() == id)
                return product;
          else
              throw new NoSuchElementException();
        }
        return null;
    }

    @Override
    public String[] getItemsNames()  {
        String[] productsNames = new String[computerProducts.length];
        for(int i = 0 ; i< computerProducts.length; i++){
              productsNames[i] = computerProducts[i].toString();
        }
        return productsNames;
    }

    @Override
    public String[] getItemsPrice() throws MVVMdemoException {
        return new String[0];
    }

    @Override
    public String[] getItemsDesc() throws MVVMdemoException {
        return new String[0];
    }

    @Override
    public void addItem(String text) throws MVVMdemoException {

    }

    @Override
    public void deleteItem() throws MVVMdemoException {

    }
}
