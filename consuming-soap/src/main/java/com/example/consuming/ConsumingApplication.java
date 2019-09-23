package com.example.consuming;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import smile.classification.RandomForest;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;
import smile.validation.LOOCV;

@SpringBootApplication
public class ConsumingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// NumberClient numberClient = new NumberClient();

		// create and setup marshaller
		// Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		// provide location to the ObjectFacory
		// marshaller.setContextPath("com.dataaccess.webservicesserver");

		// add marshaller to the client
		// numberClient.setMarshaller(marshaller);
		// numberClient.setUnmarshaller(marshaller);

		// retrieve the word format of the number
		// NumberToWordsResponse response = numberClient.getWords("3454");

		// print to screen
		// System.out.println("Response is: " + response.getNumberToWordsResult());

		// Random Forest classification training
		String fileName = "/Users/rchint1/Downloads/appeasement_1.arff";
		ArffParser arffParser = new ArffParser();
		arffParser.setResponseIndex(17);
		AttributeDataset member = arffParser.parse(new File(fileName));

		double[][] x = member.toArray(new double[member.size()][]);
		int[] y = member.toArray(new int[member.size()]);

		RandomForest randomForest = new RandomForest(member.attributes(), x, y, 300);

		int n = x.length;
		LOOCV loocv = new LOOCV(n);
		int error = 0;
		for (int i = 0; i < x.length; i++) {
			double predictedY = randomForest.predict(x[i]);
			System.out.println(i + " - Predicted : " + predictedY + " - " + "Actual: " + y[i]);
			if (y[loocv.test[i]] != randomForest.predict(x[loocv.test[i]])) {
				error++;
			}
		}

		System.out.println("Random Decision Tree error = " + 100.0 * error / x.length);

		double[][] actualmember = {
				{ 10142100894929850.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0 },
				{ 10142100894929850.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0 },
				{ 10142100894929850.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0 },
				{ 10101100627742936.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 }

		};
		Integer[] discounts = { 15, 25, 30, 45 };
		for (int i = 0; i < actualmember.length; i++) {
			double predict = randomForest.predict(actualmember[i]);
			String msg = "";
			if (predict == 1.0) {
				msg = "accept";
			} else {
				msg = "not accept";
			}
			System.out.println("for 10142100894929850, if we give " + discounts[i] + " dollar discount then user will "
					+ msg + " >>> " + predict);
			if (predict == 1.0)
				break;
		}
	}

}
