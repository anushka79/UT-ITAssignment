package com.knoldus.request

import com.knoldus.db.CompanyReadTo
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.funsuite.AnyFunSuite

class CompanyImplIntegrationTest extends AnyFunSuite {
  val companyName = new CompanyReadTo
  val validateEmail = new EmailValidator
  val companyValidator = new CompanyValidator(companyName, validateEmail)


  test("Company should not be created as already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  test("Company should not be created as email ID is invalid"){
    val wiproCompany: Company = Company("WIPRO", "wipro@wipcm", "Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(wiproCompany)
    assert(result.isEmpty)
  }

  test("Cannot be created as email is invalid and already exist in DB"){
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmailcom", "Noida")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  test("Company can be created"){
    val goldmanSachsCompany: Company = Company("GoldMan Sachs", "goldmansachs@gmail.com", "Hyderabad")
    val companyImpl = new CompanyImpl(companyValidator)
    val result = companyImpl.createCompany(goldmanSachsCompany)
    assert(result.isDefined)
  }
}
