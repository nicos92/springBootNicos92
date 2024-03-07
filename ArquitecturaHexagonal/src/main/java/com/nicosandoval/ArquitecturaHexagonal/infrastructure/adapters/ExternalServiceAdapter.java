package com.nicosandoval.ArquitecturaHexagonal.infrastructure.adapters;

import com.nicosandoval.ArquitecturaHexagonal.domain.models.AdditionalTaskInfo;
import com.nicosandoval.ArquitecturaHexagonal.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> responseEntity = restTemplate.getForEntity(apiUrl,JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = responseEntity.getBody();
        if (todo == null){
            return null;
        }

        apiUrl = "https://jsonplaceholder-typiconde.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser jsonPlaceHolderUser = userResponse.getBody();
        if (jsonPlaceHolderUser == null){
            return null;
        }

        return new AdditionalTaskInfo(jsonPlaceHolderUser.getId(), jsonPlaceHolderUser.getName(), jsonPlaceHolderUser.getEmail());
    }

    //https://jsonplaceholder.typicode.com/todos/
    //https://jsonplaceholder-typiconde.com/users/

    @Getter @Setter
    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;
    }


    @Getter @Setter
    private static class JsonPlaceHolderUser{
        private Long id;
        private String name;
        private String email;
    }

}
