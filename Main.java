import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		String command;
		try{
        do {
		String lastPosition = FileUtility.read();
		System.out.println("Last Position: " + lastPosition);
        System.out.print("Input command (F/B/R/L/C/stop): ");
		command = br.readLine();

		if (command.equals("stop")) {
			s.close();
			br.close();
			System.out.println("Robbot has been stoped!");
		}else{
			String[] commands = command.split("");
			String[] robotInfo=lastPosition.split(":");
			String [] position = robotInfo[0].split(",");
			String direction = robotInfo[1];
			
			 Robotku robot = new Robotku(Integer.parseInt(position[0]),Integer.parseInt(position[1]) , Direction.valueOf(direction));
			 robot.runCommand(commands);
		}
			
        }while (!command.equals("stop"));
		}catch(IOException e) 
		{
			System.out.println(e.getMessage());
    	}catch(Exception e){
            System.out.println("Failed command!");
        }
    
    }
    
}
