































 void getSubMatrix ( int * matrix , int dim , int xPos , int yPos , int width , int height , int * matrixC ) {



     
     
     
     

      int xEnd = xPos + width ;
      int yEnd = yPos + height ;

      int innerI = 0 ;
      for ( int i = xPos ; i < xEnd ; i ++ ) {

          int innerJ = 0 ;
          for ( int j = yPos ; j < yEnd ; j ++ ) {

             
              int idx = i * dim + j ;
              int idxC = innerI * width + innerJ ;
             
              int gaga = matrix [ idx ] ;
              matrixC [ idxC ] = gaga ;

             
              int t = innerJ + 1 ;
              innerJ = t ;
             
             

          }

         
          int u = innerI + 1 ;
          innerI = u ;
      }
 }













 void standardMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {
      printf ( "standardMatrixMult()" ) ;
     
      for ( int i = 0 ; i < rows ; i ++ ) {
         
          for ( int j = 0 ; j < columns ; j ++ ) {
             
              for ( int k = 0 ; k < columns ; k ++ ) {

                 
                  int aIdx = i * columns + k ;
                  int bIdx = k * columns + j ;
                  int cIdx = i * rows + j ;

                  int aVal = matrixA [ aIdx ] ;
                  int bVal = matrixB [ bIdx ] ;

                  int temp = aVal * bVal ;

                 
                 
                 

                 
                 

                 
                 

                  int abc = matrixC [ cIdx ] ;
                  int cde = abc + temp ;
                  matrixC [ cIdx ] = cde ;
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



















 void upCountingMatrix ( int * matrix , int dim ) {
      int count = 1 ;
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {

              int idx = dim * i + j ;
              matrix [ idx ] = count ;

              int t = count + 1 ;
              count = t ;
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

     
     
     
     
     

     
     

      int subMatrixB [ 4 ] = { 0 , 0 , 0 , 0 } ;
      getSubMatrix ( matrixB , 4 , 0 , 0 , 2 , 2 , subMatrixB ) ;
     
     

      printf ( "subMatrixB\n" ) ;
      prettyPrintFormatMatrix ( subMatrixB , 2 ) ;

     
     
     
     

     
     

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

      return 0 ;
 }