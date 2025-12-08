






 int test_function ( int param_1 ) {

      int matrix_in_test_function [ 4 ] = {
          80 , 81 , 82 , 83
      } ;

      return 0 ;
 }

 int main ( )
 {
      printf ( "main() start \n" ) ;

     
     

      int matrixA [ 4 ] = {
          1 , 2 , 3 , 4
         
         
         
         
      } ;

      int param_1 = 1 ;
      int test_function_result = test_function ( param_1 ) ;

      int a = matrixA [ 0 ] ;
      putint ( a ) ;
      a = matrixA [ 1 ] ;
      putint ( a ) ;
      a = matrixA [ 2 ] ;
      putint ( a ) ;
      a = matrixA [ 3 ] ;
      putint ( a ) ;

      printf ( "main() end \n" ) ;

      exit ( ) ;
      return 0 ;
 }