






















































 void standardMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {
      printf ( "test" ) ;
     
      for ( int i = 0 ; i < rows ; i ++ ) {
         
          for ( int j = 0 ; j < columns ; j ++ ) {
             
              for ( int k = 0 ; k < columns ; k ++ ) {

                 
                  int aIdx = i * columns + k ;
                  int bIdx = k * columns + j ;
                  int cIdx = i * rows + j ;

                  int aVal = matrixA [ aIdx ] ;
                  int bVal = matrixB [ bIdx ] ;

                  int temp = aVal * bVal ;

                 
                 
                 

                  printf ( "aVal: %d" , aVal ) ;
                  printf ( "bVal: %d" , bVal ) ;

                 
                 

                  matrixC [ cIdx ] = temp ;
              }
          }
      }
 }










 void prettyPrintFormatMatrix ( int * matrix , int dim ) {
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {
              int idx = dim * i + j ;
              int temp = matrix [ idx ] ;
              printf ( "%d" , temp ) ;
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
          6 , 9 , 7 , 1
      } ;
      int matrixB [ 16 ] = {
          1 , 2 , 4 , 2 ,
          8 , 6 , 0 , 0 ,
          7 , 6 , 8 , 5 ,
          8 , 4 , 7 , 5
      } ;
      int matrixC [ 16 ] = {
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0
      } ;

     
     
     
     
     

     
     

      standardMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;
     

      printf ( "C\n" ) ;
      prettyPrintFormatMatrix ( matrixC , 4 ) ;

     
     
     
     
     
     
     

     
     
     
     
     
     
     
     
      return 0 ;
 }