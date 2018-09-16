package vi.al.ro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MainController {

    private static AtomicInteger i = new AtomicInteger(0);

    @RequestMapping(value = "/round-robin", method = RequestMethod.GET, produces = "text/plain")
    public void roundRobin() {
        i.incrementAndGet();
    }

    @RequestMapping(value = "/round-robin/stat", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> roundRobinStat() {
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(i.get()));
    }

    @RequestMapping(value = "/hash", method = RequestMethod.GET, produces = "text/plain")
    public void hash() {
        i.incrementAndGet();
    }


    @RequestMapping(value = "/hash/stat", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> hashStat() {
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(i.get()));
    }

}
