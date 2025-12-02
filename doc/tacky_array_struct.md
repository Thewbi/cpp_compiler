tmp.0 = Var("tmp.0")


structure_type.0 = Struct("structure_type.0", {
	a = Var("a")
	b = Var("b")
	c = Var("c")
})

struct.0 = Var("struct.0", structure_type.0)


struct.0.a = 0
struct.0.b = 1
struct.0.c = 0










# Arrays

https://medium.com/@pm100/working-through-wacc-chapter-15-arrays-and-pointer-arithmetic-e35248a70d0d

## C

// declare one-dimensional array of type int, the variable is named "array1d"
int array1d[5];

// access an element
int array1d_5 = array1d[5];

## TACKY

// define the array as a variable
array1d = Var("array1d", Array(Int32, 5))

// create a pointer (= normal variable that stores an address) to the first element of the array
array1d.ptr = Var("array1d.ptr")
GetAddress(array1d, array1d.ptr)

// advance the pointer forward to the requested element
// To point to element #5, move the pointer four times
array1d.ptr = array1d.ptr + 4 * sizeof(Int32)

// load the element (dereference). Load the value stored at the address 
// that the pointer points to into the variable "tmp.0"
tmp.0 = Var("tmp.0")
Load(array1d.ptr, tmp.0)





## C

// declare two-dimensional array of type int, the variable is named "array2d"
int array2d[2][3];

## TACKY

array2d = Var("array2d", Array(Array(Int32, 3), 2))