package com.viewModel;

import com.MVVMdemoException;
import com.model.IModel;
import com.view.IView;

//you can define 2 IViewModels
public interface IViewModel {
    public void getItems();
    public void getItem(int id);
    public void addItem(String text) throws MVVMdemoException;
    public void deleteItem() throws MVVMdemoException;
    public void setModel(IModel m) ;
    public void setView(IView v);

    public void login();

    public void getSecret();
}
