package evaluationSaid;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WriteAndRead {
	
	
	
	
	static void onWrite() throws Exception, Throwable {
		
		HttpClient client = HttpClient.newHttpClient();

		System.out.println(" printing (API) information  ");

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io/161.185.160.39/geo"))
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

		/* write json in file */
		String path = "C:\\Users\\user002\\eclipse-workspace\\saidevaluation\\" + "evaluationFile.txt";

		try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
			System.out.println("___________________________________");

			out.write(response.body());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception, Throwable   {
		
		Scanner sc = new Scanner(System.in);

		boolean exit = true;

		do {
			System.out.println("************************************");
			System.out.println(" 1- print and save API information  ");
			System.out.println("************************************");

			int option = sc.nextInt();

			switch (option) {
			
			
			case 1:

				onWrite();
				System.out.println("API data saved in txt file");
				System.out.println("___________________________________");


			break;
			   
		 default: 
			 
				System.out.println("Wroung option!!!!!!!! please Enter correct option");

	}

} while (exit = true);

	
}
}
	

		
		
		
			
		
		
		
		
		
