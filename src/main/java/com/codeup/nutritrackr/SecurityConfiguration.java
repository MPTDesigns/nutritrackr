package com.codeup.nutritrackr;

import com.codeup.nutritrackr.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader userDetailsLoader;

    public SecurityConfiguration(UserDetailsLoader userDetailsLoader) {
        this.userDetailsLoader = userDetailsLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsLoader)
            .passwordEncoder(passwordEncoder())
        ;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/diary")
                .usernameParameter("email")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .and()
            .authorizeRequests()
                .antMatchers("/", "/about-us", "/css/**", "/js/**", "/img/**", "/login*", "/register").permitAll()
                .anyRequest().authenticated()
        ;
    }
}
