package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "entity1")
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

    @Column(name = "entity1_name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "map1", joinColumns = @JoinColumn(name = "entity1_id"))
    @MapKeyColumn(name = "map1_key")
    @Column(name = "map1_value")
    private Map<String, Float> map1 = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "map2",
            joinColumns = @JoinColumn(name = "entity1_id"),
            inverseJoinColumns = @JoinColumn(name = "entity2_id"))
    private Set<Entity2> entity2s = new HashSet<>();

    public Entity1(String name) {
        this.name = name;
    }
}
