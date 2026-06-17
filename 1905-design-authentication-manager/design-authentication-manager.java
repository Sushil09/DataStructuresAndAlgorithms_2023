class AuthenticationManager {
    private Map<String,Integer> tokenMap;
    private int ttl;
    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        tokenMap = new ConcurrentHashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId,currentTime+this.ttl);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId)){
            if(tokenMap.get(tokenId)>currentTime){
                generate(tokenId,currentTime);
            }
        }
        return;
    }
    
    public int countUnexpiredTokens(int currentTime) {
        runCron(currentTime);
        return tokenMap.size();
    }

    private void runCron(int currentTime) {
        for(Map.Entry<String,Integer> entry: tokenMap.entrySet()) {
            if(entry.getValue()<=currentTime){
                tokenMap.remove(entry.getKey());
            }
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */