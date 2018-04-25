package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    WebSecurityAuthenticator webSecurityAuthenticator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/Registration", "/css/*", "/js/*", "/img/*").permitAll()
                .antMatchers("/add-product","/admin-view","/show-all-product").hasAuthority("admin")
                .antMatchers("/add-product-store","/show-all-product-store","/store-owner-view").hasAuthority("storeOwner")
                .antMatchers("/login","/normal-user-view").hasAuthority("NormalUser")
                .antMatchers("/login","/collaborator").hasAuthority("Collaborator")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/success", true)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        http.csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(webSecurityAuthenticator);
    }
}