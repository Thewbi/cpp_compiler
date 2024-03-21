#pragma once

#include <stdint.h>

namespace Namespace1
{
constexpr float some_const_float = -1.0F;

constexpr int32_t some_const_int32_t = 100000;

class IInterface
{
  public:
    virtual ~IInterface() = default;

    virtual void initialize(void) = 0;
    
    virtual void set_some_value(float value) = 0;

    virtual float get_some_value(void) = 0;
    
}; /* interface */

} /* namespace  */