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
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int i = p * p;
                while (i <= n) {
                    isPrime[i] = false;
                    i += p; 
                }
            }
            p++;
        }
        System.out.println("Prime numbers up to " + n + ":");
        int count = 0;
        for (int i = 2; i <= n; i++) { 
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }
        double percentage = (double)count * 100 / n; 
        
        System.out.println("There are " + count + " primes between 2 and " + n + 
                           " (" + Math.round(percentage) + "% are primes)");
    }
}