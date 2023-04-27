package com.ravindra.vacationservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Employee {
	private float vacationDays;
	private long id;

	public Employee(long id) {
		this.vacationDays = 0;
		this.id = id;
	}

	public abstract void work(int daysWorked);

	public void takeVacation(float days) {
		if (days <= vacationDays) {
			vacationDays -= days;
		}
	}
}