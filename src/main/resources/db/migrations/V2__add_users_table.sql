create type user_role as enum ('ADMIN', 'USER');

create table if not exists app_user (
id uuid not null,
password varchar(300),
username varchar(50),
role user_role,
primary key (id)
);
