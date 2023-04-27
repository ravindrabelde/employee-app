package com.ravindra.vacationservice.model;

import static com.ravindra.vacationservice.model.EmployeeUtils.ANNUAL_WORKING_DAYS;

public class HourlyEmployee extends Employee {
	private static final float YEARLY_VACATION_DAYS = 10;

	public HourlyEmployee(long id) {
		super(id);
	}

	@Override
	public void work(int daysWorked) {
		if (daysWorked >= 0 && daysWorked <= ANNUAL_WORKING_DAYS) {
			float newVacationDays = getVacationDays() + daysWorked * YEARLY_VACATION_DAYS / ANNUAL_WORKING_DAYS;
			setVacationDays(newVacationDays);
		}
	}
}

