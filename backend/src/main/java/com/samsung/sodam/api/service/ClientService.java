package com.samsung.sodam.api.service;

<<<<<<< HEAD
import com.samsung.sodam.api.request.ClientRequest;
import com.samsung.sodam.api.response.ClientListResponse;
import com.samsung.sodam.db.entity.Client;
=======
import com.samsung.sodam.api.response.ClientListResponse;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
<<<<<<< HEAD
    Page<ClientListResponse> getMyClients(String counselorId,Pageable pageable);
    public Client getClientDetail(String id);

    void editProfile(ClientRequest request, String id);
=======
    Page<ClientListResponse> getMyClients(String counselorId, String name, Pageable pageable);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
