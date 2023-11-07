package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static final int PUERTO = 2022;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		InputStreamReader entrada = null;
		PrintStream salida = null;

		Socket socketAlCliente = null;

		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		
		try (ServerSocket serverSocket = new ServerSocket()) {
			serverSocket.bind(direccion);
			int peticion = 0;
			while (true) {

				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");

				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split(";");
				int opcion = Integer.parseInt(operadores[0]);
				String[] numeros = operadores[1].split("-");
				double iNumero1 = Double.parseDouble(numeros[0]);
				double iNumero2 = Double.parseDouble(numeros[1]);
				double resultado;
				
				switch (opcion) {
				case 1:
					resultado = iNumero1 + iNumero2;
					System.out.println("SERVIDOR: La suma de los numeros es: " + resultado);
					salida = new PrintStream(socketAlCliente.getOutputStream());
					salida.println(resultado);
					socketAlCliente.close();
					break;
				case 2:
					resultado = iNumero1 - iNumero2;
					System.out.println("SERVIDOR: La resta de los numeros es: " + resultado);
					salida = new PrintStream(socketAlCliente.getOutputStream());
					salida.println(resultado);
					socketAlCliente.close();
					break;
				case 3:
					resultado = iNumero1 * iNumero2;
					System.out.println("SERVIDOR: La multiplicación de los numeros es: " + resultado);
					salida = new PrintStream(socketAlCliente.getOutputStream());
					salida.println(resultado);
					socketAlCliente.close();
					break;
				case 4:
					resultado = iNumero1 / iNumero2;
					System.out.println("SERVIDOR: La división de los numeros es: " + resultado);
					salida = new PrintStream(socketAlCliente.getOutputStream());
					salida.println(resultado);
					socketAlCliente.close();
					break;
				default:
					socketAlCliente.close();
					break;
				}

			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}
}
