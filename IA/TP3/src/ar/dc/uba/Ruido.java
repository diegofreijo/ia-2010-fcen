package ar.dc.uba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Ruido {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			double percent = Double.parseDouble(args[1]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			boolean hayDatos = false;
			int cantPercent = 0;
			List<String[]> data = new LinkedList<String[]>();
			// Levanta los datos
			while (str != null) {
				if (!hayDatos)
					System.out.println(str);
				else
					if (!str.equals("%") && !str.trim().equals(""))
						data.add(str.split(","));
					else
						if (str.equals("%")) cantPercent++;
				if (str.equals("@data"))
					hayDatos = true;
				str = br.readLine();
			}
			int cantColumnas = data.get(0).length;


			Random rnd = new Random();
			for (String[] strings : data) {
				for (int i = 0; i < cantColumnas; i++) {
					//double noise = 1;
					double noise =  percent/100  * (rnd.nextDouble()-0.5) + 1.0;

					if (i+1 == cantColumnas) {
						System.out.print(strings[i]);
						System.out.println("");
					} else {
						System.out.format("%.2f",noise * Double.parseDouble(strings[i]));
						System.out.print(";");
					}
				}
			}
			for (int i = 0; i < cantPercent; i++) {
				System.out.println("%");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
