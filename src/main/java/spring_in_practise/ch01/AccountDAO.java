package spring_in_practise.ch01;

import java.util.List;

public interface AccountDAO {
    List<Account> findAll() throws Exception;
}
