package spring_in_practise.ch02.dao;

import spring_in_practise.ch02.model.Contact;
import spring_in_practise.dao.Dao;

import java.util.List;

public interface ContactDao extends Dao<Contact> {
    List<Contact> findByEmail(String email);
}
