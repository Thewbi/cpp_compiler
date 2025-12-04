





 int prettyPrintFormatMatrix ( int * matrix , int dim ) {

      int count = 1 ;

      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {
             
             
              int idx_temp = dim * i ;
              int idx = idx_temp + j ;

              int temp = matrix [ idx ] ;

              printf ( "%d\n" , temp ) ;

             
          }
      }

     
     
     

      return 0 ;
 }


 int upCountingMatrix ( int * matrix , int dim ) {

      int count = 1 ;
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {

             

             
              int temp = dim * i ;
              int idx = temp + j ;
              matrix [ idx ] = count ;

             
              int jj = count ;
              count = jj + 1 ;
          }
      }
      return 0 ;
 }


 int main ( )
 {
     

     
     

      int matrixA [ 16 ] = {
          9 , 0 , 9 , 4 ,
          2 , 6 , 6 , 7 ,
          9 , 3 , 8 , 1 ,
          6 , 9 , 7 , 1 } ;

      int result1 = upCountingMatrix ( matrixA , 4 ) ;
      int result2 = prettyPrintFormatMatrix ( matrixA , 4 ) ;

     

      exit ( ) ;
      return 0 ;
 }