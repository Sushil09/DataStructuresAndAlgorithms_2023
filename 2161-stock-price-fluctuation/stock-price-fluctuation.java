class StockPrice {
    java.util.SortedMap<Integer,Integer> frequencyMap;
    Map<Integer,Integer> priceMap;
    int latestTimeStamp;

    public StockPrice() {
       latestTimeStamp =0;
       frequencyMap = new TreeMap<>();  
       priceMap = new HashMap<>();
    }
    
    public void update(int timestamp, int price) {
        latestTimeStamp = Math.max(timestamp,latestTimeStamp);
        if(priceMap.containsKey(timestamp)) {
            int oldValue = priceMap.get(timestamp);
            if(frequencyMap.get(oldValue) - 1 ==0)
                frequencyMap.remove(oldValue);
             else
            frequencyMap.put(oldValue,frequencyMap.getOrDefault(oldValue,0)-1);      
        }
        priceMap.put(timestamp,price);
        frequencyMap.put(price,frequencyMap.getOrDefault(price,0)+1);
    }
    
    public int current() {
        return priceMap.get(latestTimeStamp);
    }
    
    public int maximum() {
        return frequencyMap.lastKey();
    }
    
    public int minimum() {
        return frequencyMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */