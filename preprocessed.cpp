







 int prettyPrintFormatMatrix ( int * matrix , int dim ) {

      int count = 1 ;

      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {

             
              int idx_temp = dim * i ;
              int idx = idx_temp + j ;

              int temp = matrix [ idx ] ;

              putint ( temp ) ;
          }
      }

      return 0 ;
 }



 int standardMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {

     

      int counter = 0 ;

     
      for ( int i = 0 ; i < rows ; i ++ ) {

         
          for ( int j = 0 ; j < columns ; j ++ ) {

             
              for ( int k = 0 ; k < columns ; k ++ ) {

                 
                  int temp_aIdx = i * columns ;
                  int aIdx = temp_aIdx + k ;

                 
                  int temp_bIdx = k * columns ;
                  int bIdx = temp_bIdx + j ;

                 
                  int temp_cIdx = i * rows ;
                  int cIdx = temp_cIdx + j ;

                  int aVal = matrixA [ aIdx ] ;
                  int bVal = matrixB [ bIdx ] ;

                  int mult_temp = aVal * bVal ;

                  int abc = matrixC [ cIdx ] ;
                  int cde = abc + mult_temp ;
                  matrixC [ cIdx ] = cde ;

              }

          }

      }

      return 0 ;
 }


 int main ( )
 {
     

     
     
     
     
     
     
     

     
     
      int matrixA [ 16 ] = {
          1 , 2 , 3 , 4 ,
          5 , 6 , 7 , 8 ,
          9 , 10 , 11 , 12 ,
          13 , 14 , 15 , 16
      } ;


     
     
     
     
     
     

     
     
     
     
     
     
     
     
     
     
     
     
     
     
      int matrixC [ 16 ] = {
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0
      } ;


     
     
     
     
     
     
     

     
     
      int matrixB [ 16 ] = {
          1 , 2 , 3 , 4 ,
          5 , 6 , 7 , 8 ,
          9 , 10 , 11 , 12 ,
          13 , 14 , 15 , 16
      } ;


     
     
     
     
     
     
     

     
     

     

      int a22 = standardMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;

     

      int resultPrettyPrintC = prettyPrintFormatMatrix ( matrixC , 4 ) ;
     
     

      exit ( ) ;
      return 0 ;
 }