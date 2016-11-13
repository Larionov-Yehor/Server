package app;

import app.calendar.HtmlCalendar;
import server.Handler;
import server.HttpRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarImpl extends HtmlPageGenerator implements Handler {
   // private String pageContent = new HtmlCalendar(httpRequest.getParameters().get("firstday")).returnCalendarTable();
    private HttpRequest httpRequest;

    public CalendarImpl(HttpRequest httpRequest) {
        this.httpRequest=httpRequest;
    }

    @Override
    public String print(HttpRequest httpRequest) {

        return createPage(httpRequest);
    }

    @Override
    public String getAction() {
        String month="";
        String days = "";
        Month[]months = Month.values();
        DayOfWeek[]daysOfWeek = DayOfWeek.values();

        for(int i =0; i<=6;i++){
          days+= "  <option value = "  +"\""+  daysOfWeek[i] +"\">" + daysOfWeek[i] +"</option>\n";
        }


        return
                "<form action=\"/calendar/\" id=\"calendarform\">"+
                "<select name =\"firstday\" form=\"calendarform\">\n" +
                        days+
                "</select>"+
                "<input type=\"submit\" value=\"generate\"></form> ";
    }

    @Override
    public String getPageContent(HttpRequest httpRequest) {
        DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY;
        try {
           firstDayOfWeek = DayOfWeek.valueOf(httpRequest.getParameters().get("firstday"));
        }catch (NullPointerException n){
            return new HtmlCalendar().returnCalendarTable();
        }

        return new HtmlCalendar(firstDayOfWeek).returnCalendarTable();
    }
}
