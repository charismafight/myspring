package springinaction.ch15;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * RMIService Tester.
 *
 * @author lli
 * @version 1.0
 * @since <pre>Jun 19, 2018</pre>
 */
public class RMIServiceTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: rmiServiceExporter(SpitterService service)
     */
    @Test
    public void testRmiServiceExporter() throws Exception {

        try {
            //传统做法
            String url = "rmi:/spitter/SpitterService";
            SpitterService spitterService = (SpitterService)Naming.lookup("url");
            //xxxxxx
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
} 
