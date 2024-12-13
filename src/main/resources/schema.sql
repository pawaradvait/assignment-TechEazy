
create table person (
    id integer not null,
    name varchar(255),
    address varchar(255),
    primary key (id)
);

create table subject (
    id integer not null,
    name varchar(255),
    primary key (id)
);

create table person_subject (

    id integer not null,
    person_id integer not null,
    subject_id integer not null,
    primary key (id) ,
    foreign key (person_id) references person(id),
    foreign key (subject_id) references subject(id)

    )