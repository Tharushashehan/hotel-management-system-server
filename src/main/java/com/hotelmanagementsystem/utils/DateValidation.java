package com.hotelmanagementsystem.utils;

import java.util.Date;
import java.util.List;

import com.hotelmanagementsystem.model.RoomCheckIn;

public class DateValidation {

	public static Boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate.compareTo(secondDate) <= 0 && firstDate.compareTo(new Date()) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int dateCollision(Date firstDate, Date secondDate, List<RoomCheckIn> checkins) {
		try {
		for (RoomCheckIn checkin : checkins) {
			if ((checkin.getStartDate().compareTo(firstDate) < 0 && checkin.getEndDate().compareTo(firstDate) > 0)
					|| (checkin.getStartDate().compareTo(secondDate) < 0
							&& checkin.getEndDate().compareTo(secondDate) > 0)) {
				throw new Exception();
			}
		}}
		catch (Exception e) {
			return -1;
		}
		return 0;
		
	}

}
