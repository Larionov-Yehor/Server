package app;

import server.HttpRequest;

/**
 * Created by LaroSelf on 12.11.2016.
 */


    public abstract class HtmlPageGenerator {

        private final String startOfHtmlFile = "<!DOCTYPE html>\n" +
                "<head><style>td.weekend {\n" + "    color: red;\n" + "}\n" + "\n" + "td.currentDay {\n" + "    color: cyan;\n" +
                "}\n" + "td.anotherMonthColor {\n" + " color: orange;\n" + "}\n" + "\n" + "td {\n" + "  padding: 5px;\n" +
                "}</style>" + "</head>" + "<html><body>";

        private final String endOfHtmlFile = "</body>\n</html>\n";


        public abstract String getAction();
        public abstract String getPageContent(HttpRequest httpRequest);

        public String createPage(HttpRequest httpRequest){

            String htmlPage = "";

            htmlPage += startOfHtmlFile;
            htmlPage += getAction();
            htmlPage += getPageContent(httpRequest);
            htmlPage += endOfHtmlFile;

        return  htmlPage;}

    }


