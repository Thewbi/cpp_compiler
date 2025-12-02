




 int main ( )
 {
     

     
     
     
     
     
     

      int temp_array [ 3 ] = { 1 , 2 , 3 } ;

      for ( int i = 0 ; i < 4 ; i ++ )
      {
          for ( int j = 0 ; j < 4 ; j ++ )
          {
              int temp = 4 * i + j ;

              printf ( "Matrix %d\n" , temp ) ;
          }
      }

      exit ( ) ;
      return 0 ;
 }