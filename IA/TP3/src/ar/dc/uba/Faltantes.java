package ar.dc.uba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Faltantes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			String strategy = args[1];
			int percent = Integer.parseInt(args[2]);
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
					if (!str.equals("%"))
						data.add(str.split(","));
					else
						cantPercent++;
				if (str.equals("@data"))
					hayDatos = true;
				str = br.readLine();
			}
			int cantColumnas = data.get(0).length;


			// Calcula la Moda
			if (strategy.equals("moda")) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				List<String> moda = new LinkedList<String>();
				for (int i = 0; i < cantColumnas; i++) {
					for (String[] strings : data) {
						if (!strings[i].equals("?")) {
							if (map.containsKey(strings[i]))
								map.put(strings[i], map.get(strings[i])+1);
							else
								map.put(strings[i], 1);
						}
					}
					int cant = 0;
					String maxKey = "";
					for (String key : map.keySet()) {
						if (map.get(key) > cant) {
							cant = map.get(key);
							maxKey = key;
						}
					}
					moda.add(maxKey);
					map.clear();
				}
				Random rnd = new Random();
				for (String[] strings : data) {
					for (int i = 0; i < cantColumnas; i++) {
						if (percent > rnd.nextInt(100))
							System.out.print(moda.get(i));
						else
							if (strings[i].equals("?"))
								System.out.print(moda.get(i));
							else
								System.out.print(strings[i]);
						if (i+1 == cantColumnas)
							System.out.println("");
						else
							System.out.print(",");
					}
				}
				for (int i = 0; i < cantPercent; i++) {
					System.out.println("%");
				}
			} else if (strategy.equals("modaclase")) {
				Map<String, Map<String,Integer>> map = new HashMap<String, Map<String,Integer>>();
				Map<String,List<String>> moda = new HashMap<String, List<String>>();
				for (int i = 0; i < cantColumnas; i++) {
					for (String[] strings : data) {
						String clase = strings[cantColumnas-1];
						if (map.containsKey(clase)) {
							Map<String,Integer> mapaClase = map.get(clase);
							if (!strings[i].equals("?")) {
								if (mapaClase.containsKey(strings[i]))
									mapaClase.put(strings[i], mapaClase.get(strings[i])+1);
								else
									mapaClase.put(strings[i], 1);
							}
						} else {
							Map<String,Integer> mapaClase = new HashMap<String, Integer>();
							if (!strings[i].equals("?")) {
								mapaClase.put(strings[i], 1);
							}
							map.put(clase, mapaClase);
						}
					}

					for (String mapaKey : map.keySet()) {
						int cant = 0;
						String maxKey = "";
						Map<String,Integer> mapaClase = map.get(mapaKey);
						for (String key : mapaClase.keySet()) {
							if (mapaClase.get(key) > cant) {
								cant = mapaClase.get(key);
								maxKey = key;
							}
						}
						try {
							moda.get(mapaKey).add(maxKey);
						} catch (Exception e) {
							moda.put(mapaKey,new LinkedList<String>());
							moda.get(mapaKey).add(maxKey);
						}
					}
					for (String key : map.keySet()) {
						map.get(key).clear();
					}

				}
				Random rnd = new Random();
				for (String[] strings : data) {
					for (int i = 0; i < cantColumnas; i++) {
						if (percent > rnd.nextInt(100))
							System.out.print(moda.get(strings[cantColumnas-1]).get(i));
						else
							if (strings[i].equals("?"))
								System.out.print(moda.get(strings[cantColumnas-1]).get(i));
							else
								System.out.print(strings[i]);
						if (i+1 == cantColumnas)
							System.out.println("");
						else
							System.out.print(",");
					}
				}
				for (int i = 0; i < cantPercent; i++) {
					System.out.println("%");
				}
			} else {
				throw new Exception("Estrategia de moda inexistente");
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
