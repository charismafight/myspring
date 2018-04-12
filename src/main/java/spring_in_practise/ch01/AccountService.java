package spring_in_practise.ch01;

public class AccountService {
    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountDAO getAccountDAO() {
        return this.accountDAO;
    }
}
