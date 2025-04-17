package BankApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GUI extends JFrame implements ActionListener {

    private DB db;
    private JTextField accountNumberField;
    private JButton balanceButton;
    private JButton payButton;
    private JButton transferButton;
    private JTextField amountField = null;
    private JTextField recipientField = null;
    private JButton confirmButton = null;
    private JPanel contentPanel;


    private JTextArea resultArea;

    public GUI(DB db) {
        this.db = db;
        setTitle("Банковское приложение");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new FlowLayout());
        contentPanel = new JPanel(new FlowLayout());
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));


        accountNumberField = new JTextField(15);


        balanceButton = new JButton("Баланс");
        payButton = new JButton("Оплата");
        transferButton = new JButton("Перевод");


        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        balanceButton.addActionListener(this);
        payButton.addActionListener(this);
        transferButton.addActionListener(this);

        contentPanel.add(transferButton);

        add(new JLabel("Номер счета:"));
        add(accountNumberField);
        add(balanceButton);
        add(payButton);
        add(transferButton);
        add(new JScrollPane(resultArea));
        add(contentPanel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == balanceButton) {
            double accountNumber = Double.parseDouble(accountNumberField.getText());
            try {
                if (accountNumber >= 1 && accountNumber <= 5) {
                    resultArea.setText(String.valueOf(db.SelectFromTable("baseclient", (int) accountNumber)));

                } else if (accountNumber >= 6 && accountNumber <= 10) {
                    resultArea.setText(String.valueOf(db.SelectFromTable("premiumclient", (int) accountNumber)));

                } else if (accountNumber >= 11 && accountNumber <= 15) {
                    resultArea.setText(String.valueOf(db.SelectFromTable("vipclient", (int) accountNumber)));


                }

            } catch (SQLException ex) {
                resultArea.setText("Ошибка базы данных: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                resultArea.setText("Ошибка: Отсутствует класс драйвера JDBC");
            }
        }

        if (e.getSource() == payButton) {
            double accountNumber = Double.parseDouble(accountNumberField.getText());
            try {
                if (accountNumber >= 1 && accountNumber <= 5) {
                    if (db.SelectFromTable("baseclient", (int) accountNumber) < 100) {
                        resultArea.setText("Недостаточно средств для оплаты");
                    } else {
                        db.UpdateTableMinus("baseclient", (int) accountNumber, 100);

                    }


                } else if (accountNumber >= 6 && accountNumber <= 10) {
                    resultArea.setText("У вас бесплатное обслуживание");

                } else if (accountNumber >= 11 && accountNumber <= 15) {
                    resultArea.setText("У вас бесплатное обслуживание");
                }


            } catch (SQLException ex) {
                resultArea.setText("Ошибка базы данных: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                resultArea.setText("Ошибка: Отсутствует класс драйвера JDBC");
            }
        }
        if (e.getSource() == transferButton) {
            double senderNumber = Double.parseDouble(accountNumberField.getText());
            double recipientNumber = Double.parseDouble(recipientField.getText());
            double amount = Double.parseDouble(amountField.getText());


            if (recipientField == null) {
                JPanel recipientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JLabel recipientLabel = new JLabel("Номер получателя:");
                recipientField = new JTextField(15);

                recipientPanel.add(recipientLabel);
                recipientPanel.add(recipientField);

                contentPanel.add(recipientPanel);
            }

            if (amountField == null) {
                JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JLabel amountLabel = new JLabel("Сумма:");
                amountField = new JTextField(15);

                amountPanel.add(amountLabel);
                amountPanel.add(amountField);

                contentPanel.add(amountPanel);
            }

            if (confirmButton == null) {
                confirmButton = new JButton("Подтвердить перевод");
                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (senderNumber != recipientNumber) {
                            if (senderNumber >= 1 && senderNumber <= 5) {
                                try {
                                    db.UpdateTableMinus("baseclient", (int) senderNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }


                            } else if (senderNumber >= 6 && senderNumber <= 10) {
                                try {
                                    db.UpdateTableMinus("premiumclient", (int) senderNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }

                            } else if (senderNumber >= 11 && senderNumber <= 15) {
                                try {
                                    db.UpdateTableMinus("vipclient", (int) senderNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }


                            }

                            if (recipientNumber >= 1 && recipientNumber <= 5) {
                                try {
                                    db.UpdateTablePlus("baseclient", (int) recipientNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else if (recipientNumber >= 6 && recipientNumber <= 10) {
                                try {
                                    db.UpdateTablePlus("premiumclient", (int) recipientNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }


                            } else if (recipientNumber >= 11 && recipientNumber <= 15) {
                                try {
                                    db.UpdateTablePlus("vipclient", (int) recipientNumber, (int) amount);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } catch (ClassNotFoundException ex) {
                                    throw new RuntimeException(ex);
                                }


                            }
                        }
                    }


                });

                contentPanel.revalidate();
                contentPanel.repaint();


            }
        }
    }

}
