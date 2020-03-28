package com.example.demo.controller;
import com.example.demo.annotations.ApiPageable;
import com.example.demo.dto.ClientDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @ApiPageable
    @GetMapping
    public Slice<ClientDto> findClients(@ApiIgnore Pageable pageable){
        return clientService.findClients(pageable);
    }
    @GetMapping("/{clientId}")
    public ClientDto getClient(@PathVariable String clientId) {
        return clientService.findOne(clientId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto addClient(@RequestBody ClientDto clientDTO) {
        return clientService.addClient(clientDTO);
    }

}