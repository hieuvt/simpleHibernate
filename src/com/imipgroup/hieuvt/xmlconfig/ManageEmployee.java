package com.imipgroup.hieuvt.xmlconfig;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hieuvt on 10/1/2014.
 */
public class ManageEmployee {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public int addEmployee(Employee employee){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback(); e.printStackTrace();
        }finally {
            session.close();
        }
        return employee.getId();
    }

    public void listEmployees( ){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getName());
                }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void updateEmployee(Integer EmployeeID, String newName ){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setName(newName);
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteEmployee(Integer EmployeeID) {
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        ManageEmployee manageEmployee = new ManageEmployee();
//        Employee e1 = new Employee("Hieu");
//        manageEmployee.addEmployee(e1);
//        manageEmployee.listEmployees();
//        manageEmployee.updateEmployee(1,"Minh");
//        manageEmployee.deleteEmployee(1);

        HashSet<Certificate> set1 = new HashSet();
        set1.add(new Certificate("MCA"));
        set1.add(new Certificate("MBA"));
        set1.add(new Certificate("PMP"));

        Employee e1 = new Employee("Hieu",set1);

        manageEmployee.addEmployee(e1);
    }
}
