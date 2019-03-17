package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="entity1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entity1 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity1_seq")
    @SequenceGenerator(name = "entity1_seq", sequenceName = "entity1_seq", initialValue = 4)
    @Column(name = "entity1_id")
    private Long id;

    @Column(name="entity1_name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "map1", joinColumns = @JoinColumn(name = "entity1_id"))
    @MapKeyColumn(name = "map1_key")
    @Column(name = "map1_value")
    private Map<String, Float> map1 = new HashMap<>();

    public Entity1(String name) {
        this.name = name;
    }
}
