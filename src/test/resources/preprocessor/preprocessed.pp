









































































































 void multiParamTest ( int * matrixA , int * matrixB , int rows , int columns ) {

      printf ( "multiParamTest()" ) ;


      int temp = matrixA [ 0 ] ;
      printf ( "%d" , temp ) ;

      int temp = matrixB [ 0 ] ;
      printf ( "%d" , temp ) ;

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

     
     
     
     
     

     
     

     
     
     
      multiParamTest ( matrixA , matrixB , 4 , 5 ) ;

     
     

     
     
     
     
     
     
     

     
     
     
     
     
     
     
     
      return 0 ;
 }