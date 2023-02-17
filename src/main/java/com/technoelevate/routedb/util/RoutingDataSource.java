package com.technoelevate.routedb.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.technoelevate.routedb.e_constants.DataSourceType;

@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        final DataSourceType sourceType = DatabaseContextHolder.peekDataSource().orElse(null);
//System.err.println(sourceType.name());
        if (sourceType != null) {
            log.info("Chose {} data source for the next transaction.", sourceType);
        }

        return sourceType;
    }
}
