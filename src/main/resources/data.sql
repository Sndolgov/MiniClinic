create table indicator
(
	indicator_id int auto_increment,
	name varchar(200) not null,
	threshold int not null,
	constraint indicator_pk
		primary key (indicator_id)
);

create unique index indicator_name_uindex
	on indicator (name);

INSERT INTO mini_clinic.indicator (indicator_id, name, threshold) VALUES (1, 'HDL Cholesterol', 40);
INSERT INTO mini_clinic.indicator (indicator_id, name, threshold) VALUES (2, 'LDL Cholesterol', 100);
INSERT INTO mini_clinic.indicator (indicator_id, name, threshold) VALUES (3, 'A1C', 4);
