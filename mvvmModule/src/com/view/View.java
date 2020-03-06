package com.view;

import com.viewModel.IViewModel;
import com.MVVMdemoException;
import com.model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class View implements IView {

    JFrame loginFrame;
   JFrame frame, formFrame;
    JButton bt, bt1, bt2, bt3, bt4, bt5, bt6;
    JTextField tf, nametf, passtf, titleTf, discountTf, linkTf ;
    JList<Product> list;
    DefaultListModel<Product> model;
    JLabel lable, lable1, lable2, name, pass, lblTitle, lblDiscount, lblLink;
    JPanel panel;
    JPanel loginPanel, formPanel;
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
        formFrame = new JFrame();
        formPanel = new JPanel();
        nametf = new JTextField(20);
        passtf =new JTextField(20);
        titleTf = new JTextField(20);
        discountTf = new JTextField(20);
        linkTf = new JTextField(20);
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
        lable1 = new JLabel();
        lable2 = new JLabel();
        lblTitle = new JLabel("Title: ");
        lblDiscount = new JLabel("Discount: ");
        lblLink = new JLabel("Link: ");
        tf = new JTextField(20);
        bt = new JButton("See All Items");
        bt1 = new JButton("Add new coupon");
        bt2 = new JButton("Delete");
        bt3 = new JButton("Update");
//        bt4 = new JButton("Search");
        bt5 = new JButton("Login");
        bt6 = new JButton("Save");

        separator = new JSeparator(SwingConstants.VERTICAL);



    }

    public void start(){

        //Login panel elements
        loginPanel.setSize(300,500);
        loginPanel.add(name);
        loginPanel.add(nametf);
        loginPanel.add(pass);
        loginPanel.add(passtf);

        loginPanel.add(bt5);
        loginFrame.add(loginPanel, BorderLayout.CENTER);

        //Form panel elements
        formPanel.setSize(250,300);

        formPanel.add(lblTitle);
        formPanel.add(titleTf);
        formPanel.add(lblDiscount);
        formPanel.add(discountTf);
        formPanel.add(lblLink);
        formPanel.add(linkTf);
        formPanel.add(bt6);

        formPanel.setLayout(new FlowLayout());
        formFrame.setSize(300,300);
        formFrame.add(formPanel);


//        formFrame.add(formPanel, BorderLayout.CENTER);

        list.setModel(model);
//        searchPanel.add(bt4);
 //       searchPanel.add(tf);

        panel.setSize(300, 500);
        splitPane.setLeftComponent(scrollPane);
        splitPane.setSize(200, 500);
        panel.add(lable);
        panel.add(lable1);
        panel.add(lable2);
        splitPane.setRightComponent(panel);

        navPanel.add(bt2);
//        navPanel.add(tf);
        navPanel.add(separator);
        navPanel.add(bt);
        navPanel.add(bt1);
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

        //add new coupon button

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formFrame.setVisible(true);
            }

        });

        bt6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String newTitle = titleTf.getText();
                String newDiscount = discountTf.getText();
                String newLink = linkTf.getText();
                Product product = new Product(newTitle, newDiscount, newLink);
                viewmodel.postCoupon(product);
                formFrame.setVisible(false);


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
            } catch (MVVMdemoException | MalformedURLException ex) {
                ex.printStackTrace();
            }
        });

        // frame.pack();
        frame.setVisible(false);
        formFrame.setVisible(false);
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
    public void showItem(Product item) throws MVVMdemoException, MalformedURLException {




        lable.setText("Name: " + item.getTitle() );
        lable1.setText("Discount: " + item.getDiscount() );
        lable2.setText("Link: " + item.getLink() );
        URL url = new URL(item.getImg());
        ImageIcon heroShotImage = new ImageIcon(url);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        JPanel heroShotPanel = new JPanel();
        JLabel heroShot = new JLabel(imageIcon);
        heroShotPanel.add(heroShot);
        this.panel.add(heroShot);
        System.out.println("size");




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
