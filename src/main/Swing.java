package main;

import main.exceptions.NumberUnderZeroException;
import main.service.PhoneService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Swing {
    PhoneService phoneList;
    JFrame f = new JFrame();//creating instance of JFrame
    ArrayList<Phone> phones = new ArrayList();
    JTextArea desc = new JTextArea();
    JTextField brand = new JTextField();
    JTextField type = new JTextField();
    JTextField price = new JTextField();
    JTextField stock = new JTextField();
    String keyword = "";
    DefaultListModel<String> list = new DefaultListModel<>();


    public Swing(PhoneService phoneList) {
        this.phoneList = phoneList;
        this.phones = phoneList.getAllPhones();
    }

    public void homeScreen() throws NumberUnderZeroException {
        search();
        display();
        exitButton();

        f.setSize(1000, 420);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }

    private void exitButton() {
        JButton exit = new JButton("exit");
        exit.setBounds(900, 350, 70, 30);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.add(exit);
    }

    private void search() throws NumberUnderZeroException {
        searchBar();
        searchResults();
    }

    private void display() {
        attributes();
        description();
    }

    private void searchResults() throws NumberUnderZeroException {
        final int[] phoneNr = new int[1];
        phoneNr[0] = 1;


        if (Objects.equals(keyword, "")) {
            for (int i = 0; i < phones.size(); i++) {
                list.addElement(phoneList.getPhone(i + 1).shortPhone());
            }
        } else {
            for (int i = 0; i < phones.size(); i++) {
                list.addElement(phones.get(i).shortPhone());
            }
        }
        JList<String> results = new JList<>(list);

        results.setBounds(10, 40, 300, 300);

        f.add(results);

        results.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                phoneNr[0] = results.getSelectedIndex();
                Phone phone = phones.get(phoneNr[0]);
                brand.setText(phone.getBrand());
                type.setText(phone.getType());
                price.setText(String.valueOf(phone.getPrice()));
                stock.setText(String.valueOf(phone.getStock()));
                desc.setText(phone.getDescription());

            }
        });

    }

    private void searchBar() {
        final JTextField searchBar = new JTextField("");
        searchBar.setBounds(10, 10, 200, 20);


        final JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    keyword = searchBar.getText();
                    phones = phoneList.searchPhones(keyword);
                    list.clear();
                    if (Objects.equals(keyword, "")) {
                        for (int i = 0; i < phones.size(); i++) {
                            list.addElement(phoneList.getPhone(i + 1).shortPhone());
                        }
                    } else {
                        for (int i = 0; i < phones.size(); i++) {
                            list.addElement(phones.get(i).shortPhone());
                        }
                    }
                    System.out.println(keyword);

                } catch (NumberUnderZeroException ex) {
                    ex.printStackTrace();
                }
            }
        });
        searchButton.setBounds(220, 10, 90, 20);
        f.add(searchButton);
        f.add(searchBar);
    }

    private void attributes() {
        attributeLabels();
        attributeFields();

    }

    private void attributeFields() {
        brand.setBounds(370, 10, 110, 20);
        type.setBounds(370, 30, 110, 20);
        price.setBounds(520, 10, 110, 20);
        stock.setBounds(520, 30, 110, 20);

        brand.setText("");
        type.setText("");
        price.setText("");
        stock.setText("");

        f.add(brand);
        f.add(type);
        f.add(price);
        f.add(stock);
    }

    private void attributeLabels() {
        JLabel brand = new JLabel("Brand: ");
        JLabel type = new JLabel("Type: ");
        JLabel price = new JLabel("Price: ");
        JLabel stock = new JLabel("Stock: ");

        brand.setBounds(320, 10, 50, 20);
        type.setBounds(320, 30, 50, 20);
        price.setBounds(480, 10, 50, 20);
        stock.setBounds(480, 30, 50, 20);

        f.add(brand);
        f.add(type);
        f.add(price);
        f.add(stock);
    }

    private void description() {
        JLabel descLabel = new JLabel("Description: ");
        descLabel.setBounds(320, 50, 100, 20);
        f.add(descLabel);
        desc.setLineWrap(true);

        desc.setBounds(320, 70, 650, 270);
        f.add(desc);
    }
}
