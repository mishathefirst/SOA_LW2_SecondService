package com.example.SimpleJAXRS.cruds;

import com.example.SimpleJAXRS.entities.Organization;
import com.example.SimpleJAXRS.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class OrganizationCRUD {

        public void save(Organization organization) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            session.save(organization);
            session.flush();
            session.close();
        }

        public void delete(Organization organization) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            session.delete(organization);
            session.flush();
            session.close();
        }

        public List<Organization> getAll() {
            Session session = HibernateUtil.getSessionFactory().openSession();

            return session.createCriteria(Organization.class).list();
        }

        public Organization getById (Long id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //System.out.println(Organization.class.getClassLoader());
            Organization organization = session.get(Organization.class, id);
            //session.flush();
            //session.close();
            return organization;
        }

        public void update(Organization organization) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            session.update(organization);
            session.flush();
            session.close();
        }

}
