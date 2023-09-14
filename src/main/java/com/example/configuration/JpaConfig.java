package com.example.configuration;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
@EntityScan(basePackages = {"com.example.model"})
//public class JpaConfig {}
public class JpaConfig extends JpaBaseConfiguration {
    protected JpaConfig(DataSource dataSource,
                        JpaProperties properties,
                        ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected void customizeVendorProperties(final Map<String, Object> vendorProperties) {
        vendorProperties.put(PersistenceUnitProperties.WEAVING, String.valueOf(false));
        vendorProperties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.NONE);
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        return new HashMap<>(getProperties().getProperties());
    }
}
