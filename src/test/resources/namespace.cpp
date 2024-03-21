namespace outer {
inline namespace inner {
  void foo();
}  // namespace inner
}  // namespace outer





// Shorten access to some commonly used names in .cc files.
namespace baz = ::foo::bar::baz;



// Shorten access to some commonly used names (in a .h file).
namespace librarian {
namespace internal {  // Internal, not part of the API.
namespace sidetable = ::pipeline_diagnostics::sidetable;
}  // namespace internal

inline void my_inline_function() {
  // namespace alias local to a function (or method).
  namespace baz = ::foo::bar::baz;
  ...
}
}  // namespace librarian