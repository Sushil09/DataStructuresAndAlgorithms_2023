class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++) {
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                ten++;
                if(five<=0)
                    return false;
                five--;    
            }else{
                int remaining = bills[i]-5;
                if(ten>0){
                    remaining=remaining%10;
                    ten--;
                }
                if(five>0){
                    int needed = remaining/5;
                    if(five<needed)
                        return false;
                    else
                        five=five-needed;    
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}