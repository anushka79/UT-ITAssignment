package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Anushka:Employee = new Employee("Anushka","Roy",22,15000,"Intern","Knoldus","anushka.roy@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Anushka)) thenReturn(true)
    val result = userImpl.createEmployee(Anushka)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Anushka)) thenReturn(false)
    val result = userImpl.createEmployee(Anushka)
    assert(result.isEmpty)
  }
}