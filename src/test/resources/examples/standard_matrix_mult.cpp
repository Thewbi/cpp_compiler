int counter = 0;

    // over row of matrix B
    for (int i = 0; i < rows; i++) {

        // matrixC[i] = i;

        // over column of matrix A
        for (int j = 0; j < columns; j++) {

            // int tcounter = counter;
            // counter = tcounter + 1;
            // matrixC[1] = counter;

            //matrixC[j] = j;

            // fuse row and column together into a single cell of matrix C
            for (int k = 0; k < columns; k++) {

                // int tcounter = counter;
                // counter = tcounter + 1;
                // matrixC[1] = counter;

                // int t1 = matrixA[0];
                // // printf("test: %d\n", t1);
                // matrixC[3] = t1;

                matrixC[i * rows + j] += matrixA[i * columns + k] * matrixB[k * columns + j];

            }

        }
    }
}