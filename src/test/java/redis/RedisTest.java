package redis;

import com.ssm.chapter14.pojo.Role;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
    @Test
    public void test1() {
        JedisPoolConfig cfg = new JedisPoolConfig();
        cfg.setMaxIdle(50);
        cfg.setMaxTotal(100);
        cfg.setMaxWaitMillis(20000);
        JedisPool pool = new JedisPool(cfg, "localhost");
        int i = 0;
        try (Jedis jedis = pool.getResource()) {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        }
        System.out.println("redis 每秒操作: " + i + " 次");
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(8L);
        role.setRoleName("Roger");
        role.setNote("note for Roger");
        redisTemplate.opsForValue().set("role_1", role);
        Role role1 = (Role) redisTemplate.opsForValue().get("role_1");
        System.out.println(role1.getRoleName());
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(2L);
        role.setRoleName("Two");
        role.setNote("note_two");
        SessionCallback callback = new SessionCallback() {
            @Override
            public Role execute(RedisOperations operations) throws DataAccessException {
                operations.boundValueOps("role_2").set(role);
                return (Role) operations.boundValueOps("role_2").get();
            }
        };

        Role savedRole = (Role) redisTemplate.execute(callback);
        assert savedRole != null;
        System.out.println(savedRole.getId());
    }
}
