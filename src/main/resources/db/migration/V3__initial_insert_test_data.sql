
insert into users(type_user, email, family_name, first_symbol_name, full_name, login, password, status_user, online)
values('DOCTOR', 'admin@admin', 'Admin', 'A', 'Admin Admins', 'admin', '12345', 'ACTIVE', false);

insert into users(type_user, email, family_name, first_symbol_name, full_name, login, password, status_user, online, age)
values('CLIENT', 'client@client', 'Client', 'C', 'Client Client', 'client', '12345', 'ACTIVE', false, 22);

insert into users(type_user, email, family_name, first_symbol_name, full_name, login, password, status_user, online, age)
values('DOCTOR', 'ivanov@medclinic.ru', 'Ivanov', 'I', 'Ivanov Ivan Mikhaylovich', 'ivanov', '12345', 'ACTIVE', false, 35);

insert into users(type_user, email, family_name, first_symbol_name, full_name, login, password, status_user, online, age)
values('DOCTOR', 'petrov@medclinic.ru', 'Petrov', 'P', 'Petrov Petr Vasilyevich', 'petrov', '12345', 'ACTIVE', false, 29);

insert into users(type_user, email, family_name, first_symbol_name, full_name, login, password, status_user, online, age)
values('DOCTOR', 'sidorov@medclinic.ru', 'Sidorov', 'S', 'Sidorov Dmitry Georgievich', 'sidorov', '12345', 'ACTIVE', false, 24);

insert into analysis(describe, name, price)
values('TEST DESCR', 'TEST', 111);

insert into analysis(describe, name, price)
values('BLOOD TEST ALL THIS', 'BLOOD TEST', 111);

insert into analysis(describe, name, price)
values('URINA TEST', 'URINA TEST', 111);


insert into services(active, describe, external_code, name, price)
values (true, 'TEST SERVICE', '101-TST', 'TEST SERVICE', 111);

insert into services(active, describe, external_code, name, price)
values (true, 'NOT TEST', '102-TST', 'NOT SERVICE', 111);

insert into services(active, describe, external_code, name, price)
values (true, 'TEST SERVICE', '101-TST', 'TEST SERVICE', 111);