package evaluationSaid;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class EvaluationWrite {

	public static void main(String[] args) throws IOException, Throwable {

		Scanner sc = new Scanner(System.in);
		HttpClient client = HttpClient.newHttpClient();

		boolean exit = true;

		while (exit) {
    
			System.out.println(" 1- print API information  ");
			int option = sc.nextInt();

			switch (option) {
			case 1:

				HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io/161.185.160.39/geo"))
						.build();

				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				System.out.println(response.body());

				/* write json in file */
				String path = "C:\\Users\\user002\\eclipse-workspace\\saidevaluation\\" + "evaluationFile.txt";

				try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

					out.write(response.body());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			break;

		}
	}

}
