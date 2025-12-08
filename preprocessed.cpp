
























 int test_function ( int * matrixDest ) {
      printf ( "test_function\n" ) ;
      return 0 ;
 }


 int matrixAddInto ( int * matrixA , int * matrixB , int rows , int columns ) {

      printf ( "matrixAddInto()\n" ) ;

      for ( int i = 0 ; i < rows ; i ++ ) {
          for ( int j = 0 ; j < columns ; j ++ ) {

             
              int temp = i * rows ;
              int tempIndex = temp + j ;

             
              int tempAValue = matrixA [ tempIndex ] ;
              int tempBValue = matrixB [ tempIndex ] ;
              matrixA [ tempIndex ] = tempAValue + tempBValue ;
          }
      }

      return 0 ;
 }



 int getSubMatrix ( int * matrixDest , int * matrixSrc , int dim , int xPos , int yPos , int width , int height ) {

      printf ( "getSubMatrix()\n" ) ;

     
     
     
     
     

     
     
     
     

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

      printf ( "setSubMatrix()\n" ) ;

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





 int standardMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {

      printf ( "standardMatrixMult()\n" ) ;

     
     
     
     

     

     

     

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



 int segmentedMatrixMult ( int * matrixA , int * matrixB , int * matrixC , int rows , int columns ) {

     

     

     
      printf ( "segmentedMatrixMult()\n" ) ;

      int nc = 2 ;
      int rowSteps = rows / nc ;

     

      int kc = 2 ;
      int columnsSteps = columns / kc ;

      int mc = 2 ;
      int innerSteps = rows / nc ;

     
     
     

     
     

      int subMatrixA [ 4 ] = { 80 , 81 , 82 , 83 } ;
      int subMatrixB [ 4 ] = { 70 , 71 , 72 , 73 } ;
     
      int tempAccum [ 4 ] = { 60 , 61 , 62 , 63 } ;

     
     
      for ( int jc = 0 ; jc < rowSteps ; jc ++ ) {

         
         
          for ( int pc = 0 ; pc < columnsSteps ; pc ++ ) {

             


             
             
              int xPos_b = pc * kc ;
              int yPos_b = jc * nc ;




             

             
             
              for ( int ic = 0 ; ic < innerSteps ; ic ++ ) {

                 

                 

                 
                 
                 

                 
                 
                  int xPos_a = ic * mc ;
                 
                  int yPos_a = pc * kc ;
                 
                 
                 



                 
                 
                 
                 
                 
                 
                 
                 

              }

             

          }

         

      }

     

      printf ( "segmentedMatrixMult() end\n" ) ;


      return 0 ;
 }







































 int upCountingMatrix ( int * matrix , int dim ) {

      printf ( "upCountingMatrix()\n" ) ;

      int count = 1 ;
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {

             
              int temp = dim * i ;
              int idx = temp + j ;

              matrix [ idx ] = count ;

              int t = count + 1 ;
              count = t ;
          }
      }
      return 0 ;
 }






 int main ( )
 {
      printf ( "main() 1\n" ) ;

     
     
     
     
     
     
     
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

     
     
     







     
     
     
     

     
     
     

     
     

     



      printf ( "main() 2\n" ) ;

      int result_1 = segmentedMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;

      printf ( "main() 3\n" ) ;

     
     

     
     

     
     
     
     
     
     
     

     
     
     
     
     
     
     

     

      printf ( "main() 4\n" ) ;

      exit ( ) ;
      return 0 ;
 }