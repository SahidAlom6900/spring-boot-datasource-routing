package com.technoelevate.routedb.repository;

import com.technoelevate.routedb.e_constants.DataSourceType;
import com.technoelevate.routedb.entity.Account;
import com.technoelevate.routedb.util.WithDatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@WithDatabase(DataSourceType.TERTIARY)
@Repository("accountRepositoryNonConfig")
public interface AccountRepository extends JpaRepository<Account, Long> {

}
