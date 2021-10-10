package com.dazgs.templateapi.core.repository.sql;

import com.dazgs.templateapi.core.domains.sql.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);
}
