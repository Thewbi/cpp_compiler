void upCountingMatrix(int* matrix, int dim) {
    int count = 1;
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            matrix[dim*i + j] = count;
            count++;
        }
    }
}

void prettyPrintFormatMatrix(int* matrix, int dim, const char* format) {
    for (int i = 0; i < dim; i++) {
        for (int j = 0; j < dim; j++) {
            printf(format, matrix[dim*i + j]);
        }
        printf("\n");
    }
}

void segmentedMatrixMult(int* matrixA, int* matrixB, int* matrixC, int rows, int columns) {
    
    int nc = 2; // subset size
    int rowSteps = rows / nc;

    int kc = 2; // subset size
    int columnsSteps = columns / kc;

    int mc = 2; // subset size
    int innerSteps = rows / nc;

    //
    // ACT
    //

    // DEBUG
    int iterationCounter = 0;

    // for jc = 0 to n-1 step nc
    // Loop 1
    for (int jc = 0; jc < rowSteps; jc++) {

        // for pc = 0 to k-1 step kc
        // Loop 2
        for (int pc = 0; pc < columnsSteps; pc++) {

            //int* subMatrixB = subMatrix(matrixB, pc * kc, jc * nc, kc, nc);
            int subMatrixB[2*2];
            getSubMatrix(matrixB, DIMENSION, pc * kc, jc * nc, kc, nc, subMatrixB);

            // for ic = 0 to m-1 step mc
            // Loop 3
            for (int ic = 0; ic < innerSteps; ic++) {

                //Matrix subMatrixA = matrixA.getSubMatrix(ic * mc, pc * kc, mc, kc);
                int subMatrixA[2*2] = { 0, 0, 0, 0 };
                getSubMatrix(matrixA, DIMENSION, ic * mc, pc * kc, mc, kc, subMatrixA);

                printf("[\n");
                prettyPrintFormatMatrix(subMatrixA, 2, "%6d");
                printf("------------------------\n");
                prettyPrintFormatMatrix(subMatrixB, 2, "%6d");
                printf("]\n");

                iterationCounter++;                

                // perform a matrix mult of the sub matrices
                //Matrix temp = subMatrixA.mult(subMatrixB);
                int tempMult[2*2] = { 0, 0, 0, 0 };
                standardMatrixMult(subMatrixA, subMatrixB, tempMult, 2, 2);

                //printf("+++++++++++++++++++++++++++++\n");
                //prettyPrintFormatMatrix(tempMult, 2, "%6d");
                //printf("+++++++++++++++++++++++++++++\n");

                // // retrieve sub matrix to accumulate into
                // Matrix accumulatorSubMatrixC = matrixC.getSubMatrix(ic * kc, jc * nc, nc, kc);
                int tempAccum[2*2] = { 0, 0, 0, 0 };
                getSubMatrix(matrixC, DIMENSION, ic * kc, jc * nc, nc, kc, tempAccum);

                // // accumulate the result
                // accumulatorSubMatrixC.add(temp);
                matrixAddInto(tempAccum, tempMult, 2, 2);

                // // place the accumulator back into the large result matrix
                // matrixC.setSubMatrix(jc * nc, ic * kc, nc, kc, accumulatorSubMatrixC);
                setSubMatrix(matrixC, DIMENSION, jc * nc, ic * kc, nc, kc, tempAccum);

            }
        }
    }

    printf("%d\n", iterationCounter);
}

int main()
{
    int matrixA[ELEMENTS] = {
        1, 2, 3, 4,
        5, 6, 7, 8,
        9, 10, 11, 12,
        13, 14, 15, 16
    };

    upCountingMatrix(matrixA, 16);

    for (int i = 0; i < length; i++)
    {
        printf("a");
    }

    return 0;
}