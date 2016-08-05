import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/5/31.
 */
public class TestClent {

    @BeforeTest
    public void setup(){
      System.out.print("dasdasd ");
    }


    @Test
    public void action(){
        System.out.print("d54654asd ");
    }
    @AfterClass
    public void teardown(){
        System.out.print("dwwwas撒旦发射发放 ");
    }
}
