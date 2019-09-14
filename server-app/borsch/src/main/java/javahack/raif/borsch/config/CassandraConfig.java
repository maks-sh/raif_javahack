package javahack.raif.borsch.config;

import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;

@Configuration
@EnableCassandraRepositories(basePackages = "javahack.raif.borsch.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.keyspace}")
    private String keyspace;


    @Value("${cassandra.port}")
    private Integer port;

    @Value("${cassandra.host}")
    private String host;

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        try {
            EmbeddedCassandraServerHelper.startEmbeddedCassandra();
            CassandraClusterFactoryBean cluster =
                    new CassandraClusterFactoryBean();
            CreateKeyspaceSpecification createKeySpace = CreateKeyspaceSpecification.createKeyspace(keyspace);
            cluster.setKeyspaceCreations(Collections.singletonList(createKeySpace));
            cluster.setJmxReportingEnabled(false);
            cluster.setContactPoints(host);
            cluster.setPort(port);
            return cluster;
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка инициализации Cassandra", ex);
        }
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
