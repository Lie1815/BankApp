package BankApp;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private DB db;

    public Menu(DB db){
        this.db = db;
    }

    public void mainMenu() throws SQLException, ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        int accountNumber;

        while (true){
            System.out.println("введите номер аккаунта ");
            accountNumber = scan.nextInt();

            if (accountNumber <= 0 || accountNumber > 15){
                System.out.println("данного аккаунта нет");
                System.out.println("введите корректный номер\n");
            }
            else {
                System.out.println("1. Баланс");
                System.out.println("2. Переводы");
                System.out.println("3. Оплата услуг");
                System.out.println("0. Выход");
                System.out.println("Выберите услугу");

                int choice = scan.nextInt();
                scan.nextLine();

                if (accountNumber >= 1 && accountNumber <= 5) {
                    switch (choice) {
                        case 1:
                            db.SelectFromTable("baseclient", accountNumber);
                            break;
                        case 2:

                            break;

                        case 3:
                            System.out.println("оплата услуг");
                            break;
                        case 0:
                            System.out.println("Выход.");
                            return;
                        default:
                            System.out.println("Неверный выбор.");
                    }
                }

                if (accountNumber >= 6 && accountNumber <= 10) {
                    switch (choice) {
                        case 1:
                            db.SelectFromTable("premiumclient", accountNumber);
                            break;
                        case 2:
                            System.out.println("Трансфер");
                            break;

                        case 3:
                            System.out.println("оплата услуг");
                            break;
                        case 0:
                            System.out.println("Выход.");
                            return;
                        default:
                            System.out.println("Неверный выбор.");
                    }
                }

                if (accountNumber >= 11 && accountNumber <= 15) {
                    switch (choice) {
                        case 1:
                            db.SelectFromTable("vipclient", accountNumber);
                            break;
                        case 2:
                            System.out.println("Трансфер");
                            break;

                        case 3:
                            System.out.println("оплата услуг");
                            break;
                        case 0:
                            System.out.println("Выход.");
                            return;
                        default: System.out.println("Неверный выбор.");
                    }
                }
            }


        }
    }
}

