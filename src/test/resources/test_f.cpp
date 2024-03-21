TEST_F(TestClass, false_positive__N)
{
  static constexpr char text[] =
    R"~~~(; ModuleID = 'a.cpp'
            source_filename = "a.cpp"

   define private i32 @"__ir_hidden#100007_"(i32 %arg1) {
     ret i32 %arg1
   }

define i32 @main(i32 %arg1) {
   %1 = call i32 @"__ir_hidden#100007_"(i32 %arg1)
   ret i32 %1
}
)~~~";

 NameMock ns(text);
 ASSERT_EQ(std::string(text), ns.getSeed());
}