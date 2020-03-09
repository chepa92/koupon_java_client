package com.view;

import com.viewModel.IViewModel;
import com.MVVMdemoException;
import com.model.Product;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;

import javax.swing.SpringLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class View implements IView  {

    JFrame loginFrame;
   JFrame frame, formFrame, updateFrame;
    JButton bt, bt1, bt2, bt3, bt4, bt5, bt6;
    JTextField tf, nametf, passtf, titleTf, discountTf, linkTf , imgTf;
    JTextField newTitle, newDiscount, newLink, newImg;
    JList<Product> list;
    DefaultListModel<Product> model;
    JLabel lable, lable1, lable2, name, pass, lblTitle, lblDiscount, lblLink, lblImg, lblStatus, lblTitle2, lblDiscount2, lblLink2, lblImg2, lblStatus2;
    JPanel panel, statusPanel;
    JPanel loginPanel, formPanel, updatePanel;
    JPanel navPanel;
    JSplitPane splitPane;
    JScrollPane scrollPane;
    IViewModel viewmodel;
    JSeparator separator;
     String current_id;
    ImageIcon imageIcon;
    JLabel heroShot;

    public IViewModel getViewmodel() {
        return viewmodel;
    }

    public void setViewmodel(IViewModel viewmodel) {
        this.viewmodel = viewmodel;
    }


    public View() throws MalformedURLException {
        loginFrame = new JFrame("Login:");
        loginPanel = new JPanel();
        formFrame = new JFrame("Add new coupon");
        updateFrame = new JFrame("Update coupon");
        formPanel = new JPanel();
        updatePanel = new JPanel();
        statusPanel = new JPanel();
        nametf = new JTextField(10);
        passtf =new JTextField(10);
        titleTf = new JTextField(30);
        discountTf = new JTextField(30);
        linkTf = new JTextField(30);
        imgTf = new JTextField(30);
        newTitle = new JTextField(30);
        newDiscount = new JTextField(30);
        newLink = new JTextField(30);
        newImg = new JTextField(20);
        frame = new JFrame("Koupon");
        list = new JList<>();
        model = new DefaultListModel<>();
        panel = new JPanel();
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
        lblImg = new JLabel("Img Link: ");
        lblStatus = new JLabel();
        lblTitle2 = new JLabel("Title: ");
        lblDiscount2 = new JLabel("Discount: ");
        lblLink2  = new JLabel("Link: ");
        lblImg2 = new JLabel("Img Link: ");
        lblStatus = new JLabel();
        lblStatus2 = new JLabel();
        tf = new JTextField(20);
        bt = new JButton("See All Items");
        bt1 = new JButton("Add new coupon");
        bt2 = new JButton("Delete");
        bt3 = new JButton("Update");
        bt4 = new JButton("Update Coupon");
        bt5 = new JButton("Login");
        bt6 = new JButton("Save");

        separator = new JSeparator(SwingConstants.VERTICAL);

        URL url = new URL( "http://www.pptback.com/broken-glass-effects-pptbackground.html");
        imageIcon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
        heroShot = new JLabel(imageIcon);


    }

    public void start(){

        //Login panel elements
        loginPanel.setSize(300,500);
        loginPanel.add(name);
        loginPanel.add(nametf);
        loginPanel.add(pass);
        loginPanel.add(passtf);

        loginPanel.add(bt5);
        statusPanel.add(lblStatus);
        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.add(statusPanel, BorderLayout.NORTH);


        //Form panel elements
        formFrame.setSize(300,300);
        SpringLayout layout = new SpringLayout();
        BoxLayout boxLayout = new BoxLayout(formPanel, BoxLayout.Y_AXIS);
        formPanel.setLayout(boxLayout);
        formPanel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

        formPanel.add(lblTitle2);
        formPanel.add(titleTf);
        formPanel.add(lblDiscount2);
        formPanel.add(discountTf);
        formPanel.add(lblLink2);
        formPanel.add(linkTf);
        formPanel.add(lblImg2);
        formPanel.add(imgTf);
        formPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        formPanel.add(bt6);

        formFrame.add(formPanel);
        formFrame.pack();

        //Update Form

        updateFrame.setSize(300,300);
//      SpringLayout layout = new SpringLayout();
        BoxLayout boxLayout2 = new BoxLayout(updatePanel, BoxLayout.Y_AXIS);
        updatePanel.setLayout(boxLayout2);
        updatePanel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

        updatePanel.add(lblTitle);
        updatePanel.add(newTitle);
        updatePanel.add(lblDiscount);
        updatePanel.add(newDiscount);
        updatePanel.add(lblLink);
        updatePanel.add(newLink);
        updatePanel.add(lblImg);
        updatePanel.add(newImg);
        updatePanel.add(Box.createRigidArea(new Dimension(0, 60)));
        updatePanel.add(bt4);
        updatePanel.add(lblStatus2);

        updateFrame.add(updatePanel);
        updateFrame.pack();

        //Main Dashboard elements
        list.setModel(model);

        panel.setSize(300, 500);
        splitPane.setLeftComponent(scrollPane);
        splitPane.setSize(200, 500);
        panel.add(lable);
        panel.add(lable1);
        panel.add(lable2);
        panel.add(heroShot);

        splitPane.setRightComponent(panel);

        navPanel.add(bt2);
        navPanel.add(separator);
        navPanel.add(bt);
        navPanel.add(bt1);
        navPanel.add(bt3);


        frame.add(navPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
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

        //Add new coupon button
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formFrame.setVisible(true);
            }

        });
        //Update coupon
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.setVisible(true);
            }

        });
        //Update coupon button click handler
        bt4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(current_id);
                String id = current_id;
                String title = newTitle.getText();
                String discount = newDiscount.getText();
                String link = newLink.getText();
                String img = newImg.getText();

                Product product = new Product(title, discount, link, img);
                viewmodel.updateCoupon(id, product);
//                updateFrame.setVisible(false);
            }
        });

        //Save new coupon button handler
        bt6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTitle = titleTf.getText();
                String newDiscount = discountTf.getText();
                String newLink = linkTf.getText();
                String ImgLink ;
                if(imgTf.getText().equals("")){
                     ImgLink = "http://www.pptback.com/broken-glass-effects-pptbackground.html";
                }else{
                     ImgLink = imgTf.getText();
                }
                Product product = new Product(newTitle, newDiscount, newLink, ImgLink);
                viewmodel.postCoupon(product);
                formFrame.setVisible(false);
            }
        });

        //Delete coupon button handler
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewmodel.deleteItem(current_id);
                } catch (MVVMdemoException ex) {
                    ex.printStackTrace();
                }
            }
        });


        list.addListSelectionListener(e -> {
                Product p = list.getSelectedValue();
            try {
                this.showItem(p);
            } catch (MVVMdemoException | MalformedURLException ex) {
                ex.printStackTrace();
            }
        });

        frame.setVisible(false);
        formFrame.setVisible(false);
        frame.setSize(600,400);
        loginFrame.setVisible(true);
        loginFrame.setSize(600,400);


    }

    @Override
    public void loginSucces(String name) {
        lblStatus.setText("Welcome" + name);
        frame.setVisible(true);
        loginFrame.setVisible(false);

    }

    @Override
    public void loginFail() {
        lblStatus.setForeground(Color.red);
        lblStatus.setText("Incorrect User Name or Password");

    }

    @Override
    public void updateFaild() {
        lblStatus2.setForeground(Color.red);
        lblStatus2.setText("Update Faild");
    }

    @Override
    public void updateSuccess() {
        lblStatus2.setForeground(Color.green);
        lblStatus2.setText("Updated Successfully");
    }

    @Override
    public void setMessage(String text) throws MVVMdemoException {
        tf.setText(text);
    }

    @Override
    public void showItem(Product item) throws MVVMdemoException, MalformedURLException {

        current_id = item.getId();

        newTitle.setText(item.getTitle());
        newDiscount.setText(item.getDiscount());
        newLink.setText(item.getLink());
        newImg.setText(item.getImg());

        lable.setText("Name: " + item.getTitle() );
        lable1.setText("Discount: " + item.getDiscount() );
        lable2.setText("Link: " + item.getLink() );
        URL url2 = new URL(item.getImg());

         imageIcon = new ImageIcon(new ImageIcon(url2).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
         heroShot.setIcon(imageIcon);
        System.out.println("Showing item: " + current_id);


    }

    @Override
    public void showItems(Product[] items) throws MVVMdemoException {
   if(model.getSize() > 0){
       model.removeAllElements();
   }
    for(Product item: items){
        model.addElement(item);
    }

    }

    public void setViewModel(IViewModel ob){
        viewmodel = ob;
    }
}
