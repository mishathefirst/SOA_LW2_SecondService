package com.example.SimpleJAXRS.cruds;

import com.example.SimpleJAXRS.entities.Employee;
import com.example.SimpleJAXRS.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class EmployeeCRUD {

    public void save(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(employee);
        session.flush();
        session.close();
    }

    public void delete(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.delete(employee);
        session.flush();
        session.close();
    }

    public List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createCriteria(Employee.class).list();
    }

    public Employee getById (int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //System.out.println(Organization.class.getClassLoader());
        Employee employee = session.get(Employee.class, id);
        //session.flush();
        //session.close();
        return employee;
    }

    public void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.update(employee);
        session.flush();
        session.close();
    }

}
