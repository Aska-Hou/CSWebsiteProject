import domain.Manager;
import org.junit.Test;

public class Demo {

    @Test
    public void test1(){
        String string = "123";
        changeName(string);
        System.out.println(string);
    }

    public void changeName(String string){
        String string1 = "456";
        string = string1;
    }

    public void change(String string){
        string = "456";
    }

}
