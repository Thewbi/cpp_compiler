























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


 int getSubMatrix ( int * matrixDest , int * matrixSrc , int dim , int xPos , int yPos , int width , int height ) {

     

     
     
     
     
     

     
     
     
     

      int xEnd = xPos + width ;
      int yEnd = yPos + height ;

     
     

      int counter = 0 ;

      int innerI = 0 ;
      for ( int i = xPos ; i < xEnd ; i ++ ) {

          int innerJ = 0 ;
          for ( int j = yPos ; j < yEnd ; j ++ ) {

             

             
              int tempIdx = i * dim ;
             

             

              int idx = tempIdx + j ;
             

             
             

             
              int tempIdxC = innerI * width ;
             

             

              int idxC = tempIdxC + innerJ ;
             

             

             

              int transfer = matrixSrc [ idx ] ;
             
             
              matrixDest [ idxC ] = transfer ;

             
             

             
              int t = innerJ + 1 ;
              innerJ = t ;

              int tempCounter = counter + 1 ;
              counter = tempCounter ;

          }

         
          int u = innerI + 1 ;
          innerI = u ;
      }


      return 0 ;
 }


 int setSubMatrix ( int * matrix_dest , int * matrix_src , int dim , int xPos , int yPos , int width , int height ) {

     

      for ( int i = 0 ; i < height ; i ++ ) {
          for ( int j = 0 ; j < width ; j ++ ) {

             
              int temp1 = i * width ;
              int temp2 = temp1 + j ;
              int tempData = matrix_src [ temp2 ] ;

             
              int temp3 = ( yPos + i ) ;
              int temp4 = temp3 * dim ;
              int temp5 = ( xPos + j ) ;
              int destIndex = temp4 + temp5 ;

              matrix_dest [ destIndex ] = tempData ;
          }
      }
      return 0 ;
 }


 int segmentedMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {

      int nc = 2 ;
      int rowSteps = rows / nc ;

      int kc = 2 ;
      int columnsSteps = columns / kc ;

      int mc = 2 ;
      int innerSteps = rows / nc ;

      int subMatrixA [ 4 ] = { 0 , 0 , 0 , 0 } ;
      int subMatrixB [ 4 ] = { 0 , 0 , 0 , 0 } ;

     
     

     
     

     
     
      for ( int jc = 0 ; jc < rowSteps ; jc ++ ) {

         
         
          for ( int pc = 0 ; pc < columnsSteps ; pc ++ ) {

             

             
             
              int xPos_b = pc * kc ;
              int yPos_b = jc * nc ;
              int sub_matrix_1 = getSubMatrix ( subMatrixB , matrixC , 4 , xPos_b , yPos_b , kc , nc ) ;

             
              int resultPrettyPrintB = prettyPrintFormatMatrix ( subMatrixB , 2 ) ;
              int separator = 123 ;
              putint ( separator ) ;



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
          6 , 9 , 7 , 1
      } ;

     
     
     
     
     
     
     
      int matrixC [ 16 ] = {
          1 , 2 , 3 , 4 ,
          5 , 6 , 7 , 8 ,
          9 , 10 , 11 , 12 ,
          13 , 14 , 15 , 16
      } ;

     
      int matrixB [ 16 ] = {
          1 , 2 , 4 , 2 ,
          8 , 6 , 0 , 0 ,
          7 , 6 , 8 , 5 ,
          8 , 4 , 7 , 5
      } ;

      int result_1 = segmentedMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;

      exit ( ) ;
      return 0 ;
 }