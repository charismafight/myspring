package springinaction.ch14;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SecuredFuck Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 16, 2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SecuredMethodConfig.class)
public class SecuredFuckTest {

    @Autowired
    FuckService fuckService;

    @Before
    public void before() throws Exception {
        SecurityContextHolder.clearContext();
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: fuck()
     */
    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void test_no_auth_exception() {
        fuckService.fuck();
    }


} 
