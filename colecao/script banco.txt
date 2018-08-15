create database dbmercado;
use dbmercado;

create table funcionario (
	idfuncionario int not null auto_increment primary key,
	nome varchar(256),
	cpf varchar(20),
	cargo varchar(256)
);

create table produto (
	idproduto int not null auto_increment primary key,
	nome varchar(256),
	marca varchar(20),
	peso float,
	preco float
);