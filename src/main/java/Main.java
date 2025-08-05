import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.com
 * --------------------------------------------
 * Created: 8/5/2025 11:20 AM
 * Project: orm-start
 * --------------------------------------------
 **/

public class Main {
    public static void main(String[] args) {
        // get all -
        // research how get all customer
        Session session = FactoryConfiguration.getInstance().getSession();

        // HQL
        // JPQL
        List<Customer> customers =
                session.createQuery("FROM Customer", Customer.class)
                        .list();
        customers.forEach(System.out::println);
    }

    private void deleteCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 5);
        if (customer != null) {
//            session.delete(customer);
            session.remove(customer);

            transaction.commit();
        }
    }

    private static void updateCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 5);
        if (customer != null) {
            customer.setName("hello");

            session.merge(customer);
//            session.update(customer);
//            session.save(customer);
        }
        transaction.commit();
    }

    private void getCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();

        Customer customer = session.get(Customer.class, 5);
//        Customer customer = session.load(Customer.class, 5);
//        Customer customer = session.find(Customer.class, 5);
        System.out.println(customer.toString());
    }

    private void saveCustomer() {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            Customer customer = new Customer(2, "shamodha");
            session.persist(customer);
//            session.save(customer);

            transaction.commit();
        } catch (Exception e) {

        }
    }
}
