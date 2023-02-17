package com.technoelevate.routedb.e_constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DataSourceType {

    PRIMARY("primary"), SECONDARY("secondary"), TERTIARY("tertiary");

    private final String name;
}
