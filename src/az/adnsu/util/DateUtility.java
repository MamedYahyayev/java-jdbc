package az.adnsu.util;

import java.util.Calendar;
import java.util.Date;

public abstract class DateUtility {

	public static Date getDateFromCalendar(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	public static int getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}
}
