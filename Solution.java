import java.util.*;

public class Solution implements SolutionInterface {
    private final int buyDay;
    private final int sellDay;
    Map<Integer, Integer> dayPriceMap = new HashMap<>();
    //represents API.getNumberOfDays
    int numberOfDays=9;

    public Solution() {
        // You can initiate and calculate things here
        // initializes the first input test-data
        dayPriceMap.put(1,7);
        dayPriceMap.put(2,12);
        dayPriceMap.put(3,5);
        dayPriceMap.put(4,3);
        dayPriceMap.put(5,11);
        dayPriceMap.put(6,6);
        dayPriceMap.put(7,10);
        dayPriceMap.put(8,2);
        dayPriceMap.put(9,9);

        BuySellDay buySellDayEntry = getBuySellDayWithHighestProfit();

        this.buyDay = buySellDayEntry.getBuyDay();
        this.sellDay = buySellDayEntry.getSellDay();
    }

    private BuySellDay getBuySellDayWithHighestProfit() {
        Map<BuySellDay, Integer> buySellPriceDifference = new HashMap<>();

        for (int i=1; i<=numberOfDays; i++){
            for (int j=i+1 ; j<=numberOfDays; j++)
                buySellPriceDifference.put(new BuySellDay(i,j), dayPriceMap.get(j)- dayPriceMap.get(i));
        }

        return buySellPriceDifference.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)
                ).get().getKey();
    }

    /**
     * Return the buyDay which you buy gold. The first buyDay has number zero. This method is
     * called first, and only once.
     */
    public int getBuyDay() {
        // Write your code here
        return buyDay;
    }

    /**
     * Return the buyDay to sell gold on. This buyDay has to be after (greater than) the buy
     * buyDay. The first buyDay has number zero (although this is not a valid sell buyDay). This
     * method is called second, and only once.
     */
    public int getSellDay() {
        // Write your code here
        return sellDay;
    }

    class BuySellDay {
        int buyDay;
        int sellDay;
        BuySellDay(int buyDay, int sellDay){
            this.buyDay = buyDay;
            this.sellDay = sellDay;
        }
        int getBuyDay(){
            return buyDay;
        }

        int getSellDay(){
            return sellDay;
        }
    }
}