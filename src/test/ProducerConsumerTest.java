package test;

import com.example.main.bean.PublicResource;
import com.example.main.thread.ConsumerThread;
import com.example.main.thread.ProducerThread;

/**
 * Created by ls on 18/7/9.
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        PublicResource publicResource = new PublicResource();
        new Thread(new ProducerThread(publicResource)).start();
        new Thread(new ConsumerThread(publicResource)).start();
        new Thread(new ProducerThread(publicResource)).start();
        new Thread(new ProducerThread(publicResource)).start();
        new Thread(new ConsumerThread(publicResource)).start();
        new Thread(new ProducerThread(publicResource)).start();
        new Thread(new ConsumerThread(publicResource)).start();
    }
}
