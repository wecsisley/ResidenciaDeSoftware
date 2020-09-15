insert into categoria (id,nome, descricao) values
(1,'Congelados', 'produtos perecíveis congelados'),
(2,'Padaria', 'produtos de padaria'),
(3,'Cereais', 'produtos cereais e farinacios'),
(4,'Bebidas Alcoolicas', 'bebidas que contém teor alcoolico'),
(5,'Laticinios', 'produtos derivados do leite'),
(6,'Biscoitos', 'produtos confeccionados a base de farinha'),
(7, 'Limpeza', 'produtos de limpeza'),
(8,'Bebidas nao alcoolicas', 'bebidas que nao contem teor alcoolico');

insert into vendedor (id,nome,matricula) values
(1,'joao da silva', '00001'),
(2,'Thales Barbosa','00002'),
(3,'Miguel Andrada','00002'),
(4,'Pedro Paulo','00001'),
(5,'Sergio Alves','00001'),
(6,'Thalita Macedo','00003'),
(7,'Felipe Caetano','00001'),
(8,'Leo Bras','00001'),
(9,'Karen Pereira','00004'),
(10,'Lisa Silva','00001'),
(11,'Maria Clara','00001'),
(12,'Thais Araujo','00005'),
(13,'Wallace Carvalho','00001'),
(14,'Wiliam Carvalho','00008'),
(15,'Wesley Carvalho','000002');

insert into cliente (id,nome,telefone,cpf,rua,numero,complemento,cep,bairro,cidade,uf) values
(1,'luiz claudio','22224736','12365412344','rua das coves','15','perto do bar', '25675-160','Centro','sao jose das letras','rj'),
(2,'Mario Barbosa','55662233','55566644422','rua dos tomates','68','','5555-160','Centro','sao jose das letras','rj'),
(3,'Ana Luiza','22344736','98767546523','rua das alfaces','76','perto daquele lugar','12345-160','Xitaozinho','sao jose das frases','mg');

insert into Fornecedor (id, nome) values
(1,'JBS'),
(2,'BRF'),
(3,'ALFNeto'),
(4,'AZMarim'),
(5,'Casa Coqueiro'),
(6,'Trem Bom'),
(7,'Vall'),
(8,'Borges'),
(9,'Macuco'),
(10,'Piracanjuba'),
(11,'Nestlé'),
(12,'Piraque'),
(13,'AMBEV'),
(14,'Grupo Petropolis'),
(15,'Imperial');

insert into produto (id, nome, categoria_id, codigo_de_barras, data_fabricacao) values
(1,'Hamburguer Bovino',1,123,parsedatetime('2020-08-10', 'yyyy-mm-dd')),
(2, 'Suco Sufresh Uva',8,321,parsedatetime('2020-07-25', 'yyyy-mm-dd')),
(3, 'Arroz branco elegante tipo1', 3, 554, parsedatetime('2020-05-02', 'yyyy-mm-dd')),
(4, 'Feijao Bom No Prato', 3, 776, parsedatetime('2020-03-29', 'yyyy-mm-dd')),
(5, 'Fuba Dna. Benta', 3, 555, parsedatetime('2020-05-02', 'yyyy-mm-dd')),
(6, 'Cloro 5L', 7, 119, parsedatetime('2020-08-20', 'yyyy-mm-dd'));


insert into produto_fornecedor(produto_id, fornecedor_id) values
(1,1), (1,2), (2,3), (3,4), (3,5), (3,6), (4,4), (4,5), (4,6), (5,4), (5,5), (5,6), (6,7);

insert into pedido_compra (id, data_pedido_compra, cliente_id) values
(1,parsedatetime('2020-08-10', 'yyyy-mm-dd'), 1),
(2,parsedatetime('2020-06-11', 'yyyy-mm-dd'), 2),
(3,parsedatetime('2020-07-21', 'yyyy-mm-dd'), 2);


insert into produto_vendido (id, produto_vendido_id, produto_id, quantidade) values
(1,1,4,5),
(3,2,2,1),
(4,2,6,1),
(5,3,3,1),
(6,3,1,1);
