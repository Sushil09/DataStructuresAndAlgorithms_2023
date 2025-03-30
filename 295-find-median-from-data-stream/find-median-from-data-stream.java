class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0){
            maxHeap.add(num);
            return;
        }
        if(num<maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        int limit = maxHeap.size() - minHeap.size();    
        if(limit >=2)
            minHeap.add(maxHeap.poll());
        else if(limit<0)
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if(size%2 != 0)
            return (double)(maxHeap.peek());    
        else
            return (double)(maxHeap.peek() + minHeap.peek()) /2;     
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */