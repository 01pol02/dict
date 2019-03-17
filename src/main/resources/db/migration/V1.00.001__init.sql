create table entity1
(
  entity1_id   int         not null unique,
  entity1_name varchar(10) not null,
  primary key (entity1_id)
);

create table map1
(
  entity1_id int         not null,
  map1_key   varchar(10) not null,
  map1_value decimal     not null,
  primary key (entity1_id, map1_key),
  foreign key (entity1_id) references entity1 (entity1_id)
    on delete cascade
    on update cascade
);

create table entity2
(
  entity2_id   int         not null unique,
  entity2_name varchar(20) not null,
  primary key (entity2_id)
);

create table map2
(
  entity2_id int         not null,
  map2_key   varchar(10) not null,
  map2_value decimal     not null,
  entity1_id int         not null,
  primary key (entity2_id, map2_key),
  foreign key (entity2_id) references entity2 (entity2_id)
    on delete cascade
    on update cascade,
  foreign key (entity1_id) references entity1 (entity1_id)
    on delete cascade
    on update cascade
);

insert into entity1 (entity1_id, entity1_name)
values (1, 'entity1_1'),
       (2, 'entity1_2'),
       (3, 'entity1_3');

insert into map1 (entity1_id, map1_key, map1_value)
values (1, 0, 0.1),
       (1, 1, 0.1),
       (1, 2, 0.1),
       (2, 3, 0.2),
       (2, 4, 0.2),
       (2, 5, 0.2),
       (3, 6, 0.3),
       (3, 7, 0.3),
       (3, 8, 0.3);

insert into entity2 (entity2_id, entity2_name)
values (1, 'entity2_1'),
       (2, 'entity2_2'),
       (3, 'entity2_3');

insert into map2 (entity2_id, map2_key, map2_value, entity1_id)
values (1, 0, 10, 1),
       (1, 1, 20, 1),
       (1, 2, 10, 2),
       (1, 3, 10, 2),
       (2, 0, 20, 2),
       (2, 1, 20, 2),
       (2, 2, 20, 3),
       (2, 3, 20, 3),
       (3, 0, 10, 3),
       (3, 1, 10, 3),
       (3, 2, 10, 1),
       (3, 3, 10, 1);