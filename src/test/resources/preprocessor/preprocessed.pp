































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

































 int upCountingMatrix ( int * matrix , int dim ) {
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
     

     
     
     
     






     
     
     
     

 int pp3 = standardMatrixMult ( matrixA , matrixB , matrixC , 4 , 4 ) ;



     
     

     
     

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

      exit ( ) ;
      return 0 ;
 }