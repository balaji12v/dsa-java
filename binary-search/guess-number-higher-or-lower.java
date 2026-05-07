//brute force approach is to use linear search where in the worst case the t.c is O(n) where we checking till the last element since the guess number be the n
//since there is a pattern where we can say that if the current number is less than guess than -1 and something ,we can understand we will use binary search here 

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l=0;
        int r=n;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(guess(mid) ==0){
                return mid;
            }
            else if(guess(mid) == -1){
                r = mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return 1;
    }
}
