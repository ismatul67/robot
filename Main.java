import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String command;
		try{

        while (true) {
        String lastPosition = FileUtility.read();
			
		System.out.println("Posisi terakhir : " + lastPosition);
        System.out.print("Masukan perintah (F/B/R/L/C untuk reset): ");
		command = br.readLine();
			String[] commands = command.split("");
	       String[] robotInfo=lastPosition.split(":");
	       String [] position = robotInfo[0].split(",");
	       String direction = robotInfo[1];
	       
	        Robotku robot = new Robotku(Integer.parseInt(position[0]),Integer.parseInt(position[1]) , Direction.valueOf(direction));
            robot.runCommand(commands);

        }
		}catch(IOException e) 
		{
			System.out.println(e.getMessage());
    	}catch(Exception e){
            System.out.println("Perintah salah!");
        }
    
    }
    
}
