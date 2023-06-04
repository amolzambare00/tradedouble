package com.abc.affiliate.productprocessor.audit;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Amol Zambare");
		//TODO: Get user from Authentication
	}
	
}

