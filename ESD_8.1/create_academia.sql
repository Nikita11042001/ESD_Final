create table comp
(
    comp_id   bigint auto_increment
        primary key,
    comp_add  varchar(255) null,
    comp_name varchar(255) not null,
    constraint UK_ryej7bc6as1y1qhuvbgqktqti
        unique (comp_name)
);

create table employee
(
    empid_id   int auto_increment
        primary key,
    department varchar(255) null,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) null,
    password   varchar(255) not null,
    ph_path    varchar(255) null,
    title      varchar(255) null,
    constraint UK_fopic1oh5oln2khj8eat6ino0
        unique (email)
);

create table hr
(
    hr_id   bigint auto_increment
        primary key,
    con     bigint       null,
    email   varchar(255) not null,
    f_name  varchar(255) not null,
    l_name  varchar(255) null,
    comp_id bigint       null,
    constraint UK_bu5tbkuglf99b51daqgxkxacw
        unique (comp_id),
    constraint UK_c3ou32f25macmqa7xsgyj58h6
        unique (email),
    constraint FK4mvh2uohgu3wgy62ykyd8r8ih
        foreign key (comp_id) references comp (comp_id)
);


