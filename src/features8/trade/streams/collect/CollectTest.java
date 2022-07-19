/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package features8.trade.streams.collect;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import features8.trade.Trade;
import features8.trade.util.TradeUtil;

/**
 *
 * @author mkonda
 */
public class CollectTest {
    List<Trade> trades = TradeUtil.createTrades();

    private void collectQuantitiesToList() {
        List<Integer> list = trades.stream()
                .map(t->t.getQuantity())
                .collect(toList());
        System.out.println("Collect List: "+list);
    }
    
    private void group() {
        Map<String, List<Trade>> issuers = trades.stream()
                .collect(groupingBy(t->t.getIssuer()));
        
        System.out.println("Grouped List: "+issuers);
    }
    
    public static void main(String[] args) {
        CollectTest test = new CollectTest();
        test.collectQuantitiesToList();
        test.group();
    }
}
