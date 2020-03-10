package com.viewModel;

import com.MVVMdemoException;
import com.koupon.IModel;
import com.koupon.Product;
import com.view.IView;
/**
 * Definition of ViewModel Interface
 * */
//you can define 2 IViewModels
public interface IViewModel {
    public void getItems();
    public void getItem(String id);
    void addItem(Product product) throws MVVMdemoException;
    public void deleteItem(String item_id) throws MVVMdemoException;
    public void setModel(IModel m) ;
    public void setView(IView v);
    public void login(String name, String pass) ;
    public void updateCoupon(String id,Product product);
    public void postCoupon(Product product);
}
