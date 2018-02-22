//package com.gmail.rgizmalkov.edu.dissertation.context;
//
//
//import com.gmail.rgizmalkov.edu.dissertation.receiver.Receiver;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class KafkaContext {
//
//    @Configuration
//    public static class KafkaProducerConfig{
//        @Bean
//        public ProducerFactory<String, String> producerFactory() {
//            Map<String, Object> configProps = new HashMap<>();
//            configProps.put(
//                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                    "localhost:9092");
//            configProps.put(
//                    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                    StringSerializer.class);
//            configProps.put(
//                    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                    StringSerializer.class);
//            return new DefaultKafkaProducerFactory<>(configProps);
//        }
//
//        @Bean
//        public KafkaTemplate<String, String> kafkaTemplate() {
//            return new KafkaTemplate<String, String>(producerFactory());
//        }
//    }
//
//    @EnableKafka
//    @Configuration
//    public static class KafkaConsumerConfig{
//        @Bean
//        public ConsumerFactory<String, String> consumerFactory() {
//            Map<String, Object> props = new HashMap<>();
//            props.put(
//                    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                    "localhost:9092");
//            props.put(
//                    ConsumerConfig.GROUP_ID_CONFIG,
//                    "first");
//            props.put(
//                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                    StringDeserializer.class);
//            props.put(
//                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                    StringDeserializer.class);
//            // automatically reset the offset to the earliest offset
//            props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");
//            return new DefaultKafkaConsumerFactory<>(props);
//        }
//
//        @Bean
//        public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//            ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//            factory.setConsumerFactory(consumerFactory());
//            return factory;
//        }
//
//        @Bean
//        public Receiver receiver1(){
//            return new Receiver("first");
//        }
//
//
//        @Bean
//        public Receiver receiver2(){
//            return new Receiver("second");
//        }
//
////        @Bean
////        public Receiver receiver3(){
////            return new Receiver("third");
////        }
////
////        @Bean
////        public Receiver receiver4(){
////            return new Receiver("fourth");
////        }
//    }
//
//
//}
