package app;

import app.calendar.HtmlCalendar;
import server.Handler;
import server.HttpRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarImpl extends HtmlPageGenerator implements Handler {

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
        String years ="";

        Month[]months = Month.values();
        DayOfWeek[]daysOfWeek = DayOfWeek.values();

        for(int i =0; i<=6;i++){
          days += "  <option value = "  +"\""+  daysOfWeek[i] +"\">" + daysOfWeek[i] +"</option>\n";
        }
        for (int i = 1990; i<=2030; i++ ){
            years += "  <option value = "  +"\""+  i +"\">" + i +"</option>\n";
        }
        for (int i = 0; i<=11; i++ ){
           month += "  <option value = "  +"\""+ months[i] +"\">" + months[i] +"</option>\n";
        }


        return
                "<form action=\"/calendar/\" id=\"calendarform\">"+
                "<select name =\"firstday\" form=\"calendarform\">\n" +
                days+
                "</select>"+
                "<select name =\"year\" form=\"calendarform\">\n" +
                years+
                "</select>"+
                "<select name =\"month\" form=\"calendarform\">\n" +
                month+
                "</select>"+

                "<input type=\"submit\" value=\"generate\"></form> ";
    }

    @Override
    public String getPageContent(HttpRequest httpRequest) {
        DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY;
        int year = LocalDate.now().getYear();
        Month month = LocalDate.now().getMonth();
        LocalDate localDate = LocalDate.now();
        try {
           firstDayOfWeek = DayOfWeek.valueOf(httpRequest.getParameters().get("firstday"));
           year = Integer.valueOf(httpRequest.getParameters().get("year"));
           month = Month.valueOf(httpRequest.getParameters().get("month"));

           localDate = LocalDate.of(year,month,1);

        }catch (NullPointerException n){
            return new HtmlCalendar().returnCalendarTable();
        }

        return new HtmlCalendar(localDate,firstDayOfWeek).returnCalendarTable();
    }
}
