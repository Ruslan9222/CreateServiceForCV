create sequence hibernate_sequence start 1 increment 1;

create table db_candidate
(
    id          int8 NOT NULL,
    avatar      bytea,
    cv          bytea,
    description varchar(2048),
    name        varchar(255),
    patronymic  varchar(255),
    surname     varchar(255),
    primary key (id)
);

create table db_candidate_direction_list
(
    candidate_id      int8 NOT NULL,
    direction_list_id int8 NOT NULL
);

create table db_direction_names
(
    id             int8 NOT NULL,
    description    varchar(2048),
    direction_name varchar(255),
    primary key (id)
);

create table db_result_test_candidate
(
    id                int8 NOT NULL,
    date              date,
    result            varchar(255),
    candidate_test_id int8,
    tests_id          int8,
    primary key (id)
);

create table db_tests
(
    id               int8 NOT NULL,
    test_description varchar(255),
    test_name        varchar(255),
    primary key (id)
);

create table db_tests_directions
(
    tests_id      int8 NOT NULL,
    directions_id int8 NOT NULL
);
alter table if exists db_candidate_direction_list
    add constraint db_candidate_direction_list_fk
        unique (direction_list_id);


alter table if exists db_tests_directions
    add constraint db_tests_directions_fk
        unique (directions_id);


alter table if exists db_candidate_direction_list
    add constraint db_candidate_direction_list_names_fk
        foreign key (direction_list_id)
            references db_direction_names;



alter table if exists db_result_test_candidate
    add constraint db_result_test_candidate_fk
        foreign key (candidate_test_id)
            references db_candidate;




alter table if exists db_tests_directions
    add constraint db_tests_directions_names_fk
        foreign key (directions_id)
            references db_direction_names;

