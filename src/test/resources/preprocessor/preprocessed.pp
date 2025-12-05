


























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












































 int main ( )
 {
     

     
      int matrixA [ 16 ] = {
          9 , 0 , 9 , 4 ,
          2 , 6 , 6 , 7 ,
          9 , 3 , 8 , 1 ,
          6 , 9 , 7 , 1
      } ;

     
     
     
     
     
     
      int matrixC [ 16 ] = {
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0 ,
          0 , 0 , 0 , 0
      } ;

     
      int matrixB [ 16 ] = {
          1 , 2 , 4 , 2 ,
          8 , 6 , 0 , 0 ,
          7 , 6 , 8 , 5 ,
          8 , 4 , 7 , 5
      } ;

     
     
     
     






     
      int subMatrixB [ 4 ] = { 255 , 255 , 255 , 255 } ;

      int getResult = getSubMatrix ( subMatrixB , matrixB , 4 , 0 , 0 , 2 , 2 ) ;
     

     
     
     







     
     

     
     

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

      exit ( ) ;
      return 0 ;
 }