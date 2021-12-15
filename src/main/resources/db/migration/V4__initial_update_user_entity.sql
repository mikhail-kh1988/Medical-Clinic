ALTER TABLE IF EXISTS USERS
DROP COLUMN password ;

ALTER TABLE IF EXISTS users
add column password character varying(128);

create table USERS_ROLES (user_id int8 not null, role varchar(255));
alter table if exists USERS_ROLES add constraint FKrcqrkmbfbvbfsj8g55112uevg foreign key (user_id) references users;

insert into users_roles
	(select id from users where type_user = 'DOCTOR');

update users_roles
set role = 'ROLE_DOCTOR'
where user_id in (select id from users where type_user = 'DOCTOR');

insert into users_roles
	(select id from users where type_user = 'CLIENT');

update users_roles
set role = 'ROLE_CLIENT'
where user_id in (select id from users where type_user = 'CLIENT');


update public.users
set password = '$2a$12$LYUpC.dv714BR7NQZnmapetudPxOHrkgg22sm4kD6LzXn20L2aGai';