// semant: check that i and length are both int
// check the initializer (int i = 0 is ok, int i = 'a' is not ok)
int main()
{
    int length = 3;

    // for (int i = 0; i < length; i++)
    // {
    //     print("a");
    // }

    return 0;
}

/*
for (auto& i : v)
{

}

for (size_t i = 0; i < length; i++)
{

}

for (int i = length - 1; i >= 0; i--)
{

}
*/