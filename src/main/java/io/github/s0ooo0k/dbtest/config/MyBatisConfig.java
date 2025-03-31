package io.github.s0ooo0k.dbtest.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * MyBatis 설정 클래스 (Spring 없이 사용하는 방식)
 * 역할: DB 설정 정보를 읽고, SqlSessionFactory를 생성하여 어플리케이션 전역에서 사용
 */
public class MyBatisConfig {
    // 싱글톤 형태로 사용할 SqlSessionFactory
    private static final SqlSessionFactory sqlSessionFactory;

    // 로깅 용도
    private static final Logger logger = Logger.getLogger(MyBatisConfig.class.getName());

    // static 블록: 클래스가 처음 로딩될 때 실행됨
    static {
        // 1. .env 파일 로드
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // 2. DB 접속 정보를 Properties 객체로 정리
        Properties properties = new Properties();
        properties.setProperty("DB_DRIVER", dotenv.get("DB_DRIVER"));
        properties.setProperty("DB_URL", dotenv.get("DB_URL"));
        properties.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        properties.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        //  3. MyBatis 설정 파일 경로 지정
        String resource = "mybatis-config.xml";

        try (
                // 4. 설정 파일을 InputStream으로 불러옴
                InputStream inputStream = MyBatisConfig.class.getClassLoader().getResourceAsStream(resource)
        ) {
            // 5. SqlSessionFactory 생성 (설정 파일 + DB 속성)
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
        } catch (IOException e) {
            // 설정 파일 못 찾거나 연결 실패 시 예외 발생
            throw new RuntimeException(e);
        }

        logger.info("config 완료");
    }

    // 6. 외부에서 세션 팩토리를 사용할 수 있도록 제공
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
