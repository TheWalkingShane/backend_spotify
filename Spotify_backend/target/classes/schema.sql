create table SpotifyUser (
	access_token varchar(50) not null,
    refresh_token varchar(50) not null,
    expires int not null
);

create table UserContext (
	user_id int not null auto_increment,
	username varchar(50) not null unique,
    email varchar(50) not null unique,
    password varchar(20) not null,
    display_name varchar(20) not null,
    country varchar(50) not null,
    spotify_connected bool not null,
	access_token varchar(50),
    refresh_token varchar(50),
    expires int,

	primary key(user_id),
    foreign key(access_token, refresh_token, expires) references SpotifyUser(access_token, refresh_token, expires)
);

alter table UserContext auto_increment=100;
