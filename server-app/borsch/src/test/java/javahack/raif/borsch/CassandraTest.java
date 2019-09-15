package javahack.raif.borsch;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import javahack.raif.borsch.domain.User;
import javahack.raif.borsch.repo.UserRepo;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraTestConfig.class)
public class CassandraTest {

    private static final String DATA_TABLE_NAME = "user";

    @Autowired
    CassandraOperations opTemplate;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CassandraAdminTemplate adminTemplate;


    @BeforeClass
    public static void startCassandraEmbedded() throws InterruptedException, TTransportException, ConfigurationException, IOException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder()
                .withoutJMXReporting()
                .addContactPoints("127.0.0.1").withPort(9142).build();
        Session connect = cluster.connect();
    }

    @Before
    public void createTable() {
        adminTemplate.createTable(
                true, CqlIdentifier.cqlId(DATA_TABLE_NAME),
                User.class, new HashMap<>());
    }

    @Test
    public void test() {

        userRepo.insert(new User(UUID.randomUUID(), "https://randomuser.me/api/portraits/women/39.jpg", "myName"));
    }

    @After
    public void dropTable() {
        adminTemplate.dropTable(CqlIdentifier.cqlId(DATA_TABLE_NAME));
    }

    @AfterClass
    public static void stopCassandraEmbedded() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }
}
