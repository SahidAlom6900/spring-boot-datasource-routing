package com.technoelevate.routedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.routedb.e_constants.DataSourceType;
import com.technoelevate.routedb.entity.Test;
import com.technoelevate.routedb.util.WithDatabase;

@WithDatabase(DataSourceType.SECONDARY)
@Repository("testRepositoryNonConfig")
public interface TestRepository extends JpaRepository<Test, Long> {

}
