class RLEIterator {
    int currentIdx;
    int[] encoding;
    public RLEIterator(int[] encoding) {
        currentIdx=0;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while(currentIdx< encoding.length) {
            if(n<=encoding[currentIdx]){
                encoding[currentIdx]-=n;
                return encoding[currentIdx+1];
            }else{
                n-=encoding[currentIdx];
                currentIdx+=2;
            }
        }
        return -1;
    }
}
/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */