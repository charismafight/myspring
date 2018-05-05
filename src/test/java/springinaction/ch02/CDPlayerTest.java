package springinaction.ch02;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Rule
    public final StandardOutputStreamLog logger = new StandardOutputStreamLog();


    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(cd);
    }

    @Test
    public void play() {
        cdPlayer.play();
        Assert.assertEquals("playing SgtPepper\n", logger.getLog());
    }

}
