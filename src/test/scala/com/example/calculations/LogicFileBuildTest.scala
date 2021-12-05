package com.example.calculations

import org.scalatest.funsuite.AnyFunSuite

class LogicFileBuildTest extends AnyFunSuite {
  var LogicFile_Object = new LogicFileBuild()

  //  ******************* DIVISION TEST ******************

  test("Test to check divison of zero"){
    val num1 = 0
    val num2 = 2
    val res = 0
    assert(LogicFile_Object.divisionOf(num1, num2)==res)
  }

  test("Test to check division by zero"){
    assertThrows[ArithmeticException](LogicFile_Object.divisionOf(132,0))
  }

  //  *************FIBONACCI TEST **************

  test("Test to check fibonacci of zero"){
    val num = 0
    val res = 0
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }
  test("To check fibonacci"){
    val num = 9
    val res = 34
    assert(LogicFile_Object.fibonacciOf(num)==res)
  }

}

