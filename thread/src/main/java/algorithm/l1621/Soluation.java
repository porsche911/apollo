package algorithm.l1621;

public class Soluation {
    private Long constModle = 1000000007L;
    public int numberOfSets(int n, int k){
        if (n==k+1){
            return 1;
        }
        if (n<k){
            return 0;
        }
        if (k==1){
            return n*(n-1)/2;
        }
        //int sum=0;
        long resultNum = 0;
        for (int i=1;i<=n-k;i++){
            resultNum = resultNum+ 1l*i*numberOfSets(n-i,k-1);
        }
        return (int) (resultNum%constModle);
    }
    /*int mod = 1000000007;
    int[][] dp = null;
    public int numberOfSets(int n, int k) {
        dp = new int[n+1][k+1];
        return find(n,k);
    }
    public int find(int n, int k) {
        if(dp[n][k]==0){
            if(n==k+1) return 1;
            if(k==1) return (n*n-n)/2;
            long ans = 0;
            for(int j=1;j<=n-k;j++){
                ans+=1l*j*find(n-j,k-1);
                ans = ans%mod;
            }
            dp[n][k]=(int)ans;
        }
        return dp[n][k];
    }*/
}
