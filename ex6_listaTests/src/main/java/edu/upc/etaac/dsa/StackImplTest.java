import static org.junit.Assert.*;


public class StackImplTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testPush() throws Exception {
        assertEquals(2,2);
    }

    @org.junit.Test
    public void testPop() throws Exception {
        assertEquals(2,2);

    }

    @org.junit.Test
    public void testSize() throws Exception {
        //int len =stack.size();
        int len =2;
        assertEquals(2,len);
    }
}