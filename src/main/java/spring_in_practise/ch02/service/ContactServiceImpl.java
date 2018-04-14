package spring_in_practise.ch02.service;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import spring_in_practise.ch02.model.Contact;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private static final String CREATE_SQL = "insert into contact (last_name,first_name,mi,email) " + "values (:lastName,:firstName,:mi,:email)";
    private static final String FIND_ALL_SQL = "select id, last_name, first_name, mi, email from contact";
    private static final String FIND_ALL_BY_EMAIL_LIKE_SQL = "select id, last_name, first_name, mi, email from contact " + "where email like :email";
    private static final String FIND_ONE_SQL = "select id, last_name, first_name, mi, email from contact " + "where id = :id";
    private static final String UPDATE_SQL = "update contact set last_name = :lastName, " + "first_name = :firstName, mi = :mi, email = :email " + "where id = :id";
    private static final String DELETE_SQL = "delete from contact where id = :id";

    @Inject
    private NamedParameterJdbcOperations jdbcOperations;
    @Inject
    private ContactRowMapper mapper;

    public void createContact(Contact contact) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("lastName", contact.getLastName()).addValue("firstName", contact.getFirstName()).addValue("mi", contact.getMiddleInitial()).addValue("email", contact.getEmail());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(CREATE_SQL, parameterSource, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
    }

    public List<Contact> getContacts() {
        return jdbcOperations.query(FIND_ALL_SQL, new HashMap<String, Object>(), mapper);
    }

    public List<Contact> getContactsByEmail(String email) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("email", "%" + email + "%");
        return jdbcOperations.query(FIND_ALL_BY_EMAIL_LIKE_SQL, parameterSource, mapper);
    }

    public Contact getContact(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        return jdbcOperations.queryForObject(FIND_ONE_SQL, parameterSource, mapper);
    }

    public void updateContact(Contact contact) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", contact.getId())
                .addValue("lastName", contact.getLastName())
                .addValue("firstName", contact.getFirstName())
                .addValue("mi", contact.getMiddleInitial())
                .addValue("email", contact.getEmail());
        jdbcOperations.update(UPDATE_SQL, params);
    }

    public void deleteContact(Long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        jdbcOperations.update(DELETE_SQL, parameterSource);
    }
}
