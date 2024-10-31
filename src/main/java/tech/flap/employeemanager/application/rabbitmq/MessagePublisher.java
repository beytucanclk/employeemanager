package tech.flap.employeemanager.application.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import tech.flap.employeemanager.configuration.ConfigureRabbitMq;
import tech.flap.employeemanager.domain.model.CreatedEvent;

@Service
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceMessage(CreatedEvent msg) {
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME, "employee.messages",
                msg);

    }
}
