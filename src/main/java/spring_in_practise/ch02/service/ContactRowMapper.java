package spring_in_practise.ch02.service;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import spring_in_practise.ch02.model.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ContactRowMapper implements RowMapper<Contact> {
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(rs.getLong(1));
        contact.setLastName(rs.getString(2));
        contact.setFirstName(rs.getString(3));
        contact.setMiddleInitial(rs.getString(4));
        contact.setEmail(rs.getString(5));
        return contact;
    }
}
