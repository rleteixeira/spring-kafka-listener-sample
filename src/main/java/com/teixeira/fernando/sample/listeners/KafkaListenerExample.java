package com.teixeira.fernando.sample.listeners;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListenerExample {
	
  private final Log log = LogFactory.getLog(this.getClass());
  @KafkaListener(topics = "topic-example", errorHandler = "customErrorHandler")
  public void execute(final GenericMessage<String> message) {
        log.info(
	            "Reading offset:"+ message.getHeaders().get("kafka_offset") + 
	            " and message received: " + message.getPayload());
    
    //throw new RuntimeException("Ops");
  }  
}
