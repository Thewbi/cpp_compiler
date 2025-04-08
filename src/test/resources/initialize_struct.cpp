// C
struct test_struct {

    int int_field;
    char char_field;
    float float_field;

    int int_array_field[100];
    char char_array_field[200];
    float float_array_field[300];

    int *int_ptr;
    char *char_ptr;
    float *float_ptr;

};

/*
// C++, anonymous struct with direct variable declaration
struct {
    int int_field;
    char char_field;
    float float_field;
} test_struct_1;

// C++, anonymous struct with direct variable declaration of several variables
struct {
    int int_field;
    char char_field;
    float float_field;
} test_struct_1, test_struct_2, test_struct_3;

// C++, named struct
struct new_datatype {
    int int_field;
    char char_field;
    float float_field;
}
*/