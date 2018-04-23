package spring_in_practise.ch02.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_in_practise.ch02.model.Contact;

import java.util.List;

public interface JpaContactDao extends JpaRepository<Contact, Long> {
    List<Contact> findByEmailLike(String email);
}
