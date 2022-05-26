import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Scanner;

public class ProgramaClient {
    static Scanner lector = new Scanner(System.in);
	public static void programa_Client(Connection connexioPsql) throws Exception{
		// TODO Auto-generated method stub

        oClient client = new oClient();

		oFactura factura = new oFactura();
		LocalDate data = LocalDate.now();
		int randomNum = (int) (Math.random() * ( 9999 - 1001 ));
		factura.oFactura(randomNum,client,data);

		boolean menu = false;
		boolean login = false;
		int opcioMenu = 0;
		
        comprarProductes(login,client,connexioPsql);
    }
    public static void comprarProductes(boolean login, oClient client, Connection connexioPsql) throws Exception{
		if(login){
			menuClient(client,connexioPsql);
		}
		else menuNoClient(connexioPsql);
	}
	public static void menuNoClient(Connection connexioPsql) throws Exception 
	{
		boolean menuNoClient = false;
		int codiProducte = 0;
		int quantitatProducte = 0;
		do {
			boolean comprovacioInt = false;
		
			do {
				System.out.println("|--------------------------------------------------------|");
				System.out.println("|                    Compra Productes:                   |");
				System.out.println("|--------------------------------------------------------|");
				System.out.println("|          Entra el codi del producte que desitges       |");
				System.out.println("|             (Si desitges sortir entra un 0)            |");
				System.out.println("|--------------------------------------------------------|");
				if(lector.hasNextInt()){
					codiProducte = lector.nextInt();
					lector.nextLine();
					comprovacioInt = true;
				}
				else {
					System.out.println("|    Aquesta opcio no es correcte, torna a provar.       |");
					lector.nextLine();
				}
			} while (!comprovacioInt);
			if(oProducte.comprovaExistenciaProdu(codiProducte, connexioPsql) == 0){
				
				boolean comprovacioInt2 = false;
				
				do {
					System.out.println("|--------------------------------------------------------|");
					System.out.println("|             Entra la quantitat que desitges            |");
					System.out.println("|--------------------------------------------------------|");
					if(lector.hasNextInt()){
						quantitatProducte= lector.nextInt();
						lector.nextLine();
						comprovacioInt2 = true;
					}
					else {
						System.out.println("|    Aquesta opcio no es correcte, torna a provar.       |");
						lector.nextLine();
					}
				} while (!comprovacioInt2);

			}
			else if(oProducte.comprovaExistenciaProdu(codiProducte, connexioPsql) == 1){
				System.out.println("|    Aquesta opcio no existeix, torna a provar.       |");
			}
			else{
				System.out.println("|    Gracies per visitar la pagina, Pasi un bon dia.     |");
				menuNoClient = true;
			}
				
		} while (!menuNoClient);	
	}
	public static void menuClient(oClient client, Connection connexioPsql)
	{

	}	
	public oClient ferRegister() 
	{
		return null;
	}
	public static oClient ferLogIn(Connection connexioPsql) 
	{
		return null;
	}
}
