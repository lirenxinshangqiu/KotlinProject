package test;

import com.example.main.thread.TicketRunnable;

/**
 * Created by ls on 18/7/9.
 */
public class TicketRunnableTest {
    public static void main(String[]args){
        TicketRunnable ticketRunnable = new TicketRunnable();
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
    }
}
