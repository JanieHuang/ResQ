SET SCHEMA APP;

drop table user;

create table appuser(
	id varchar(40) primary key,
	username varchar(40) not null unique,
	password varchar(40) not null,
	email varchar(40) not null
)

drop table post;

create table post(
	id varchar(40) primary key,
	topic varchar(40) not null,
	description varchar(300),
	address varchar(40),
	appuser_id varchar(40),
	constraint appuser_id_FK foreign key(appuser_id) references appuser(id)
)

insert into appuser(id, username, password, email) values('1a','sss','123','ss');