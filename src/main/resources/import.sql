-- Inserir telefone
INSERT INTO telefone (codigoArea, numero) VALUES 
('63', '95832165'), ('62', '65478912'), ('91', '53315987'), ('15', '24578563'), ('67', '23547896'), 
('55', '17589632'), ('56', '74512365'), ('31', '77771234'), ('41', '66669874'), ('51', '55558796'), 
('32', '77574125'), ('32', '74569823'), ('87', '22038745'), ('11', '12345678'), ('21', '87654321'), 
('31', '98765432'), ('41', '23456789'), ('51', '87654321'), ('61', '98765432'), ('71', '23456789'), 
('81', '87654321');


INSERT INTO usuario (nome, username, dataNascimento, email, senha, id_telefone, sexo, cpf) 
VALUES 
('João Silva', 'Joao10', '1990-01-01', 'joao.silva@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1, 1, '12345678901'),
('Maria Souza', 'Maria20', '1995-03-15', 'maria.souza@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2, 2, '98765432109'),
('Ana Carolina Oliveira', 'anaoliveira', '1992-08-10', 'ana.oliveira@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 11, 2, '78945612385'),
('Rafael Souza', 'rafaelsouza', '1990-05-15', 'rafael.souza@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 3, 1, '15975346820'),
('Juliana Santos', 'julianasantos', '1994-11-20', 'juliana.santos@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 4, 2, '35715924680'),

('Rodrigo Oliveira', 'rodrigooliveira', '1985-03-05', 'rodrigo.oliveira@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 5, 1, '45698732100'),
('Leticia Alves', 'leticialves', '1998-09-12', 'leticia.alves@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 6, 2, '85236974100'),
('Amanda Oliveira', 'Amanda30', '1998-07-10', 'amanda.oliveira@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 7, 2, '85479632105'),
('Pedro Almeida', 'Pedrinho40', '2000-09-05', 'pedro.almeida@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 8, 1, '14785236987'),
('Lucas Fernandes', 'Luquinhas50', '1999-11-18', 'lucas.fernandes@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 9, 1, '36985214765'),
('Isabela Santos', 'Belinha60', '1997-04-30', 'isabela.santos@gmail.com', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 10, 2, '25874196385');


INSERT INTO cliente (endereco, cep, cidade, estado, id_usuario) 
VALUES ('Av. Paulista, 1000', '01310-100', 'São Paulo', 'SP', 1),
       ('Rua da Lapa, 200', '20021-180', 'Rio de Janeiro', 'RJ', 2),
       ('Rua Augusta, 300', '01305-001', 'São Paulo', 'SP', 3),
       ('Rua das Flores, 400', '78010-000', 'Cuiabá', 'MT', 4),
       ('Av. Tocantins, 500', '77015-002', 'Palmas', 'TO', 5);

INSERT INTO funcionario (cargo, salario, id_usuario) 
VALUES ('Analista de Sistemas', 6000.00, 6), 
       ('Desenvolvedor Full Stack', 4500.00, 7),
       ('Analista de Suporte', 4000.00, 8),
       ('Estagiário de TI', 2500.00, 9),
       ('Estagiário de TI', 2500.00, 10),
       ('Estagiária de Marketing', 2500.00, 11);


-- Inserir autores
INSERT INTO autor (nome, biografia) VALUES ('Colleen Hoover', 'Colleen Hoover é uma escritora norte-americana que escreve principalmente romances nos gêneros romântico e ficção para jovens adultos. Muitos de seus trabalhos foram autopublicados antes de serem adquiridos por uma editora.');
INSERT INTO autor (nome, biografia) VALUES ('Ali Hazelwood', 'Ali Hazelwood é uma autora italiana, que viveu em diversos países antes de se mudar para os Estados Unidos para se doutorar em Neurociência. Que conquistou o mundo da literatura com seus romances de ficção científica que combinam humor, inteligência e romance');
INSERT INTO autor (nome, biografia) VALUES ('Augusto Cury', 'Augusto Jorge Cury é um psiquiatra, professor e escritor brasileiro. Augusto é autor da Teoria da Inteligência Multifocal e seus livros foram publicados em mais de 70 países, com mais de 25 milhões de livros vendidos somente no Brasil.');
INSERT INTO autor (nome, biografia) VALUES ('Nicholas Sparks', 'Nicholas Charles Sparks é um escritor norte-americano. Ele é conhecido por suas novelas românticas, muitas das quais se passam em Carolina do Norte, onde Sparks cresceu. Suas obras incluem O Diário da Nossa Paixão, Um Amor Para Recordar e Querido John.');
INSERT INTO autor (nome, biografia) VALUES ('J.K. Rowling', 'Joanne Rowling, mais conhecida pelo pseudônimo J.K. Rowling, é uma escritora, roteirista e produtora cinematográfica britânica, mundialmente famosa pela série de livros Harry Potter.');
INSERT INTO autor (nome, biografia) VALUES ('George Orwell', 'George Orwell foi um escritor e jornalista inglês. Sua obra é marcada por uma inteligência perspicaz e uma consciência profunda da injustiça social. Suas obras mais famosas incluem 1984 e A Revolução dos Bichos.');

-- Inserir gênero
INSERT INTO genero (nome, descricao) VALUES ('Romance', 'Livros que enfocam em relacionamentos amorosos e desenvolvimento emocional dos personagens.');
INSERT INTO genero (nome, descricao) VALUES ('Ficção Científica', 'Gênero literário que lida principalmente com cenários futuristas, tecnologia avançada e outras ciências e tecnologias imaginárias.');
INSERT INTO genero (nome, descricao) VALUES ('Suspense', 'Gênero literário que cria um sentimento de excitação ou tensão emocional no leitor, frequentemente gerado por uma sequência de eventos inesperados.');
INSERT INTO genero (nome, descricao) VALUES ('Fantasia', 'Gênero literário que envolve elementos sobrenaturais, como magia, criaturas místicas e mundos imaginários.');
INSERT INTO genero (nome, descricao) VALUES ('Mistério', 'Gênero literário que envolve enigmas, investigações e situações inexplicáveis que desafiam a compreensão do leitor.');
INSERT INTO genero (nome, descricao) VALUES ('Aventura', 'Gênero literário que narra histórias emocionantes e cheias de ação, muitas vezes envolvendo viagens, descobertas e desafios perigosos.');

-- Inserir fornecedores
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Loja Moderna Ltda', '11.222.333/0001-99', '123456789', 'moderna@gmail.com', 'Av. Paulista, 1000 - Bela Vista', '01311-000', 'São Paulo', 'São Paulo', 300, 12);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Companhia das Letras Ltda', '55.444.666/0001-88', '987654321', 'letras@gmail.com', 'Rua Major Maragliano, 466 - Vila Mariana', '04015-001', 'São Paulo', 'São Paulo', 400, 13);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Sextante Ltda', '99.777.333/0001-55', '123654987', 'sextante@gmail.com', 'Rua Voluntários da Pátria, 41 - Botafogo', '22270-000', 'Rio de Janeiro', 'Rio de Janeiro', 350, 14);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livraria Cultura Ltda', '88.999.777/0001-66', '456123789', 'cultura@gmail.com', 'Av. Paulista, 2300 - Bela Vista', '01310-300', 'São Paulo', 'São Paulo', 500, 15);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Saraiva S.A.', '77.666.555/0001-44', '789456123', 'saraiva@gmail.com', 'Rua Henrique Schaumann, 270 - Pinheiros', '05413-000', 'São Paulo', 'São Paulo', 450, 16);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Editora Abril Ltda', '66.555.444/0001-33', '654987321', 'abril@gmail.com', 'Av. das Nações Unidas, 7221 - Pinheiros', '05425-070', 'São Paulo', 'São Paulo', 550, 17);

-- Inserir editora
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Atria Books', 'atriabooks@gmail.com', 'rua 10', 'nova york', 18);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Globo Livros', 'globolivros@gmail.com', 'Av. Sete de Setembro, 550 - Centro', 'Rio de Janeiro', 19);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Intrínseca', 'intrinseca@gmail.com', 'Rua Marquês de São Vicente, 99 - Gávea', 'Rio de Janeiro', 20);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Rocco', 'rocco@gmail.com', 'Rua Argentina, 171 - São Cristóvão', 'Rio de Janeiro', 21);

-- Inserir livro
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('Confess', 39.90, 50, '9781501176838', '2015-03-10', 'Confess é um romance contemporâneo escrito por Colleen Hoover. O livro foi publicado em 2015 e é centrado em Auburn Reed e Owen Gentry. Auburn tem um passado difícil e encontra Owen, um artista misterioso, enquanto trabalha em uma galeria de arte. Juntos, eles embarcam em uma jornada emocional, desvendando segredos e enfrentando desafios que testam seu amor.', 6, 1, 1);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('A Hipotese do Amor', 29.99, 100, '9780593336823', '2021-09-14', 'The Love Hypothesis é um romance contemporâneo escrito por Ali Hazelwood. O livro narra a história de Olive Smith, uma estudante de pós-graduação determinada a provar uma teoria científica sobre o amor. Com a ajuda de seu charmoso professor, eles embarcam em uma jornada de descoberta científica e pessoal.', 5, 2, 2);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('O Vendedor de Sonhos', 34.90, 80, '9788575429039', '2008-09-01', 'O Vendedor de Sonhos é um romance psicológico escrito por Augusto Cury. O livro conta a história de um homem misterioso que salva a vida de um suicida e o convence a acompanhar em uma jornada para mudar a sociedade através de sonhos e reflexões profundas sobre a vida.', 1, 1, 2);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('Harry Potter e a Pedra Filosofal', 49.90, 100, '9788532530802', '1997-06-26', 'Harry Potter é uma série de sete romances de fantasia escrita pela autora britânica J.K. Rowling. Os livros narram as aventuras de um jovem bruxo, Harry Potter, e seus amigos Hermione Granger e Ron Weasley, todos estudantes na Escola de Magia e Bruxaria de Hogwarts.', 4, 4, 4);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('1984', 35.00, 80, '9788532530803', '1949-06-08', '1984 é um romance distópico escrito por George Orwell em 1948 e publicado em 1949. A obra é um dos maiores clássicos da literatura mundial e uma das mais influentes e importantes do século XX.', 4, 6, 3);
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora) 
VALUES ('O Diário da Nossa Paixão', 29.90, 70, '9788532511666', '1996-10-01', 'O Diário da Nossa Paixão é um romance do escritor norte-americano Nicholas Sparks, que relata a história de amor entre Noah Calhoun e Allie Nelson, que se conhecem e se apaixonam durante um verão.', 3, 5, 2);

-- Inserir relacionamento entre livro e autor
INSERT INTO livro_autor (idlivro, idautor) VALUES (1, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (2, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (3, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (4, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (5, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (6, 6);

-- Inserir relacionamento entre livro e gênero
INSERT INTO livro_genero (idlivro, idgenero) VALUES (1, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (2, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (3, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (4, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (5, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (6, 1);

-- Avaliacao
INSERT INTO avaliacao (dataAvaliacao, estrela, id_livro, id_cliente) VALUES ('2023-01-22', 3, 1, 1);
INSERT INTO avaliacao (dataAvaliacao, estrela, id_livro, id_cliente, comentario)
                     VALUES ('2022-11-09', 4, 3, 2, 'muito legal');
INSERT INTO avaliacao (dataAvaliacao, estrela, id_livro, id_cliente) VALUES ('2023-02-08', 1, 2, 1);

-- forma de pagamento
INSERT INTO formaPagamento (valor, confirmacaoPagamento, dataPagamento) VALUES (511, true, '2023-06-10');
INSERT INTO formaPagamento (valor, confirmacaoPagamento, dataPagamento) VALUES (140.25, true, '2023-06-15');

-- pix
INSERT INTO pix (nome, cpf, dataExpiracaoTokenPix, id) VALUES ('Maria Souza', '98765432109', '2023-06-11', 1);

-- boleto
INSERT INTO boleto (id, nome, cpf, dataGeracaoBoleto, dataVencimento)
            VALUES (2, 'Maria Souza', '98765432109', '2023-06-15', '2023-06-25');

-- pedido
INSERT INTO pedido (dataPedido, valorTotal, ifPedidoFeito, id_formaPagamento, id_cliente)
            VALUES ('2023-06-10', 511, true, 1, 2);

INSERT INTO pedido (dataPedido, valorTotal, ifPedidoFeito, id_formaPagamento, id_cliente)
            VALUES ('2023-06-15', 140.25, true, 2, 2);

-- itemPedido
INSERT INTO itemPedido (desconto, quantidade, subtotal, id_livro) VALUES (3.00, 10, 270, 1);
INSERT INTO itemPedido (desconto, quantidade, subtotal, id_livro) VALUES (1.25, 5, 88.25, 2);
INSERT INTO itemPedido (desconto, quantidade, subtotal, id_livro) VALUES (0.90, 3, 52.60, 1);
INSERT INTO itemPedido (desconto, quantidade, subtotal, id_livro) VALUES (0.0, 2, 511, 3);
INSERT INTO itemPedido (desconto, quantidade, subtotal, id_livro) VALUES (0.0, 1, 140.25, 2);