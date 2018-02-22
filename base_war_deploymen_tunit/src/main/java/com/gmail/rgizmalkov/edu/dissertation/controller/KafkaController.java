//package com.gmail.rgizmalkov.edu.dissertation.controller;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.PostConstruct;
//import java.util.UUID;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@RestController
//@RequestMapping("/kafka")
//public class KafkaController {
//    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
//
//    private final KafkaTemplate<String, String> broker;
//    private final AtomicBoolean isServiceAvailable = new AtomicBoolean(true);
//
//    @PostConstruct
//    public void init(){
////        new Thread(() -> {
////            while (isServiceAvailable.get()) {
////                broker.send("test", "hello");
////            }
////        }).start();
//    }
//
//
//
//    @Autowired
//    public KafkaController(KafkaTemplate<String, String> broker) {
//        this.broker = broker;
//    }
//
//    @GetMapping("/send")
//    public @ResponseBody
//    String sed(@RequestParam(value = "topic", required = true) String topic, @RequestParam(value = "msg", required = true) String msg) throws ExecutionException, InterruptedException {
//        ListenableFuture<SendResult<String, String>> send = broker.send(topic, UUID.randomUUID().toString());
//        return send.get().getProducerRecord().toString();
//    }
//
//    @GetMapping("/switch")
//    public @ResponseBody
//    String switcher() {
//        boolean sign = isServiceAvailable.get();
//        if (sign) {
//            isServiceAvailable.set(false);
//        } else {
//            isServiceAvailable.set(true);
//        }
//        return "OK";
//    }
//
//}
