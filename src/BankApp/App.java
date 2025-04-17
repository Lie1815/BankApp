package BankApp;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DB db = new DB();

        SwingUtilities.invokeLater(() -> {
            GUI bankGUI = new GUI(db);
            // Передача DB в BankGUI
        });
        //Menu menu = new Menu(db);

        /*JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 1000); // размеры окна
        frame.setLocationRelativeTo(null); // окно - в центре экрана
        JButton enterButton = new JButton("Войти"); // Экземпляр класса JButton
        enterButton.setMaximumSize(new Dimension(150, 50));
        enterButton.setBackground(Color.white);
        enterButton.setOpaque(true);  // Важно!  Нужно установить opaque в true

        // getContentPane() - клиентская область окна
        frame.getContentPane().add(enterButton); // Добавляем кнопку на Frame
        frame.setVisible(true); // Делаем окно видимым





/*
        BasicClient basic1 = new BasicClient("Охложон Бобиев Магамедочив", "", 200);
        BasicClient basic2 = new BasicClient("Бабомурод Бобиев Магамедочив", "", 300);
        BasicClient basic3 = new BasicClient("Зухра Бобиева Магамедовна", "", 100);
        BasicClient basic4 = new BasicClient("Магамед Бобиев Эльханович", "", 2500);
        BasicClient basic5 = new BasicClient("Тайга Бобиева Маркаряновна", "", 50);

        PremiumClient premium1 = new PremiumClient("Александр Сергеевич Пушкин", "", 50000);
        PremiumClient premium2 = new PremiumClient("Сергей Александрович Есенин", "", 60000);
        PremiumClient premium3 = new PremiumClient("Федор Михайлович Достоевский", "", 45000);
        PremiumClient premium4 = new PremiumClient("Лев Николаевич Толстой", "", 100000);
        PremiumClient premium5 = new PremiumClient("Николай Васильевич Гоголь", "", 89000);

        VIPClient vip1 = new VIPClient("Серега Евгеньевич Маляр", "", 900000000);
        VIPClient vip2 = new VIPClient("Арсен Ашотович Маркарян", "", 50000000);
        VIPClient vip3 = new VIPClient("Иосиф Виссарионович Джугашвили", "", 10000000);
        VIPClient vip4 = new VIPClient("Илон Рив Маск", "", 820000000);
        VIPClient vip5 = new VIPClient("Брюс Вейн Бетмен", "", 200000000);

 */

        //Menu.mainMenu();
        // db.isConnection();
        //db.CreateTable("BasicClient", "account_number SERIAL PRIMARY KEY", "full_name VARCHAR(200)", "balance DECIMAL(20,2)");
        //db.CreateTable("PremiumClient", "account_number SERIAL PRIMARY KEY", "full_name VARCHAR(200)", "balance DECIMAL(20,2)");
        //db.CreateTable("VIPClient", "account_number SERIAL PRIMARY KEY", "full_name VARCHAR(200)", "balance DECIMAL(20,2)");

        /*db.InsertTable("BasicClient", "1", "Охложон Бобиев Магамедочив", "200.00");
        db.InsertTable("BasicClient", "2", "Бабомурод Бобиев Магамедочив", "300.00");
        db.InsertTable("BasicClient", "3", "Зухра Бобиева Магамедовна", "100.00");
        db.InsertTable("BasicClient", "4", "Магамед Бобиев Эльханович", "2500.00");
        db.InsertTable("BasicClient", "5", "Тайга Бобиева Маркаряновна", "50.00");

        db.InsertTable("PremiumClient", "6", "Александр Сергеевич Пушкин", "50000.00");
        db.InsertTable("PremiumClient", "7", "Сергей Александрович Есенин", "60000.00");
        db.InsertTable("PremiumClient", "8", "Федор Михайлович Достоевский", "45000.00");
        db.InsertTable("PremiumClient", "9", "Лев Николаевич Толстой", "100000.00");
        db.InsertTable("PremiumClient", "10", "Николай Васильевич Гоголь", "89000.00");

        db.InsertTable("VIPClient", "11", "Серега Евгеньевич Маляр", "9999999999.00");
        db.InsertTable("VIPClient", "12", "Арсен Ашотович Маркарян", "599999999.00");
        db.InsertTable("VIPClient", "13", "Иосиф Виссарионович Джугашвили", "100000000");
        db.InsertTable("VIPClient", "14", "Илон Рив Маск", "890000000.00");
        db.InsertTable("VIPClient", "15", "Брюс Вейн Бетмен", "200000000.00");
*/
        //menu.mainMenu();








    }




}