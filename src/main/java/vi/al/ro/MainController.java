package vi.al.ro;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final static String KEY = "counter";

    private final StringRedisTemplate stringRedisTemplate;

    public MainController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * Считает кол-во соединений
     * Складывает их в Redis, выдаёт их в ответе
     * @return количество соединений
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> roundRobin() {

        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();

        if (value.get(KEY) == null) {
            value.set(KEY, String.valueOf(0));
        }
        value.increment(KEY);

        String val = value.get(KEY);
        if (val == null) {
            return ResponseEntity.status(HttpStatus.OK).body("null");
        }
        return ResponseEntity.status(HttpStatus.OK).body("new value == " + val);
    }
}
