package test;

import Dao.CustomerDao;
import Model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class CinemaTest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static CustomerDao customerDao = new CustomerDao();
    public static void customerAction(){
        System.out.println("Choose an action:");
        System.out.println("1: Find customer by ID");
        System.out.println("2: Get All customers");
        System.out.println("3: Create a new customer");
        System.out.println("4: Delete a customer");
        System.out.println("5: Exit");
    }
    public static void main(String[] args)throws Exception {
        boolean exit = true;
        do {
            customerAction();
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    findCustomer();
                    break;
                case 2:
                    getAllCustomer();
                    break;
                case 3:
                    registerCustomer();
                    break;
                case 4:
                    destoryCustomer();
                    break;
                case 5:
                    exit = false;
                    System.out.println("Exiting the application..");
                    break;
            }
        } while (exit);
    }
    private static void destoryCustomer() throws IOException, SQLException {
        System.out.println("Enter Customer ID:");
        int id = Integer.parseInt(br.readLine());
        Customer customer = new Customer();
        customer.setId(id);
        customerDao.delete(customer);
    }
    private static void registerCustomer() throws IOException, SQLException {
        System.out.println("Enter customer name:");
        String name = br.readLine();
        Customer customer = new Customer();
        customer.setName(name);
        customerDao.create(customer);
    }

    private static void getAllCustomer() throws SQLException {
        System.out.println("***get all customers***");
        List<Customer> customers = customerDao.getAll();
        for(Customer c:customers) {
            System.out.println(c);
        }
    }

    public static void findCustomer() throws IOException , SQLException ,NumberFormatException{
        System.out.println("Enter Customer ID:");
        int id = Integer.parseInt(br.readLine());
        Customer customer = customerDao.findById(id);
        System.out.println(customer);
    }
}
