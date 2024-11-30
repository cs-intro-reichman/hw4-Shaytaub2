public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean [] prime = new boolean[n+1];
        for (int i=0; i<prime.length; i++) //set all the valus True crfor the checks
        {
            prime[i] = true;
        }
        prime = primeArr(prime);
        printArr(prime);
        int count = 0;
        for (int i=0; i<prime.length; i++) //count
        {
            if (prime[i])
            {
                count++;
            }
        }
        int pre = (int) (((double) count / (double) n) * 100);
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + pre + "% are primes)");
        
    }

    //return the prime arr. assume that the lengh>2
    public static boolean [] primeArr (boolean [] arr) 
    {
        if (arr.length<2){return null;}
        arr[0] = false;
        arr[1] = false;
        for (int i=2; i<arr.length; i++)
        {
            int j = i+1;
            while (j<arr.length)
            {
                if (j%i==0 && arr[j])
                {
                    arr [j] = false;
                }
                j++;
            }
        }
        return arr;
    }
    
    //print all the position that return true
    public static void printArr (boolean [] arr) 
    {
        for (int i=2; i<arr.length; i++)
        {
            if (arr[i])
            {
                System.out.println(i);
            }
        }
    }
}