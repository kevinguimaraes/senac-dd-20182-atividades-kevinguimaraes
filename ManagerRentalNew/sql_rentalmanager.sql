-- drop database db_rentalmanager;
create database db_rentalmanager;
use db_rentalmanager;

create table usuario (
	idusuario int not null auto_increment,
	nome varchar(255),
	cpf varchar(15),
	login varchar(100),
	pass varchar(100),
	primary key (idusuario)
);

create table estado (
	idestado int not null auto_increment,
	nome varchar(50),
	primary key (idestado)
);


create table cidade (
	idcidade int not null auto_increment,
	idestado int not null,
	nome varchar(50),
	primary key (idcidade),
	foreign key (idestado) references estado(idestado)
);

create table caracteristica(
	idcaracteristica int not null auto_increment,
	nome varchar(200),
	primary key (idcaracteristica)
);
create table imovel (
	idimovel int not null auto_increment,
	idestado int not null,
	idcidade int not null,
	-- idcaracteristica int not null,
	referencia varchar(255),
	rua varchar(255),
	numero int,
	primary key (idimovel),
	foreign key (idestado) references estado(idestado),
	foreign key (idcidade) references cidade(idcidade)
	-- foreign key (idcaracteristica) references caracteristica(idcaracteristica)
);

create table cliente (
	idcliente int not null auto_increment,
	idestado int not null,
	idcidade int not null,
	nome varchar(255),
	cpf varchar(15),
	rua varchar(255),
	numero int,
	telefone varchar(50),
	celular varchar(50),
	primary key (idcliente),
	foreign key (idestado) references estado(idestado),
	foreign key (idcidade) references cidade(idcidade)	
);

create table alugado (
	idalugado int not null auto_increment,
	idimovel int not null,
	idcliente int not null,
	dt_inicio date,
	dt_final date,
	valor float,
	primary key (idalugado),
	foreign key (idimovel) references imovel(idimovel),
	foreign key (idcliente) references cliente(idcliente)
);

create table carac_imovel (
	idimovel int not null,
	idcaracteristica int not null,
	valor int,
	primary key (idimovel, idcaracteristica),
	foreign key (idcaracteristica) references caracteristica(idcaracteristica),
	foreign key (idimovel) references imovel(idimovel)
);
insert into estado (nome) values ('sc');
insert into estado (nome) values ('pr');

insert into cidade (nome,idestado) values ('floripa',1);
insert into cidade (nome,idestado) values ('joinvile',1);
insert into cidade (nome,idestado) values ('balneario',1);
insert into cidade (nome,idestado) values ('curitiba',2);

insert into caracteristica (nome) values ('quarto');
insert into caracteristica (nome) values ('cozinha');
insert into caracteristica (nome) values ('banheiro');
insert into caracteristica (nome) values ('garagem');
insert into caracteristica (nome) values ('sacada');
insert into caracteristica (nome) values ('churrasqueira');
insert into caracteristica (nome) values ('area servico');
insert into caracteristica (nome) values ('banheira');
insert into caracteristica (nome) values ('piscina');

INSERT INTO cliente (idestado, idcidade, nome, cpf, rua, numero, telefone, celular) VALUES (1,1,'kevin','08815886958','Rua x',12,'48123459','4865432197');
INSERT INTO cliente (idestado, idcidade, nome, cpf, rua, numero, telefone, celular) VALUES (1,1,'moda','13245679858','Rua y',1,'321','321');
INSERT INTO cliente (idestado, idcidade, nome, cpf, rua, numero, telefone, celular) VALUES (1,1,'julian','13245679858','Rua z',2,'12321','123');

insert into imovel (idestado, idcidade, referencia,rua,numero) values (1,1,'Casa 1','asdasad',12);
insert into imovel (idestado, idcidade, referencia,rua,numero) values (1,1,'Casa 2','qwe',12);
insert into imovel (idestado, idcidade, referencia,rua,numero) values (1,1,'Casa 3','iuy',12);

insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (1,1,'2018-03-04', '2018-05-03',100);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (2,2,'2018-03-04', '2018-05-03',200);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (3,3,'2018-03-04', '2018-05-03',300);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (1,3,'2018-03-04', '2018-05-03',400);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (1,1,'2018-11-04', '2018-11-10',100);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (2,2,'2018-12-20', '2018-12-30',200);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (3,3,'2018-12-01', '2018-05-05',300);
insert into alugado (idimovel, idcliente, dt_inicio, dt_final, valor) values (1,3,'2019-01-15', '2019-01-25',400);

insert into carac_imovel (idimovel, idcaracteristica, valor) values (1,1,5);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (1,2,2);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (1,3,2);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (1,4,3);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (2,1,1);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (2,2,1);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (2,3,1);
insert into carac_imovel (idimovel, idcaracteristica, valor) values (2,4,2);

select * from cliente;

select * from imovel;

select * from alugado;

select * from caracteristica;

select * from carac_imovel;

select c.nome, ci.valor from carac_imovel as ci inner join caracteristica as c on c.idcaracteristica = ci.idcaracteristica where ci.idimovel = 1;

select a.*, c.nome, c.cpf from alugado as a inner join cliente as c on a.idcliente = c.idcliente;

select * from alugado where dt_inicio between 2018-11-14 and DATE_ADD(2018-11-14, INTERVAL 3 month)

