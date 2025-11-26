void prettyPrintFormatMatrix ( int * matrix , int dim , const char * format ) {
      for ( int i = 0 ; i < dim ; i ++ ) {
          for ( int j = 0 ; j < dim ; j ++ ) {
              printf ( format , matrix [ dim * i + j ] ) ;
          }
          printf ( "\n" ) ;
      }
 }