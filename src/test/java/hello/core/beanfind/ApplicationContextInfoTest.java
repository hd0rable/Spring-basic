package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = ac.getBean(beanName);
            System.out.println("name = " + beanName + " object = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이 빈 출력하기")
    public void findApplicationBean() {
        String[] beanNames = ac.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName); //빈에 대한 메타데이터 정보

            // ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
            // ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanName);
                System.out.println("name = " + beanName + " object = " + bean);
            }
        }
    }
}
