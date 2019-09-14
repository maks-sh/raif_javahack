package javahack.raif.borsch.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.IOException;
import java.util.Collections;
import java.util.function.Supplier;

@Configuration
@EnableCassandraRepositories(basePackages = "javahack.raif.borsch.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final Logger LOG = LogManager.getLogger("borsch.logger");

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
    public CassandraClusterFactoryBean cluster(
            @Autowired Supplier<String> actions
    ) {
        try {
            LOG.info(actions.get());
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
    @Profile("local")
    public Supplier<String> localPreconfigActions() throws InterruptedException, IOException, TTransportException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        return () -> "EmbeddedCassandra started";
    }

    @Bean
    @Profile("!local")
    public Supplier<String> notLocalPreconfigActions() {
        return () -> "no preconfig actions";
    }

    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
}
