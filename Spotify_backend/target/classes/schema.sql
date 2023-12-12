create table SpotifyUser (
	access_token varchar(50) not null,
    refresh_token varchar(50) not null,
    expires int not null
    
    primary key(access_token, refresh_token)
);

create table UserContext (
	user_id int not null auto_increment,
	username varchar(50) not null,
	access_token varchar(50),
    refresh_token varchar(50),
    expires int,

	primary key(user_id),
    foreign key(access_token, refresh_token, expires) references SpotifyUser(access_token, refresh_token, expires)
);

alter table UserContext auto_increment=100;
