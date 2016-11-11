package server;

/**
 * Created by LaroSelf on 11.11.2016.
 */
public class HtmlPage {
    private final String startOfHtmlFile = "<!DOCTYPE html>\n" +
            "<head><style>td.weekend {\n" + "    color: red;\n" + "}\n" + "\n" + "td.currentDay {\n" + "    color: cyan;\n" +
            "}\n" + "td.anotherMonthColor {\n" + " color: orange;\n" + "}\n" + "\n" + "td {\n" + "  padding: 5px;\n" +
            "}</style>" + "</head>" + "<html><body>";

    private final String endOfHtmlFile = "</body>\n</html>\n";
    private final String greaterLink = "<a href=\"greater\">greater</a><br>";
    private final String calendarLink = "<a href=\"calendar\">calendar</a>";


    public String getStartOfHtmlFile() {
        return startOfHtmlFile;
    }

    public String getEndOfHtmlFile() {
        return endOfHtmlFile;
    }

    public String getGreaterLink() {
        return greaterLink;
    }

    public String getCalendarLink() {
        return calendarLink;
    }
}
