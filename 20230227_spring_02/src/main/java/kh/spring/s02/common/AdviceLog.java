package kh.spring.s02.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AdviceLog {
	// * 1개이상이 존재함. 
	// .. 0개이상이 존재
	@Pointcut("execution(public * kh.spring.s02..*Controller.*(..))")
	public void controllerPointCut() {}
	// 위 pointcut의 이름은  "controllerPointCut()"
	
	@Pointcut("execution(public * kh.spring.s02..*Dao.*(..))")
	public void DaoPointCut() {}
	
	
	@Before("controllerPointCut()")
	public void beforeControllerPointCut(JoinPoint jp) {
		
		System.out.println("컨트롤러 모든 메소드가 호출되면 해당메소드(타겟메소드)가 실행되기 "
				+ " 전 Before 바로 이 메소드(beforeControllerPointCut)를 실행하고  "
				+ " 컨트롤러의 해당메소드(타겟메소드)로 가서 실행됨.");
	}
	
	
}
