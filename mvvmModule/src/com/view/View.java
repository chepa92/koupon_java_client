package com.view;

import com.viewModel.IViewModel;
import com.MVVMdemoException;
import com.model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements IView {

    JFrame loginFrame;
   JFrame frame;
    JButton bt, bt1, bt2, bt3, bt4, bt5;
    JTextField tf, nametf, passtf;
    JList<Product> list;
    DefaultListModel<Product> model;
    JLabel lable, name, pass;
    JPanel panel;
    JPanel loginPanel;
    JPanel searchPanel;
    JPanel navPanel;
    JSplitPane splitPane;
    JScrollPane scrollPane;
    IViewModel viewmodel;
    JSeparator separator;


    public IViewModel getViewmodel() {
        return viewmodel;
    }

    public void setViewmodel(IViewModel viewmodel) {
        this.viewmodel = viewmodel;
    }


    public View(){
        loginFrame = new JFrame("Login:");
        loginPanel = new JPanel();
        nametf = new JTextField(20);
        passtf =new JTextField(20);
        frame = new JFrame("Computers Storage");
        list = new JList<>();
        model = new DefaultListModel<>();
        panel = new JPanel();
       // searchPanel = new JPanel();
        navPanel = new JPanel();
        splitPane = new JSplitPane();
        scrollPane = new JScrollPane(list);
        name = new JLabel("User Name");
        pass= new JLabel("Password");
        lable = new JLabel();
        tf = new JTextField(20);
        bt = new JButton("See All Items");
        bt1 = new JButton("Add");
        bt2 = new JButton("Delete");
        bt3 = new JButton("Update");
        bt4 = new JButton("Search");
        bt5 = new JButton("Login");
        separator = new JSeparator(SwingConstants.VERTICAL);


    }

    public void start(){
        loginPanel.setSize(300,500);
        loginPanel.add(name);
        loginPanel.add(nametf);
        loginPanel.add(pass);
        loginPanel.add(passtf);

        loginPanel.add(bt5);
        loginFrame.add(loginPanel, BorderLayout.CENTER);

        list.setModel(model);
//        searchPanel.add(bt4);
 //       searchPanel.add(tf);

        panel.setSize(300, 500);
        splitPane.setLeftComponent(scrollPane);
        splitPane.setSize(200, 500);
        panel.add(lable);
        splitPane.setRightComponent(panel);



        navPanel.add(tf);
        navPanel.add(bt4);
        navPanel.add(separator);
        navPanel.add(bt);
        navPanel.add(bt1);
        navPanel.add(bt2);
        navPanel.add(bt3);

//        frame.setLayout(new FlowLayout());
        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        //frame.add(searchPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewmodel.getItems();
            }
        });

        bt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username= nametf.getText();
                String pass = passtf.getText();
                viewmodel.login(username, pass);
            }
        });

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewmodel.getSecret();
            }
        });

//        bt1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                viewmodel.addItem("Hello");
//            }
//        });


        list.addListSelectionListener(e -> {
                Product p = list.getSelectedValue();
//               viewmodel.getItem(list.getSelectedValue().getId());
            try {
                this.showItem(p);
            } catch (MVVMdemoException ex) {
                ex.printStackTrace();
            }
        });

        // frame.pack();
        frame.setVisible(false);
        frame.setSize(600,400);
        loginFrame.setVisible(true);
        loginFrame.setSize(600,400);


    }

    @Override
    public void loginSucces(String name) {
        frame.setVisible(true);
        loginFrame.setVisible(false);

    }

    @Override
    public void setMessage(String text) throws MVVMdemoException {
        tf.setText(text);
    }

    @Override
    public void showItem(Product item) throws MVVMdemoException {
        lable.setText("Name: " + item.getName() + "\n Price: "+ item.getPrice() + "\n" + item.getDesc());
    }

    @Override
    public void showItems(Product[] items) throws MVVMdemoException {
    /*    String str = "items:";
        for (String item : items){
             str += "..." + item;
        }
        tf.setText(str);*/
    for(Product item: items){
        model.addElement(item);
    }

    }

    public void setViewModel(IViewModel ob){
        viewmodel = ob;
    }
}
