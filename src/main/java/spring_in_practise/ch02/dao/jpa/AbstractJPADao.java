package spring_in_practise.ch02.dao.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring_in_practise.ch02.dao.ContactDao;
import spring_in_practise.ch02.model.Contact;
import spring_in_practise.dao.Dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public class AbstractJPADao implements ContactDao {
    @PersistenceContext(name = "jpaFactory")
    private EntityManager entityManager;

    @Override
    public List<Contact> findByEmail(String email) {
        return null;
    }

    @Override
    public void create(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public Contact get(Serializable id) {
        return entityManager.find(Contact.class, id);
    }

    @Override
    public Contact load(Serializable id) {
        return null;
    }

    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Serializable id) {
        return false;
    }
}
