create database batch;
create database legado;
use legado;
create table Transaction (id_transaction int AUTO_INCREMENT PRIMARY KEY, cpf varchar (14), description varchar (255));
select * from legado.`Transaction`;