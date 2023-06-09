package sit.int210.myhost.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.Getter;
import lombok.Setter;

public class ProcessManager {
    @Getter @Setter private String command = "";
    @Getter private String out = "";

    public ProcessManager(String command){
        this.command = command;
    }

    public int executeCommand(){
    // The method returns exit value from executing the process, 0 = normal
        if ((this.command != null) && !this.command.isEmpty()) {
            try {
                Process process = Runtime.getRuntime().exec(this.command);
                StringBuilder output = new StringBuilder();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
    
                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    this.out = output.toString();
                } else {
                    System.out.printf("Problem executing '%s', exit value = %d%n", this.command, exitVal);
			    }
                return exitVal;

            } catch (IOException e) {
                e.printStackTrace();
                return 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 2;
            }
        } else return 3;
    }
}
