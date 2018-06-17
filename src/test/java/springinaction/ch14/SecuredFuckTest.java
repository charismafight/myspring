package springinaction.ch14;

import org.hibernate.annotations.common.AssertionFailure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * SecuredFuck Tester.
 *
 * @author <lli>
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

    @Test(expected = AccessDeniedException.class)
    public void test_no_right_exception() {
        setUser("gogogo");
        fuckService.fuck();
    }

    @Test
    public void test_has_right(){
        setUser("ROLE_FUCK");
        fuckService.fuck();
        assert true;
    }

    private void setUser(@NotNull String... roles) {
        SecurityContext context = SecurityContextHolder.getContext();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String auth :
                roles) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken("user", "password", authorities);
        context.setAuthentication(authentication);
    }
} 
