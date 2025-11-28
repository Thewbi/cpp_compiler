




 void prettyPrintFormatMatrix ( int * matrix , int dim ) {
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {
              int idx = dim * i + j ;
              int temp = matrix [ idx ] ;
              printf ( "%d" , temp ) ;
          }
      }
 }

 void upCountingMatrix ( int * matrix , int dim ) {
      int count = 22 ;
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {
              int idx = dim * i + j ;
              matrix [ idx ] = count ;
             
              count ++ ;
             
          }
      }
 }


 int main ( )
 {
      printf ( "Matrix\n" ) ;

      int matrixA [ 16 ] = {
          9 , 0 , 9 , 4 ,
          2 , 6 , 6 , 7 ,
          9 , 3 , 8 , 1 ,
          6 , 9 , 7 , 1 } ;

      upCountingMatrix ( matrixA , 4 ) ;
      prettyPrintFormatMatrix ( matrixA , 4 ) ;

      printf ( "END" ) ;

      return 0 ;
 }