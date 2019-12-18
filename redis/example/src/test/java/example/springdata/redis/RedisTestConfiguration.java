package example.springdata.redis;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author Christoph Strobl
 */
@SpringBootApplication
public class RedisTestConfiguration {

	@Autowired RedisConnectionFactory factory;

	/**
	 * Clear database before shut down.
	 */
	public @PreDestroy void flushTestDb() {
		factory.getConnection().flushDb();
	}
}
