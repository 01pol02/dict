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
@Table(name = "entity2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity2_seq")
    @SequenceGenerator(name = "entity2_seq", sequenceName = "entity2_seq", initialValue = 4)
    @Column(name = "entity2_id")
    private Long id;

    @Column(name = "entity2_name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "map2", joinColumns = @JoinColumn(name = "entity2_id"))
    @MapKeyColumn(name = "map2_key")
    @Column(name = "map2_value")
    private Map<String, Float> map2 = new HashMap<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "map2",
            joinColumns = @JoinColumn(name = "entity2_id"),
            inverseJoinColumns = @JoinColumn(name = "entity1_id"))
    private Set<Entity1> entity1s = new HashSet<>();

    public Entity2(String name) {
        this.name = name;
    }

}
