create table Student 
(
   id integer not null,
   firstName varchar(255),
   lastName varchar(255),
   fatherName varchar(255),
   motherName varchar(255),
   clazz varchar(255),
   primary key(id)
);

create table Address 
(
   id integer not null,
   address_1 varchar(255),
   address_2 varchar(255),
   address_3 varchar(255),
   primary key(id)
);