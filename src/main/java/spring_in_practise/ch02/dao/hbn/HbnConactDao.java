package spring_in_practise.ch02.dao.hbn;

import org.springframework.stereotype.Repository;
import spring_in_practise.ch02.dao.ContactDao;
import spring_in_practise.ch02.dao.hibernate.AbstractHbnDao;
import spring_in_practise.ch02.model.Contact;

import java.util.List;

@Repository
public class HbnConactDao extends AbstractHbnDao<Contact> implements ContactDao {

    @Override
    public List<Contact> findByEmail(String email) {
        return getSession().getNamedQuery("findContactsByEmail").setParameter("email", '%' + email + '%').list();
    }
}
