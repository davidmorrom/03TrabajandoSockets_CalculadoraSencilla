package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketCliente {

	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "192.168.22.136";

	public static void main(String[] args) {
		System.out.println("        APLICACI�N CLIENTE         ");
		System.out.println("-----------------------------------");
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		Socket socketAlServidor;
		String numero1;
		String numero2;
		String operandos;
		PrintStream salida;
		InputStreamReader entrada;
		BufferedReader bf;
		String resultado;
		boolean cerramos = true;
		try (Scanner sc = new Scanner(System.in)) {
			while (cerramos) {
				int opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					socketAlServidor = new Socket();
					System.out.println("CLIENTE: Introduzca los numeros a sumar");
					numero1 = sc.nextLine();
					numero2 = sc.nextLine();
					operandos = opcion + ";" + numero1 + "-" + numero2;
					System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
					socketAlServidor.connect(direccionServidor);
					System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

					salida = new PrintStream(socketAlServidor.getOutputStream());
					salida.println(operandos);
					entrada = new InputStreamReader(socketAlServidor.getInputStream());
					bf = new BufferedReader(entrada);
					System.out.println("CLIENTE: Esperando al resultado del servidor...");
					resultado = bf.readLine();
					System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
					break;
				case 2:
					socketAlServidor = new Socket();
					System.out.println("CLIENTE: Introduzca los numeros a restar");
					numero1 = sc.nextLine();
					numero2 = sc.nextLine();
					operandos = opcion + ";" + numero1 + "-" + numero2;
					System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
					socketAlServidor.connect(direccionServidor);
					System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

					salida = new PrintStream(socketAlServidor.getOutputStream());
					salida.println(operandos);
					entrada = new InputStreamReader(socketAlServidor.getInputStream());
					bf = new BufferedReader(entrada);
					System.out.println("CLIENTE: Esperando al resultado del servidor...");
					resultado = bf.readLine();
					System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
					break;
				case 3:
					socketAlServidor = new Socket();
					System.out.println("CLIENTE: Introduzca los numeros a multiplicar");
					numero1 = sc.nextLine();
					numero2 = sc.nextLine();
					operandos = opcion + ";" + numero1 + "-" + numero2;
					System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
					socketAlServidor.connect(direccionServidor);
					System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

					salida = new PrintStream(socketAlServidor.getOutputStream());
					salida.println(operandos);
					entrada = new InputStreamReader(socketAlServidor.getInputStream());
					bf = new BufferedReader(entrada);
					System.out.println("CLIENTE: Esperando al resultado del servidor...");
					resultado = bf.readLine();
					System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
					break;
				case 4:
					socketAlServidor = new Socket();
					System.out.println("CLIENTE: Introduzca los numeros a dividir");
					numero1 = sc.nextLine();
					numero2 = sc.nextLine();
					operandos = opcion + ";" + numero1 + "-" + numero2;
					System.out.println("CLIENTE: Esperando a que el servidor acepte la conexi�n");
					socketAlServidor.connect(direccionServidor);
					System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

					salida = new PrintStream(socketAlServidor.getOutputStream());
					salida.println(operandos);
					entrada = new InputStreamReader(socketAlServidor.getInputStream());
					bf = new BufferedReader(entrada);
					System.out.println("CLIENTE: Esperando al resultado del servidor...");
					resultado = bf.readLine();
					System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
					break;
				case 5:
					System.out.println("CLIENTE: Fin del programa");
					cerramos = false;
					break;

				}
			}
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
	}

}
