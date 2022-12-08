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

	static void minue() {

		System.out.println("************************************");
		System.out.println(" 1- print and save API information  ");
		System.out.println(" 2- saveing API information in txt file  ");
		System.out.println(" 3- saveing API information in PDF file  ");
		System.out.println(" 0 - Exit  ");
		System.out.println("************************************");

	}

	static void onRead() throws Exception, Throwable {

		HttpClient client = HttpClient.newHttpClient();

		System.out.println(" printing (API) information  ");

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io/161.185.160.39/geo")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

	}

	static void onWriteToTxt() throws Throwable, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io/161.185.160.39/geo")).build();

		/* write json in file */
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("API data saved in txt file name:'evaluationFileTxt'");
		System.out.println("___________________________________________________");

		String path = "C:\\Users\\user002\\eclipse-workspace\\saidevaluation\\" + "evaluationFileTxt.txt";

		try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
			System.out.println("___________________________________");

			out.write(response.body());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void onWriteToPdf() throws Throwable, Exception {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://ipinfo.io/161.185.160.39/geo")).build();

		/* write json in file */
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("API data saved in pdf file name:'evaluationFilePdf'");
		System.out.println("___________________________________________________");

		String path = "C:\\Users\\user002\\eclipse-workspace\\saidevaluation\\" + "evaluationFilePdf.pdf";

		try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
			System.out.println("___________________________________");

			out.write(response.body());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void wroungOption() {
		System.out.println("Wroung option!!!!!!!! please Enter correct option");
	}

	static void exitMassege() {

		System.out.println("Good Bay & See You Agin");

	}

	public static void main(String[] args) throws Exception, Throwable {

		Scanner sc = new Scanner(System.in);

		boolean exit = true;

		while (exit) {

			minue();

			int option = sc.nextInt();

			switch (option) {

			case 1:

				onRead();

				break;

			case 2:

				onWriteToTxt();

				break;

			case 3:
				onWriteToPdf();
				break;

			case 0:
				exitMassege();
				exit = false;

				break;

			default:

				wroungOption();

			}

		}

	}
}
