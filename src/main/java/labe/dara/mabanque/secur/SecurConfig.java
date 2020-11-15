package labe.dara.mabanque.secur;

import java.security.CryptoPrimitive;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password("{noop}1234").roles("ADMIN","USER");
		 * auth.inMemoryAuthentication()
		 * .withUser("user").password("{noop}bah").roles("USER");
		 */
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials,active from users where username=?")
		.authoritiesByUsernameQuery("select username as principal, role from users_roles where username=?")
		.passwordEncoder(new BCryptPasswordEncoder()).rolePrefix("ROLE_");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/consulterCompte","/operations").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
}