






















 void matrixAddInto ( int * matrixA , int * matrixB , int rows , int columns ) {
      for ( int i = 0 ; i < rows ; i ++ ) {
          for ( int j = 0 ; j < columns ; j ++ ) {

              int tempIndex = i * rows + j ;
             

              int tempAValue = matrixA [ tempIndex ] ;
              int tempBValue = matrixB [ tempIndex ] ;
              matrixA [ tempIndex ] = tempAValue + tempBValue ;
          }
      }
 }

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



 void setSubMatrix ( int * matrix_dest , int * matrix_src , int dim , int xPos , int yPos , int width , int height ) {
      for ( int i = 0 ; i < height ; i ++ ) {
          for ( int j = 0 ; j < width ; j ++ ) {

              int temp = i * width + j ;
              int tempData = matrix_src [ temp ] ;

              int temp2 = ( yPos + i ) * dim + ( xPos + j ) ;
              matrix_dest [ temp2 ] = tempData ;
          }
      }
 }


 void segmentedMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {
     
      int nc = 2 ;
      int rowSteps = rows / nc ;

      int kc = 2 ;
      int columnsSteps = columns / kc ;

      int mc = 2 ;
      int innerSteps = rows / nc ;

     
     
     

     
      int iterationCounter = 0 ;

     
     
      for ( int jc = 0 ; jc < rowSteps ; jc ++ ) {

         
         
          for ( int pc = 0 ; pc < columnsSteps ; pc ++ ) {

             
              int subMatrixB [ 4 ] = { 0 , 0 , 0 , 0 } ;
              int xPos_b = pc * kc ;
              int yPos_b = jc * nc ;
              getSubMatrix ( matrixB , 4 , xPos_b , yPos_b , kc , nc , subMatrixB ) ;

             

             
             
              for ( int ic = 0 ; ic < innerSteps ; ic ++ ) {

                  printf ( "//\n" ) ;
                  printf ( "// Iteration: %d\n" , iterationCounter ) ;
                  printf ( "//\n" ) ;

                 
                  int subMatrixA [ 4 ] = { 0 , 0 , 0 , 0 } ;
                  int xPos_a = ic * mc ;
                  int yPos_a = pc * kc ;
                  getSubMatrix ( matrixA , 4 , xPos_a , yPos_a , mc , kc , subMatrixA ) ;

                  printf ( "[\n" ) ;
                 
                  prettyPrintFormatMatrix ( subMatrixA , 2 ) ;
                  printf ( "------------------------\n" ) ;
                 
                  prettyPrintFormatMatrix ( subMatrixB , 2 ) ;
                  printf ( "]\n" ) ;

                  int huhuh = iterationCounter + 1 ;
                  iterationCounter = huhuh ;

                 
                 
                  int tempMult [ 4 ] = { 0 , 0 , 0 , 0 } ;
                  standardMatrixMult ( subMatrixA , subMatrixB , tempMult , 2 , 2 ) ;

                  printf ( "+++++++++++++++++++++++++++++\n" ) ;
                 
                  prettyPrintFormatMatrix ( tempMult , 2 ) ;
                  printf ( "+++++++++++++++++++++++++++++\n" ) ;

                 
                 
                  int tempAccum [ 4 ] = { 0 , 0 , 0 , 0 } ;
                  int xPos_c = ic * kc ;
                  int yPos_c = jc * nc ;
                  getSubMatrix ( matrixC , 4 , xPos_c , yPos_c , nc , kc , tempAccum ) ;

                 

                 
                 
                  matrixAddInto ( tempAccum , tempMult , 2 , 2 ) ;

                 

                 

                 
                 
                 
                  setSubMatrix ( matrixC , tempAccum , 4 , yPos_c , xPos_c , nc , kc ) ;

                 

                  printf ( "-----------------------------\n" ) ;
                  prettyPrintFormatMatrix ( matrixC , 4 ) ;
                  printf ( "-----------------------------\n" ) ;

                 

              }

             

          }

         

      }

      printf ( "IterationCounter: \t %d\n" , iterationCounter ) ;
 }



 void standardMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {
     
     
     
     
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
      int ctr = 0 ;
     
      for ( int i = 0 ; i < dim ; i ++ ) {
         
          for ( int j = 0 ; j < dim ; j ++ ) {
             
              int idx = dim * i + j ;
              int temp = matrix [ idx ] ;
             
              printf ( "\t %d" , temp ) ;

              int tttt = ctr + 1 ;
              ctr = tttt ;
          }
          printf ( "\n" ) ;
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

     
     
     
     
     

     
     

     
     
     
     

     
      segmentedMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;
     
     

      printf ( "C\n" ) ;
      prettyPrintFormatMatrix ( matrixC , 4 ) ;

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

      return 0 ;
 }