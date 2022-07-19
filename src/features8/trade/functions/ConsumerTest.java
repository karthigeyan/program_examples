/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package features8.trade.functions;

import java.util.function.Consumer;

import features8.trade.Trade;

/**
 *
 * @author mkonda
 */
public class ConsumerTest {
    //double up quantity
    Consumer<Trade> consumer = x -> x.setQuantity(x.getQuantity()*2);
    
    private void testConsumer(Trade t){
        System.out.println("T's qty before :"+t.getQuantity());
        consumer.accept(t);
        System.out.println("T's qty after :"+t.getQuantity());
    }
    
    public static void main(String[] args) {
    
        Trade t = new Trade(1,"XT",1000,"NEW");
        ConsumerTest test = new ConsumerTest();
        test.testConsumer(t);
                
    }
}
