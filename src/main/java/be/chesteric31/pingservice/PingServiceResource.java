package be.chesteric31.pingservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController public class PingServiceResource {

    private final RestTemplate restTemplate;

    public PingServiceResource(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> getPing() {
        String pong = this.restTemplate.getForEntity("http://PONG-SERVICE/pong", String.class).getBody();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Ping" + " - " + pong);
    }
}
