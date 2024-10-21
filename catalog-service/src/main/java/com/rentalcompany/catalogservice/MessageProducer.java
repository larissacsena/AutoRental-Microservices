package com.rentalcompany.catalogservice;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final AmazonSQSAsync amazonSQSAsync;
    private final String queueUrl = "http://localhost:4566/000000000000/catalog-queue";

    public MessageProducer(AmazonSQSAsync amazonSQSAsync) {
        this.amazonSQSAsync = amazonSQSAsync;
    }

    public void sendMessage(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, message);
        amazonSQSAsync.sendMessage(sendMessageRequest);
    }
}
