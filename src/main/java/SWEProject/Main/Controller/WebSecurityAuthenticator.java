package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
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

    private UserRepository userRepository;
    
    @Autowired(required = true)
    public WebSecurityAuthenticator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
    
    
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findOneByUsernameAndPassword(username, password);
        if(null == user) { throw new BadCredentialsException("Invalid Username or Password Douche!");}
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if(user instanceof Admin) {
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        }
        else if(user instanceof StoreOwner){
            grantedAuthorities.add(new SimpleGrantedAuthority("storeOwner"));
        }
        else if(user instanceof NormalUser){
            grantedAuthorities.add(new SimpleGrantedAuthority("NormalUser"));
        }
        else if(user instanceof Collaborator){
            grantedAuthorities.add(new SimpleGrantedAuthority("Collaborator"));
        }

        return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
    }
    @Override
    public boolean supports(Class<?> authentication) { return authentication.equals(UsernamePasswordAuthenticationToken.class); }
}