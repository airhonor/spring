package com.honorzhang.kafka.Producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Console;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zgr
 * @date ：Created in 2019/4/22
 */
public class kafkaProducer {
    public static void main(String[] args) throws InterruptedException {

        Properties props = new Properties();
        // Kafka服务端的主机名和端口号
        props.put("bootstrap.servers", "10.0.4.121:9092");
        // 等待所有副本节点的应答
        props.put("acks", "all");
        // 消息发送最大尝试次数
        props.put("retries", 0);
        // 一批消息处理大小
        props.put("batch.size", 16384);
        // 增加服务端请求延时
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 自定义分区
        props.put("partitioner.class", "com.honorzhang.kafka.Producer.ProducerPartitioner");

        Producer<String, String> producer = new KafkaProducer<>(props);

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("please enter:");
            producer.send(new ProducerRecord<>("testDemo", "#######"));
            TimeUnit.SECONDS.sleep(10);

        }


    }
}
