package cybersoft.javabackend.java11.gira.commondata;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


public class AuditorAwareImpl implements AuditorAware<String>  {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		SecurityContext currentSecurityContext = SecurityContextHolder.getContext();
		String currentUsername= currentSecurityContext.getAuthentication().getName();
		return Optional.ofNullable(currentUsername);
	}
	
}
