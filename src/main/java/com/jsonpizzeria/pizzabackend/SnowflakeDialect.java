package com.jsonpizzeria.pizzabackend;

import java.sql.Types;

import org.hibernate.MappingException;
import org.hibernate.dialect.SQLServer2012Dialect;

public class SnowflakeDialect extends SQLServer2012Dialect {


    public SnowflakeDialect() {
        super();
        registerColumnType(Types.TIMESTAMP, "datetime");
    }

    private void registerColumnType(int timestamp, String datetime) {
    }
}