


 int main ( )
 {
      printf ( "Matrix\n" ) ;

      int matrixA [ 16 ] = {
          9 , 0 , 9 , 4 ,
          2 , 6 , 6 , 7 ,
          9 , 3 , 8 , 1 ,
          6 , 9 , 7 , 1 } ;

      for ( int i = 0 ; i < 4 ; i ++ )
      {
          for ( int j = 0 ; j < 4 ; j ++ )
          {
             

              int temp = 4 * i + j ;
             

              int val = matrixA [ temp ] ;
              printf ( "%d" , val ) ;
             
             
          }
         

         
      }

     

      return 0 ;
 }