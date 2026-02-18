class Solution {
    public boolean isPalindrome(int x) {
        int originalNumber = x;
        if(x==0)
            return true;
        if(originalNumber%10==0)
            return false;
        int formedNumber = 0;
        while (originalNumber >0) {

            int remainder = originalNumber%10;
            originalNumber = originalNumber/10;
            formedNumber = formedNumber*10+remainder;
            if(formedNumber == originalNumber)
                return true;
        }

        return formedNumber == x;
    }
}