package com.example.pharmacyrecommendationproject

import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import spock.lang.Specification

@SpringBootTest
abstract class AbstractIntegrationContainerBaseTest extends Specification {
    // 싱글턴 테스트컨테이너 생성
    // 레디스 - 제네릭 컨테이너를 활용
    static final GenericContainer MY_REDIS_CONTAINER

    static {
        MY_REDIS_CONTAINER = new GenericContainer<>("redis:6")
            .withExposedPorts(6379) // 컨테이너를 생성할 때 사용할 port를 지정

        MY_REDIS_CONTAINER.start()

        // 생성된 Redis 컨테이너의 host와 port를 Property로 설
        System.setProperty("spring.redis.host", MY_REDIS_CONTAINER.getHost())
        System.setProperty("spring.redis.port", MY_REDIS_CONTAINER.getMappedPort(6379).toString())

    }
}
