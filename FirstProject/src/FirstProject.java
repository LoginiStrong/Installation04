import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;

public class FirstProject {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.surlatable.com/recipes/?srule=best-matches&start=0&sz=24")) //starting URL…
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());




        String body = response.body();
        int begin = 0;

        for (int i = 0; i < 1; i++)
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

            String path = "";
            int tempStart = 0;
            for (int j = 0; j < 5; j++)
            {
                int navigate = tempBody.indexOf("breadcrumb-element", tempStart);
                tempStart = tempBody.indexOf(">", navigate);
                int tempEnd = tempBody.indexOf("<", tempStart);
                path += tempBody.substring(tempStart + 1, tempEnd);
                path += "/";

                navigate = tempEnd;
            }
            System.out.println(path);

            begin = end;
        }


//output to a file, so it's easy to mess with (you won’t be for your finished program)
        FileOutputStream fs = new FileOutputStream("output.csv");
        PrintWriter pw = new PrintWriter(fs);
        pw.println(response.body()); //response.body() is the html source code in a string format. It outputs to a file so you can see it easier right now, but you will ultimately want to just manipulate the strings a lot
        pw.close();
    }
}

