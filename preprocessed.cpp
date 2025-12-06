



 int factorial ( int n ) {

     

     
      if ( n == 1 )
      {
          return 1 ;
      }

     
     

     
      int temp = n - 1 ;
      int factorial_result = factorial ( temp ) ;
      int result = n * factorial_result ;

     

      return result ;
 }

 int main ( ) {

     

      int num = 5 ;
      int factorial_result = factorial ( num ) ;

      printf ( "factorial of %d is %d\n" , num , factorial_result ) ;

      exit ( ) ;
      return 0 ;
 }