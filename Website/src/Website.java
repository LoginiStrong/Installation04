import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;

public class Website {

    public static void main(String[] args) throws IOException, InterruptedException {

        //This is the array of strings that hold each piece of information per page
        String[][] newArray = new String[96][6];

        //These variables make sure we progress through the array after each new page
        int startLoop = 0;
        int reach = 24;

        //This for loop is for progressing through each page to get 96 recipes. In each if statement we build a body for each page
        for (int h = 0; h < 4; h++) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=0&sz=24")) //starting URL…
                    .GET() // GET is default
                    .build();

            if (h == 0) {
                request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=0&sz=24")) //starting URL…
                        .GET() // GET is default
                        .build();
            }
            if (h == 1) {
                request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=24&sz=24")) //starting URL…
                        .GET() // GET is default
                        .build();
            }
            if (h == 2) {
                request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=48&sz=24")) //starting URL…
                        .GET() // GET is default
                        .build();
            }
            if (h == 3) {
                request = HttpRequest.newBuilder()
                        .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=72&sz=24")) //starting URL…
                        .GET() // GET is default
                        .build();
            }

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            //this is the string of the first webpage we are manipulating
            String body = response.body();

            int begin = 0;//so that we can start at the end of the previous link we found

            //This loop is iterating through each link on the webpage (recipe)
            for (int i = startLoop; i < reach; i++) {
                int start = body.indexOf("\"thumb-link\" href=\"", begin);
                int end = body.indexOf("\" title", start);
                //System.out.println(start);
                //System.out.println(end);
                start = start + 19;
                String link = body.substring(start, end);

                HttpRequest newRequest = HttpRequest.newBuilder()
                        .uri(URI.create(link)) //starting URL…
                        .GET() // GET is default
                        .build();
                HttpResponse<String> newResponse = client.send(newRequest,
                        HttpResponse.BodyHandlers.ofString());
                String tempBody = newResponse.body(); //creating a string out of the body of our sub web page

                //temporary starting and ending indexes of desired information we are searching for
                int tempStart = 0;
                int tempEnd;

                //This code gets the path
                String path = "";
                String title = "";
                for (int j = 0; j < 5; j++) {
                    int navigate = tempBody.indexOf("breadcrumb-element", tempStart);
                    tempStart = tempBody.indexOf(">", navigate);
                    tempEnd = tempBody.indexOf("<", tempStart);
                    path += tempBody.substring(tempStart + 1, tempEnd);//finds each path relative to the narrowing indexes
                    path += "/";
                    if (j == 3 || j == 4) {

                        //a lot of this is replacing character that will interfere with the csv file
                        path = path.replace("\n", "");
                        path = path.replace("\r\n", "");
                        path = path.replace("\r", "");
                        title = (tempBody.substring(tempStart + 1, tempEnd));//finds the title relative to the narrowing indexes
                        title = title.replace(",", "");
                        title = title.replace("\n", "");
                        title = title.replace("&amp;", "&");

                    }

                }
                title += ",";//commas are added to separate the rows in the csv file
                newArray[i][2] = title;
                //a lot of this is replacing character that will interfere with the csv file
                path = path.replace("\n", "");
                path = path.replace("\r", "");
                path = path.replace("\r\n", "");
                path = path.replace("&amp;", "&");
                path += ",";
                newArray[i][1] = path;

                //This code gets the author
                int navigate = tempBody.indexOf("recipe-author");
                tempStart = tempBody.indexOf("By", navigate);
                tempEnd = tempBody.indexOf("\n", tempStart);
                String author = tempBody.substring(tempStart, tempEnd);
                author = author.replace(",", "");
                author = author.replace("$amp;", "&");
                author += ",";
                newArray[i][0] = author;

                String servings = "";
                tempStart = tempBody.indexOf("Makes", navigate);
                if (tempStart == -1) {
                    servings = "Not specified,";
                } else {
                    //a lot of this is replacing character that will interfere with the csv file
                    tempEnd = tempBody.indexOf("\n", tempStart);
                    servings = tempBody.substring(tempStart, tempEnd);
                    servings = servings.replace(",", "");
                    servings = servings.replace("\n", "");
                    servings = servings.replace("\r\n", "");
                    servings = servings.replace("\r", "");
                    servings += ",";
                }
                newArray[i][3] = servings;

                navigate = tempBody.indexOf("recipe-details-ingredients");
                tempStart = tempBody.indexOf("<li>", navigate);
                tempEnd = tempBody.indexOf("</ul", navigate);
                String ingredients = tempBody.substring(tempStart, tempEnd);

                //a lot of this is replacing character that will interfere with the csv file
                ingredients = ingredients.replace(",", "");
                ingredients = ingredients.replace("<b>", "");
                ingredients = ingredients.replace("<br>", "");
                ingredients = ingredients.replace("</br>", "");
                ingredients = ingredients.replace("</b>", "");
                ingredients = ingredients.replace("<i>", "");
                ingredients = ingredients.replace("</i>", "");
                ingredients = ingredients.replace("<li>", "");
                ingredients = ingredients.replace("</li>", "");
                ingredients = ingredients.replace("&#189;", " 1/2");
                ingredients = ingredients.replace("&#8531;", " 1/3");
                ingredients = ingredients.replace("&#8532;", " 2/3");
                ingredients = ingredients.replace("&#188;", " 1/4");
                ingredients = ingredients.replace("&#190;", " 3/4");
                ingredients = ingredients.replace("&#8533;", " 1/5");
                ingredients = ingredients.replace("&#8534;", " 2/5");
                ingredients = ingredients.replace("&#8535;", " 3/5");
                ingredients = ingredients.replace("&#8536;", " 4/5");
                ingredients = ingredients.replace("&#8537;", " 1/6");
                ingredients = ingredients.replace("&#8538;", " 5/6");
                ingredients = ingredients.replace("&#8528;", " 1/7");
                ingredients = ingredients.replace("&#8539;", " 1/8");
                ingredients = ingredients.replace("&#8540;", " 3/8");
                ingredients = ingredients.replace("&#8541;", " 5/8");
                ingredients = ingredients.replace("&#8529;", " 1/9");
                ingredients = ingredients.replace("&#8530;", " 1/10");
                ingredients = ingredients.replace("&#176;", " Degrees ");
                ingredients = ingredients.replace("&nbsp;", "tsp.");
                ingredients = ingredients.replace("&#8211;", "-");
                ingredients = ingredients.replace("<span style=\"font-size:12pt\">", "");
                ingredients = ingredients.replace("<strong><span style=\"font-size:12pt\">", "");
                ingredients = ingredients.replace("</span>", "");
                ingredients = ingredients.replace("</strong>", "");
                ingredients = ingredients.replace("<br />", "");
                ingredients = ingredients.replace("<div>", "");
                ingredients = ingredients.replace("\n", " ");
                ingredients = ingredients.replace("\r\n", " ");
                ingredients = ingredients.replace("\r", " ");

                ingredients += ",";
                newArray[i][4] = ingredients;

                navigate = tempBody.indexOf("recipe-details-procedure\">");
                tempStart = navigate + 26;
                tempEnd = tempBody.indexOf("</div>", tempStart);
                String instructions = tempBody.substring(tempStart, tempEnd);

                //a lot of this is replacing character that will interfere with the csv file
                instructions = instructions.replace("<i>", "");
                instructions = instructions.replace("</i>", "");
                instructions = instructions.replace("<b>", "");
                instructions = instructions.replace("</b>", "");
                instructions = instructions.replace("<br>", "");
                instructions = instructions.replace("\n", "");
                instructions = instructions.replace("\r\n", "");
                instructions = instructions.replace("\r", "");
                instructions = instructions.replace("&#8212;", "-");
                instructions = instructions.replace(",", "");
                instructions = instructions.replace("<span style=\"font-size:12pt\">", "");
                instructions = instructions.replace("<strong><span style=\"font-size:12pt\">", "");
                instructions = instructions.replace("</span>", "");
                instructions = instructions.replace("</strong>", "");
                instructions = instructions.replace("<br />", "");
                instructions = instructions.replace("<div>", "");
                instructions = instructions.replace("&#8217;", "'");
                instructions = instructions.replace("&#34;", "\"");
                instructions = instructions.replace("&#176;", " Degrees ");
                instructions = instructions.replace("&#189;", " 1/2");
                instructions = instructions.replace("&#8531;", " 1/3");
                instructions = instructions.replace("&#8532;", " 2/3");
                instructions = instructions.replace("&#188;", " 1/4");
                instructions = instructions.replace("&#190;", " 3/4");
                instructions = instructions.replace("&#8533;", " 1/5");
                instructions = instructions.replace("&#8534;", " 2/5");
                instructions = instructions.replace("&#8535;", " 3/5");
                instructions = instructions.replace("&#8536;", " 4/5");
                instructions = instructions.replace("&#8537;", " 1/6");
                instructions = instructions.replace("&#8538;", " 5/6");
                instructions = instructions.replace("&#8528;", " 1/7");
                instructions = instructions.replace("&#8539;", " 1/8");
                instructions = instructions.replace("&#8540;", " 3/8");
                instructions = instructions.replace("&#8541;", " 5/8");
                instructions = instructions.replace("&#8529;", " 1/9");
                instructions = instructions.replace("&#8530;", " 1/10");
                instructions = instructions.replace("&#8542;", " 7/8");

                instructions += "\n";
                newArray[i][5] = instructions;
                Thread.sleep(10000);//sleep the program si we dont DOS ourselves from the site

                begin = end;
            }
            startLoop +=24;
            reach += 24;

        }
//output to a file, so it's easy to mess with (you won’t be for your finished program)
        FileOutputStream fs = new FileOutputStream("output.csv");
        PrintWriter pw = new PrintWriter(fs);
        //iterating through the arrays contents and putting it into a csv file
        for (int i = 0; i < 96; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                pw.print(newArray[i][j]); //response.body() is the html source code in a string format. It outputs to a file so you can see it easier right now, but you will ultimately want to just manipulate the strings a lot
            }
        }
        pw.close();
    }
}
