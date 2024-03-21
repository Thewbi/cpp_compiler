// https://learn.microsoft.com/de-de/cpp/preprocessor/hash-if-hash-elif-hash-else-and-hash-endif-directives-c-cpp?view=msvc-170

#include <iostream>
#include <etl/absolute.h>

#include "test.h"
#include "test/test.h"

#include "foo/server/fooserver.h"

#include <sys/types.h>
#include <unistd.h>

#include <string>
#include <vector>

#include "base/basictypes.h"
#include "foo/server/bar.h"
#include "third_party/absl/flags/flag.h"

#if 0
#include "pch.h"  // or whatever line you had selected
#endif // 0

#if(SDK_CONF_RTOS_PRESENT > 0)

#endif // SDK_CONF_STL_PRESENT


#ifndef FOO_BAR_BAZ_H_
#define FOO_BAR_BAZ_H_

...

#endif  // FOO_BAR_BAZ_H_