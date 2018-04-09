package spring_in_practise;

import java.util.List;

public interface AccountDAO {
    List<Account> findAll() throws Exception;
}
