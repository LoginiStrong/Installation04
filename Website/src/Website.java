import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;

public class Website {

    public static void main(String[] args) throws IOException, InterruptedException {

        String[][] newArray = new String[96][6];

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=0&sz=24")) //starting URL…
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());






        String body = response.body();
        int begin = 0;

        for (int i = 0; i < 24; i++)
        {
            int start = body.indexOf("\"thumb-link\" href=\"", begin);
            int end = body.indexOf("\" title", start);
            System.out.println(start);
            System.out.println(end);
            start = start + 19;
            String link = body.substring(start, end);

            HttpRequest newRequest = HttpRequest.newBuilder()
                    .uri(URI.create(link)) //starting URL…
                    .GET() // GET is default
                    .build();
            HttpResponse<String> newResponse = client.send(newRequest,
                    HttpResponse.BodyHandlers.ofString());
            String tempBody = newResponse.body();

            int tempStart = 0;
            int tempEnd;

            //This code gets the path
            String path = "";
            String title = "";
            for (int j = 0; j < 5; j++)
            {
                int navigate = tempBody.indexOf("breadcrumb-element", tempStart);
                tempStart = tempBody.indexOf(">", navigate);
                tempEnd = tempBody.indexOf("<", tempStart);
                path += tempBody.substring(tempStart + 1, tempEnd);
                path += "/";
                if (j == 4)
                {
                    title = (tempBody.substring(tempStart + 1, tempEnd));
                    title = title.replace(",","");
                    title = title.replace("\n","");
                    path = path.replace("\n","");
                    title += ",";
                }

            }
            newArray[i][2] = title;
            path = path.replace("\n","");
            path +=",";
            newArray[i][1] = path;
            System.out.println(path);

            //This code gets the author
            int navigate = tempBody.indexOf("recipe-author");
            tempStart = tempBody.indexOf("By", navigate);
            tempEnd = tempBody.indexOf("\n", tempStart);
            String author = tempBody.substring(tempStart, tempEnd);
            author = author.replace(",", "");
            author += ",";
            System.out.println(author);
            newArray[i][0] = author;
            System.out.println(title);


            String servings = "";
            tempStart = tempBody.indexOf("Makes", navigate);
            if (tempStart == -1)
            {
                servings = "Not specified,";
            }
            else
            {
                tempEnd = tempBody.indexOf("\n", tempStart);
                servings = tempBody.substring(tempStart, tempEnd);
                servings = servings.replace(",","");
                servings = servings.replace("\n","");
                servings += ",";
            }
            System.out.println(servings);
            newArray[i][3] = servings;


            navigate = tempBody.indexOf("recipe-details-ingredients");
            tempStart = tempBody.indexOf("<li>", navigate);
            tempEnd = tempBody.indexOf("</ul", navigate);
            String ingredients = tempBody.substring(tempStart, tempEnd);
            ingredients = ingredients.replace(",","");
            ingredients = ingredients.replace("<li>","");
            ingredients = ingredients.replace("</li>","");
            ingredients = ingredients.replace("&#189;","½");
            ingredients = ingredients.replace("&#8531;","⅓");
            ingredients = ingredients.replace("&#8532;","⅔");
            ingredients = ingredients.replace("&#188;","¼");
            ingredients = ingredients.replace("&#190;","¾");
            ingredients = ingredients.replace("&#8533;","⅕");
            ingredients = ingredients.replace("&#8534;","⅖");
            ingredients = ingredients.replace("&#8535;","⅗");
            ingredients = ingredients.replace("&#8536;","⅘");
            ingredients = ingredients.replace("&#8537;","⅙");
            ingredients = ingredients.replace("&#8538;","⅚");
            ingredients = ingredients.replace("&#8528;","⅐");
            ingredients = ingredients.replace("&#8533;","⅕");
            ingredients = ingredients.replace("&#8539;","⅛");
            ingredients = ingredients.replace("&#8540;","⅜");
            ingredients = ingredients.replace("&#8541;","⅝");
            ingredients = ingredients.replace("&#8529;","⅑");
            ingredients = ingredients.replace("&#8530;","⅒");
            ingredients = ingredients.replace("<span style=\"font-size:12pt\">","");
            ingredients = ingredients.replace("<strong><span style=\"font-size:12pt\">","");
            ingredients = ingredients.replace("</span>","");
            ingredients = ingredients.replace("</strong>","");
            ingredients = ingredients.replace("<br />","");
            ingredients = ingredients.replace("<div>","");
            ingredients = ingredients.replace("\n"," ");

            ingredients += ",";
            System.out.println(ingredients);
            newArray[i][4] = ingredients;


            navigate = tempBody.indexOf("recipe-details-procedure\">");
            tempStart = navigate +26;
            tempEnd = tempBody.indexOf("</div>", tempStart);
            String instructions = tempBody.substring(tempStart, tempEnd);
            instructions = instructions.replace("<i>", "");
            instructions = instructions.replace("</i>", "");
            instructions = instructions.replace("<b>", "");
            instructions = instructions.replace("</b>", "");
            instructions = instructions.replace("<br>", "");
            instructions = instructions.replace("\n", "");
            instructions = instructions.replace("&#8212;", "-");
            instructions = instructions.replace(",","");
            instructions = instructions.replace("<span style=\"font-size:12pt\">","");
            instructions = instructions.replace("<strong><span style=\"font-size:12pt\">","");
            instructions = instructions.replace("</span>","");
            instructions = instructions.replace("</strong>","");
            instructions = instructions.replace("<br />","");
            instructions = instructions.replace("<div>","");



            /*instructions = instructions.replace("&#189;","½");
            instructions = instructions.replace("&#8531;","⅓");
            instructions = instructions.replace("&#8532;","⅔");
            instructions = instructions.replace("&#188;","¼");
            instructions = instructions.replace("&#190;","¾");
            instructions = instructions.replace("&#8533;","⅕");
            instructions = instructions.replace("&#8534;","⅖");
            instructions = instructions.replace("&#8535;","⅗");
            instructions = instructions.replace("&#8536;","⅘");
            instructions = instructions.replace("&#8537;","⅙");
            instructions = instructions.replace("&#8538;","⅚");
            instructions = instructions.replace("&#8528;","⅐");
            instructions = instructions.replace("&#8533;","⅕");
            instructions = instructions.replace("&#8539;","⅛");
            instructions = instructions.replace("&#8540;","⅜");
            instructions = instructions.replace("&#8541;","⅝");
            instructions = instructions.replace("&#8529;","⅑");
            instructions = instructions.replace("&#8530;","⅒");
            instructions = instructions.replace("&#8542;","⅞");*/

            instructions += "\n";
            newArray[i][5] = instructions;
            System.out.println(instructions);


            Thread.sleep(15000);



            begin = end;
        }


//output to a file, so it's easy to mess with (you won’t be for your finished program)
        FileOutputStream fs = new FileOutputStream("output.csv");
        PrintWriter pw = new PrintWriter(fs);
        for (int i = 0; i < 24; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                pw.print(newArray[i][j]); //response.body() is the html source code in a string format. It outputs to a file so you can see it easier right now, but you will ultimately want to just manipulate the strings a lot
            }
        }
        pw.close();
    }
}
