/*function to calculate the log2(.) of int numbers*/
int log2(int N)
{
  int k = N, i = 0;
  while(k) {
    k >>= 1;
    i++;
  }
  return i - 1;
}