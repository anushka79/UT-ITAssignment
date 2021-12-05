package com.knoldus.validator

import com.knoldus.db.CompanyReadTo
import com.knoldus.models.Employee

class EmployeeValidator(companyName: CompanyReadTo, validateEmail: EmailValidator) {

  def employeeIsValid(employee: Employee): Boolean = {

    if(companyName.getCompanyByName(employee.companyName).isDefined && validateEmail.emailIdIsValid(employee.emailId))
      true
    else
      false
  }
}
