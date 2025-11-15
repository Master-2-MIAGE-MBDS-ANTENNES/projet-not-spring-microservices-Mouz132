package ma.emsi.taskservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.emsi.taskservice.entities.UserProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "userservice", url = "http://localhost:8082/")
public interface UsersClient {

    @PostMapping("/api/users/by-ids")
    @CircuitBreaker(name = "users", fallbackMethod = "getDefaultUsers")
    List<UserProxy> getUsersByIds(@RequestBody List<Long> userIds);

    default List<UserProxy> getDefaultUsers(List<Long> userIds, Exception exception) {
        return Collections.emptyList();
    }

}
