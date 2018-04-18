package spring_in_practise.ch02.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_in_practise.ch02.dao.ContactDao;
import spring_in_practise.ch02.model.Contact;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Component
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NEVER, rollbackFor = RuntimeException.class, rollbackForClassName = "cccc")
public class ContactServiceImpl implements ContactService {
    private static final String CREATE_SQL = "insert into contact (last_name,first_name,mi,email) " + "values (:lastName,:firstName,:mi,:email)";
    private static final String FIND_ALL_SQL = "select id, last_name, first_name, mi, email from contact";
    private static final String FIND_ALL_BY_EMAIL_LIKE_SQL = "select id, last_name, first_name, mi, email from contact " + "where email like :email";
    private static final String FIND_ONE_SQL = "select id, last_name, first_name, mi, email from contact " + "where id = :id";
    private static final String UPDATE_SQL = "update contact set last_name = :lastName, " + "first_name = :firstName, mi = :mi, email = :email " + "where id = :id";
    private static final String DELETE_SQL = "delete from contact where id = :id";

    @Inject
    //private NamedParameterJdbcOperations jdbcOperations;
    //change the jdbcOperation to hibernate's session api
    private SessionFactory sessionFactory;
    //refactor the hibernate's session api
    @Inject
    private ContactDao contactDao;

    @Inject
    private ContactRowMapper mapper;

    public void createContact(Contact contact) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("lastName", contact.getLastName()).addValue("firstName", contact.getFirstName()).addValue("mi", contact.getMiddleInitial()).addValue("email", contact.getEmail());
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcOperations.update(CREATE_SQL, parameterSource, keyHolder);
//        contact.setId(keyHolder.getKey().longValue());
//        getSession().save(contact);
        contactDao.create(contact);
    }


    public List<Contact> getContacts() {
//        return jdbcOperations.query(FIND_ALL_SQL, new HashMap<String, Object>(), mapper);
//        return getSession().createQuery("from contact").list();
        return contactDao.getAll();
    }

    public List<Contact> getContactsByEmail(String email) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("email", "%" + email + "%");
//        return jdbcOperations.query(FIND_ALL_BY_EMAIL_LIKE_SQL, parameterSource, mapper);
//        return getSession().getNamedQuery("findContactsByEmail").setParameter("email", "%" + email + "%").list();
        return contactDao.findByEmail(email);
    }

    public Contact getContact(Long id) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
//        return jdbcOperations.queryForObject(FIND_ONE_SQL, parameterSource, mapper);
//        System.out.println(Contact.class);
//        return getSession().get(Contact.class, id);
        return contactDao.get(id);
    }

    public void updateContact(Contact contact) {
//        SqlParameterSource params = new MapSqlParameterSource()
//                .addValue("id", contact.getId())
//                .addValue("lastName", contact.getLastName())
//                .addValue("firstName", contact.getFirstName())
//                .addValue("mi", contact.getMiddleInitial())
//                .addValue("email", contact.getEmail());
//        jdbcOperations.update(UPDATE_SQL, params);
//        getSession().update(contact);
        contactDao.update(contact);
    }

    public void deleteContact(Long id) {
//        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
//        jdbcOperations.update(DELETE_SQL, parameterSource);
//        getSession().delete(id);
        contactDao.delete(id);
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
