package sit.int210.myhost.services;

import sit.int210.myhost.utils.ProcessManager;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class HostService {
    private final String platform = System.getProperty("os.name");
    
    public String getHostname() {
        Map<String, String> cmdMap = Map.of("Linux","hostname -a","Mac OS X","hostname -f","Windows","hostname");
        ProcessManager pm = new ProcessManager(cmdMap.get(platform));

        if (pm.executeCommand() == 0) {
            return pm.getOut();
        } else
            return "Error getting the hostname";
    }
}
