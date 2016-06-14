import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-config.xml");

        DirectChannel randomGenInChannel = context.getBean("randomGenInChannel", DirectChannel.class);
        DirectChannel stringOutChannel = context.getBean("stringOutChannel", DirectChannel.class);

        stringOutChannel.subscribe(message -> {
            System.out.println(message.getPayload());
            System.out.println(message.getHeaders());
        });
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        randomGenInChannel.send(MessageBuilder.withPayload(list).build());
    }
}
