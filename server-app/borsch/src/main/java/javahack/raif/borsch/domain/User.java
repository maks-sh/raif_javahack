package javahack.raif.borsch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Data
@AllArgsConstructor
@Table("user")
public class User {
    @PrimaryKey
    UUID id;

    @Column("img_url")
    private String url;

    @Column("name")
    private String name;
}

