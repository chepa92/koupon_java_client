package com.viewModel;

import com.MVVMdemoException;
import com.model.IModel;
import com.model.Product;
import com.view.IView;

//you can define 2 IViewModels
public interface IViewModel {
    public void getItems();
    public void getItem(String id);
    public void addItem(String text) throws MVVMdemoException;

    void addItem(Product product) throws MVVMdemoException;

    public void deleteItem() throws MVVMdemoException;
    public void setModel(IModel m) ;
    public void setView(IView v);

    public void login(String name, String pass) ;

    //    public ViewModel{
    //        this.view = setModel();
    //    }

    public void postCoupon(Product product);
}
