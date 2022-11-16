/**
LHL Cell
@author joao vitor
@version 1.2
*/

create database lhlcell;

use lhlcell;

create table usuarios (
	iduser int primary key auto_increment,
    usuario varchar(255) not null,
    login varchar(15) not null unique,
    senha varchar(255) not null,
    perfil varchar(255) not null
);



describe usuarios;

insert into usuarios (usuario,login,senha,perfil)
values ('administrador','admin',md5('admin'),'admin');

insert into usuarios (usuario,login,senha,perfil)
values ('pamela','pam',md5('123456'),'user');

insert into usuarios (usuario,login,senha,perfil)
values ('Linus Torvalds','tux',md5('123'),'user');

select * from usuarios;

select * from usuarios where login='admin' and senha=md5('admin');

describe usuarios;

-- ========== CREATE TABLE FORNECEDORES==============
create table fornecedores (
idfor int primary key auto_increment,
cnpj varchar(255) not null unique,
ie varchar(255) unique,
im varchar(255) unique,
razao varchar(255) not null,
fantasia varchar(255) not null,
site varchar(255),
fone varchar(255) not null,
contato varchar(255),
email varchar(255),
cep varchar(255) not null,
endereco varchar(255) not null,
numero varchar(255) not null,
complemento varchar(255),
bairro varchar(255) not null,
cidade varchar(255) not null,
uf varchar(255) not null,
obs varchar(255)
);

update fornecedores set razao = 'Lucas Vitor santos', fantasia = 'Loja de eletronicos',fone = '11941527472' where idfor = 2;

insert into fornecedores (cnpj, razao, fantasia,fone, cep, endereco, numero, bairro, cidade, uf)
values ('76.256.914/0001-80', 'Lucas Pedro', 'Assitência técnica','11941527538','04890-055','Rua Alfredo Roller','229','Jardim Roschel','São Paulo','SP');

insert into fornecedores (cnpj, razao, fantasia,fone, cep, endereco, numero, bairro, cidade, uf)
values ('76.256.914/0004-80', 'Lucas Vitor santos', 'Loja de eletronicos','11941527472','04890-025','Rua Alfredo Ro','29','Jardim Rosc','São Paulo','SP');

insert into fornecedores (cnpj, razao, fantasia,fone, cep, endereco, numero, bairro, cidade, uf)
values ('84.267.933/0001-28', 'Jefferson matheus', 'Acessorios Smatphone','119951272536','02841-090','Rua Bartolomeu Rodrigues','972','Parque São Luís','São Paulo','SP');

insert into fornecedores (cnpj, razao, fantasia,fone, cep, endereco, numero, bairro, cidade, uf)
values ('85.267.933/0003-28', 'Tiago luiz', 'Acessorios para caixa de Som','119951272536','02841-090','Rua Barto Rodri','97','Parque São','São Paulo','SP');

insert into fornecedores (cnpj, razao, fantasia,fone, cep, endereco, numero, bairro, cidade, uf)
values ('81.267.933/0003-28', 'Thiago Vieira', 'Acessorios para caixa de Som','119951272536','02841-090','Rua Barto Rodri','97','Parque São','São Paulo','SP');

delete from fornecedores where idfor = 1;

-- verificar pedidos junto com o nome do fornecedor (relatorio simplificado)
-- %H:%i exibir também o horário formatado
select
produtos.codigo,
date_format(produtos.datacad, '%d/%m/%Y - %H:%i') as data_ped,
produtos.produto,
fornecedores.fantasia as fornecedor,
fornecedores.cnpj,
fornecedores.uf
from fornecedores inner join produtos
on fornecedores.idfor = produtos.idfor;

select * from fornecedores;

create table produtos (
	codigo int primary key auto_increment,
    barcode varchar(255) unique,
	produto varchar(255) not null,
    descricao varchar(255) not null,
    fabricante varchar(255) not null,
    datacad timestamp default current_timestamp,
    dataval date not null,
    estoque int not null,
    estoquemin int not null,
    unidade varchar(255) not null,
    localizacao varchar(255),
    custo decimal (10,2) not null,
    lucro decimal(10,2),
    venda decimal (10,2),
    idfor int not null,
    foreign key (idfor) references fornecedores(idfor)
);

-- modificar o barcode adicionando o unique (exemplo)
alter table produtos modify column barcode varchar(255) unique;

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda,idfor)
values ('1234567890','Capinha','Capinha para Smartphone', 'CapasMax',20120720,20,'5','UN','setor de capinhas',5.45,100,10.90,2);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda, idfor)
values ('111111111','Fone bluetooth','Fone bluetooth', 'FonesMax',20250410,3,'5','UN','setor de fones',40.00,100,80.00,2);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda, idfor)
values ('222222222','Celular Samsung','Samsug A10', 'Samsung',20350926,5,'7','UN','vitrine de smartphone',2.000,100,4.000,1);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda, idfor)
values ('333333333','Caixinha de som','Caixinha JBL Dourada', 'JB Caixas',20400330,55,'10','UN','pratilheira de caixas de som',220,100,440,2);

insert into produtos (barcode,produto,descricao,fabricante,dataval,estoque,estoquemin,unidade,localizacao,custo,lucro,venda, idfor)
values ('444444444','Teclado','Teclado razer gamer RGB', 'TecHW',20150109,60,'15','UN','Setor de perifericos',140,100,280,2);

describe produtos;

select * from produtos;

drop table produtos;

-- inventario do estoque (patrimônio)
-- sum() função de soma no banco de dados
select sum(estoque * custo) as total from produtos;

-- Relatório de reposição de etoque 1
select * from produtos where estoque < estoquemin;

-- relatório de reposição de estoque 2
-- date_format() função usada para formatar a data
-- %d/%m/%Y dd/mm/aaaa | %d/%m/%y dd/mm/aa

select codigo as código,produto,
date_format(dataval, '%d/%m/%Y') as data_validade,
estoque,estoquemin as estoque_minimo
from produtos where estoque < estoquemin;

-- relatório de validade de produtos 1 
select codigo as código,produto,
date_format(dataval, '%d/%m/%Y') as data_validade
from produtos;

-- relatório de validade de produtos 2
-- datediff() calcula a diferença em dias
-- curdate obtém a data atua

select codigo as código,produto,
date_format(dataval, '%d/%m/%Y') as data_validade,
datediff(dataval,curdate()) as dias_restantes
from produtos;

create table clientes (
	idcli int primary key auto_increment,
    nome varchar(255) not null,
    fone varchar(255) not null,
    cpf varchar(255) unique,
    email varchar(255),
    marketing varchar(255) not null,
    cep varchar(255),
    endereco varchar(255),
    numero varchar(255),
    complemento varchar(255),
    bairro varchar(255),
    cidade varchar(255),
    uf char(2)
    );
    
-- adicionando um campo de nascimento na tabela clientes
alter table clientes add column nascimento varchar(255);

describe clientes;

-- ====CRUD CREATE CLIENT===
insert into clientes (nome, fone, cpf, marketing)
values ('Lica', '1198674-5312', '063.534.368-15','não');

insert into clientes (nome, fone, cpf, marketing, email)
values ('Naine', '1199543-7715','679.563.308-07','sim', 'naine@gmail.com');

insert into clientes (nome, fone, cpf, email, marketing, cep, endereco, numero, complemento, bairro, cidade, uf)
values ('Pamela', '1199754-8815','680.463.208-04','pamela@gmail.com','sim', '084900500', 'Praça da República', '1600', 'Casa', 'República', 'São Paulo', 'SP');

insert into clientes (nome, fone, cpf, email, marketing, cep, endereco, numero, complemento, bairro, cidade, uf)
values ('Patricia', '1198754-2215','610.453.208-03','patricia@gmail.com','sim', '79002290', 'Praça Vinho', '800', 'Apt 2 BL 4', 'Centro', 'São Paulo', 'SP');


-- ====CRUD READ CLIENT=======
select * from clientes;

-- =====CRUD UPDATE CLIENT=====
update clientes set fone = '4002-8922' where idcli=6;

-- =======CRUD DELETE CLIENT=============
delete from clientes where idcli=6;

-- =====Relatório de cliente personalizados
select nome,fone,email
from clientes;

select nome, nascimento,
date_format(nascimento, '%d/%m/%Y') as data_validade
from clientes;

select * from clientes where marketing = 'sim';

-- foreign key(FK) Chave estrangeira que cria o relacionamento
-- do tipo 1-N com a tabela clientes
-- FK(pedidos)______________PK(clientes)
-- Observação: Usar o mesmo nome e tipo de dados nas chaves (PK e FK)
create table pedidos (
pedido int primary key auto_increment,
dataped timestamp default current_timestamp,
total decimal(10,2),
idcli int not null,
foreign key (idcli) references clientes(idcli)
);

-- abertura de pedido
insert into pedidos(idcli) values(1);
insert into pedidos(idcli) values(2);


-- verificar pedidos
select * from pedidos where pedido = 1;

-- verificar pedido junto com o nome do cliente
-- inner join (unir informações de 2 ou mais tabelas)
select * from pedidos inner join clientes
on pedidos.idcli = clientes.idcli;

-- verificar pedidos junto com o nome do cliente (relatorio simplificado)
-- %H:%i exibir também o horário formatado
select
pedidos.pedido,
date_format(pedidos.dataped, '%d/%m/%Y - %H:%i') as data_ped,
clientes.nome as cliente,
clientes.fone
from pedidos inner join clientes
on pedidos.idcli = clientes.idcli;

-- ===== Linha de tabela de carrinho =======
-- tabela de apoio para criar um relacionamento de tipo M-M
-- (muitos para muitos) neste caso não criamos a chave primaria
create table carrinho (
	pedido int not null,
    codigo int not null,
    quantidade int not null,
    foreign key(pedido) references pedidos(pedido),
    foreign key(codigo) references produtos(codigo)
);

insert into carrinho values (2,4,1);
insert into carrinho values (1,2,3);
insert into carrinho values (2,1,5);

select * from carrinho;

-- Exibir o carrinho
select pedidos.pedido,
carrinho.codigo as código,
produtos.produto,
carrinho.quantidade,
produtos.venda,
produtos.venda * carrinho.quantidade as sub_total
from (carrinho inner join pedidos on carrinho.pedido =
pedidos.pedido)
inner join produtos on carrinho.codigo = produtos.codigo;

-- Total do pedido(carrinho)
select sum(produtos.venda * carrinho.quantidade) as total
from carrinho inner join produtos on carrinho.codigo = produtos.codigo;

-- atualização do estoque
update carrinho
inner join produtos
on carrinho.codigo = produtos.codigo
set produtos.estoque = produtos.estoque - carrinho.quantidade
where carrinho.quantidade > 0;