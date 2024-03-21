
/*
template <typename T>
    ;
*/

template <typename T>
T myMax(T x, T y)
{
    return (x > y) ? x : y;
}

/*

namespace
{

template <typename T>
T myMax(T x, T y)
{
    return (x > y) ? x : y;
}

}
*/

/*
template <typename T>
  std::ostream& operator <<(std::ostream& os, const etl::to_arithmetic_result<T>& result)
  {
    if (result.has_value())
    {
      os << result.value();
    }
    else
    {
      os << result.error().c_str();
    }

    return os;
  }
  */