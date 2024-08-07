package com.shinhan.firstzone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration//설정 파일임을 의미..App 시작 시 해석된다.
@EnableWebSecurity
public class SpringSecurityConfig {

	//상수로 접근권한에 따른 요청 주소들을 저장
	private static final String[] WHITE_LIST= {"/security/all","/auth/**","/v3/**","/swagger-ui/**"};
	private static final String[] USER_LIST= {"/security/user","/webboard/**","/replies/**"};
	private static final String[] ADMIN_LIST= {"/security/admin"};
	private static final String[] MANAGER_LIST= {"/security/manager"};
	
	@Bean
	PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception{
		//http.csrf(c->c.disable());//csrf 토큰을 사용하지 않음, default는 토큰을 사용
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(WHITE_LIST).permitAll();//로그인 불필요
			auth.requestMatchers(USER_LIST).hasRole("USER");
			auth.requestMatchers(ADMIN_LIST).hasRole("ADMIN");
			auth.requestMatchers(MANAGER_LIST).hasRole("MANAGER");
			auth.anyRequest().authenticated();
		});
		//http.formLogin();
		
		http.formLogin(login->login.loginPage("/auth/login")
				.usernameParameter("mid")//default 이름이 username, 변경하고자 하면 반드시 설정해야함
				.defaultSuccessUrl("/auth/loginSuccess")
				.permitAll());
		
		http.logout(out->out.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
				.logoutSuccessUrl("/auth/login")
				.invalidateHttpSession(true));
		
		http.exceptionHandling(handling->handling.accessDeniedPage("/auth/accessDenined"));
		
		return http.build();
	}
	
	
}
