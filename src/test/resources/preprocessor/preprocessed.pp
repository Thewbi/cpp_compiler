

 int func_assign ( int * numbers )
 {
     

     
     

      numbers [ 0 ] = 255 ;

      return 0 ;
 }

 int main ( )
 {
      int numbers [ 3 ] = { 16 , 32 , 48 } ;

      int y = func_assign ( numbers ) ;

      int c = numbers [ 0 ] ;

      printf ( "func_assign() c = %d\n" , c ) ;

      exit ( ) ;
      return 0 ;
 }