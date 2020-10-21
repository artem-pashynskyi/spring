import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        //BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        //One way to call it
        //Mentor mentor = (Mentor)container.getBean("fullTimeMentor");
        Mentor mentor = container.getBean("fullTimeMentor", Mentor.class);
        mentor.createAccount();

        //Another way to create and call
        container.getBean("partTimeMentor", Mentor.class).createAccount();
    }
}
