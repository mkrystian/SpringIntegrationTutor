import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;

public class Tutor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-config.xml");

        DirectChannel randomGenInChannel = context.getBean("randomGenInChannel", DirectChannel.class);
        DirectChannel stringOutChannel = context.getBean("stringOutChannel", DirectChannel.class);

        stringOutChannel.subscribe(message -> System.out.println(message.getPayload()));
        randomGenInChannel.send(MessageBuilder.withPayload("").build());
    }
}
