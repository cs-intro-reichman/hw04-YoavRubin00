public class Primes {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Please provide an integer n.");
            return;
        }
        String x = args[0];
        int n = Integer.parseInt(x);
        if (n <= 1) {
            System.out.println("Prime numbers up to " + n + ":\nThere are 0 primes.");
            return;
        }
        boolean[] isPrime = new boolean[n + 1];
        //אתחול כל הערכים להיות במערך
        for(int i = 0;i<isPrime.length;i++){
            if(isPrime(i)){
                isPrime[i]=true;
            }else{
                isPrime[i]=false;
            }
        }
        int count = 0;
                for(int i = 2;i<isPrime.length;i++){
            if(isPrime(i)){
            System.out.println(i);
            count ++;
        }
    }
    System.out.println("There are " + count + " primes between 2 and "+ n +" "+(double)(count*100/(n-1))+"% are primes");
    }
  public static boolean isPrime(int x) {
    if(x==1)
        return false;
    for(int i=2;i<x;i++){
        if (x%i==0) {
            return false;
        }
    }
    return true;
}
}