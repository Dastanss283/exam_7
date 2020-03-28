package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ClientDto addClient(ClientDto clientDTO) {
        var client = Client.builder()
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .build();

        clientRepository.save(client);
        return ClientDto.from(client);
    }

    public Slice<ClientDto> findClients(Pageable pageable) {
        var slice = clientRepository.findAll(pageable);
        return slice.map(ClientDto::from);
    }
    public ClientDto findOne(String clientId) {
        var movie = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find client with the ID: " + clientId));
        return ClientDto.from(movie);
    }
}
