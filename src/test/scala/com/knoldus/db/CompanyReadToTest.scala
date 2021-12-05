package com.knoldus.db

import org.scalatest.funsuite.AnyFunSuite

class CompanyReadToTest extends AnyFunSuite {
  val companyReadTo = new CompanyReadTo()

  test("Check if company exists in DB"){
    val companyName = "Knoldus"
    val result = companyReadTo.getCompanyByName(companyName)
    assert(result.isDefined)
  }


  test("Company should not exist in DB"){
    val companyName = "Goldman Sachs"
    val result = companyReadTo.getCompanyByName(companyName)
    assert(result.isEmpty)
  }

}
