package ma.emsi.taskservice.clients;

import ma.emsi.taskservice.entities.UserProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "userservice", url = "http://localhost:8082/")
public interface UsersClient {

    @PostMapping("/api/users/by-ids")
    List<UserProxy> getUsersByIds(@RequestBody List<Long> userIds);

}
