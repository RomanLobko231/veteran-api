create table if not exists news_article (
date timestamp(6) with time zone,
id uuid not null,
title varchar(300),
content TEXT,
primary key (id)
);

create table if not exists document (
date timestamp(6) with time zone,
id uuid not null,
title varchar(500),
description TEXT,
mime_type varchar(255),
file_data bytea,
primary key (id)
);



