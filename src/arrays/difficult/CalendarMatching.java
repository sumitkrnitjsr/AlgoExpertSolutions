package arrays.difficult;
import java.util.*;

public class CalendarMatching {
	
	 public static List<StringMeeting> calendarMatching(
		      List<StringMeeting> calendar1,
		      StringMeeting dailyBounds1,
		      List<StringMeeting> calendar2,
		      StringMeeting dailyBounds2,
		      int meetingDuration) {
		    // Write your code here.
				List<MeetingHours> mergedCal = updateAndMerge(calendar1, calendar2, dailyBounds1, dailyBounds2);
				
		    List<MeetingHours> avlb = new ArrayList<>();
				for(int i = 1;i < mergedCal.size();i++) {
						if(mergedCal.get(i).start - mergedCal.get(i - 1).end >= meetingDuration) {
								avlb.add(new MeetingHours(mergedCal.get(i - 1).end, mergedCal.get(i).start));
						}
				}
				
				List<StringMeeting> result = new ArrayList<>();
				for(int i = 0;i < avlb.size();i++) {
						result.add(new StringMeeting(
												convert(avlb.get(i).start),
												convert(avlb.get(i).end)));
				}
				
				return result;
		  }

			private static List<MeetingHours> updateAndMerge(List<StringMeeting> calendar1, List<StringMeeting> calendar2, 
																											StringMeeting bound1, StringMeeting bound2) {
				List<MeetingHours> updatedCalendar1 = update(calendar1, bound1);
				List<MeetingHours> updatedCalendar2 = update(calendar2, bound2);
				List<MeetingHours> mergedCalendar = mergeCalendar(updatedCalendar1, updatedCalendar2);
				return mergedCalendar;
			}
			
			private static List<MeetingHours> update(List<StringMeeting> calendar, StringMeeting bound) {
					calendar.add(0,new StringMeeting("0:00", bound.start));
					calendar.add(new StringMeeting(bound.end, "23:59"));
					List<MeetingHours> updatedCalendar = new ArrayList<MeetingHours>();
					for(int i = 0;i < calendar.size();i++) {
							String timeStart = calendar.get(i).start;
							String timeEnd = calendar.get(i).end;
							int colonPositionStart = calendar.get(i).start.indexOf(":");
							int colonPositionEnd = calendar.get(i).end.indexOf(":");
							int hoursStart = Integer.parseInt(timeStart.substring(0, colonPositionStart));
							int hoursEnd = Integer.parseInt(timeEnd.substring(0, colonPositionEnd));
							int minutesStart = Integer.parseInt(timeStart.substring(colonPositionStart + 1,timeStart.length()));
							int minutesEnd = Integer.parseInt(timeEnd.substring(colonPositionEnd + 1, timeEnd.length()));
							int start = hoursStart * 60 + minutesStart;
							int end = hoursEnd * 60 + minutesEnd;
							updatedCalendar.add(new MeetingHours(start, end));
					}
				
					return updatedCalendar;
			}
			
			private static List<MeetingHours> mergeCalendar(List<MeetingHours> cal1, List<MeetingHours> cal2) {
					int i = 0;
					int j = 0;
					List<MeetingHours> mergedCal = new ArrayList<>();
				
					while(i < cal1.size() && j < cal2.size()) {
							if(cal1.get(i).start < cal2.get(j).start) {
									mergedCal.add(cal1.get(i));
									i++;
							}else {
									mergedCal.add(cal2.get(j));
									j++;
							}			 
					}
				
					while(i < cal1.size()) {
							mergedCal.add(cal1.get(i));
							i++;
					}
				
					while(j < cal2.size()) {
							mergedCal.add(cal2.get(j));
							j++;
					}
				
					List<MeetingHours> setCal = new ArrayList<>();
					setCal.add(mergedCal.get(0));
					for(i = 1;i < mergedCal.size();i++) {
							MeetingHours current = mergedCal.get(i);
							MeetingHours prev = setCal.get(setCal.size() - 1);
							if(prev.end >= current.start) {
									setCal.set(setCal.size() - 1, 
														new MeetingHours(prev.start, Math.max(prev.end, current.end)));
							}else{
									setCal.add(current);
							}
					}
					
					return setCal;
			}
			
			private static String convert(int minutes) {
					int hours = minutes / 60;
					int mins = minutes % 60;
					String hour = Integer.toString(hours);
					String minute = (mins < 10) ? "0" + Integer.toString(mins) : Integer.toString(mins);
					return hour + ":" + minute;
			}
			
			
		  static class StringMeeting {
		    public String start;
		    public String end;

		    public StringMeeting(String start, String end) {
		      this.start = start;
		      this.end = end;
		    }
		  }
			
			static class MeetingHours {
					int start;
					int end;
					public MeetingHours(int s, int e) {
							start = s;
							end = e;
					}
			}

}
