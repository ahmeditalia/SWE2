package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebSecurityAuthenticator implements AuthenticationProvider {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();


        userRepository.existsByUsernameAndPassword(username, password);
        User user = userRepository.findOneByUsernameAndPassword(username, password);

        if(null == user) { throw new BadCredentialsException("Invalid Username or Password Douche!");}

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if(user instanceof Admin) {
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        }


        return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> authentication) { return authentication.equals(UsernamePasswordAuthenticationToken.class); }
}
