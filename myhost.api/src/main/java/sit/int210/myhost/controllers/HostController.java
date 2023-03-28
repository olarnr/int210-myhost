package sit.int210.myhost.controllers;

import sit.int210.myhost.services.HostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://lvmolarn.sit.kmutt.ac.th:3000")
@RestController
@RequestMapping("/api/host")
public class HostController {
    private final HostService service;

    @Autowired
    public HostController(HostService service) {
        this.service = service;
    } 

    @GetMapping("/hostname")
    @ResponseBody
    public String getHostname() {
        return service.getHostname();
    }
}
