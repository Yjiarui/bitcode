 public class Practice{
   public static  long factorial1(long n){
   if(n==0||n==1){
   return 1;
   }
   return factorial1(n-1)*n;
   }
   public static  long factorial2(long n){
   long fact2=1;
   for(int i=1;i<=n;i++){
     fact2=fact2*n;
	 }
	 return fact2;
	}
   public static void main(String[] args){
                long n=12;
	long fact1=factorial1(n);
	System.out.printf("%d%n",fact1);
	long fact2=factorial2(n);
	System.out.printf("%d%n",fact2);
 }
}