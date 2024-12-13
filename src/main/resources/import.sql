-- Inserir telefone
INSERT INTO telefone (codigoArea, numero) VALUES 
('63', '995832165'), ('62', '965478912'), ('91', '953315987'), ('15', '924578563'), ('67', '923547896'), 
('55', '917589632'), ('56', '974512365'), ('31', '977771234'), ('41', '966669874'), ('51', '955558796'), 
('32', '977574125'), ('32', '974569823'), ('87', '922038745'), ('11', '912345678'), ('21', '987654321'), 
('31', '998765432'), ('41', '923456789'), ('51', '987654321'), ('61', '998765432'), ('71', '923456789'), 
('81', '987654321'), ('83', '956781234'), ('84', '923457689'), ('85', '967894512'), ('86', '934567890'), 
('88', '976543210'), ('89', '912340987'), ('95', '965437890'), ('96', '989012345'), ('97', '956789012'),  
('99', '978906543'), ('64', '989761234'), ('65', '923467890'), ('66', '967893412'), ('68', '934569012'), 
('69', '956780123'), ('70', '912345670'), ('72', '934567891'), ('73', '978901234'), ('98', '945671234'),
('74', '967890123');

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


INSERT INTO cliente (endereco, cep, cidade, estado, sigla, id_usuario) 
VALUES ('Av. Paulista, 1000', '01310-100', 'São Paulo', 'São Paulo', 'SP', 1),
       ('Rua da Lapa, 200', '20021-180', 'Rio de Janeiro', 'Rio de Janeiro', 'RJ', 2),
       ('Rua Augusta, 300', '01305-001', 'São Paulo', 'São Paulo', 'SP', 3),
       ('Rua das Flores, 400', '78010-000', 'Cuiabá', 'Mato Grosso', 'MT', 4),
       ('Av. Tocantins, 500', '77015-002', 'Palmas', 'Tocantins', 'TO', 5);

INSERT INTO funcionario (cargo, salario, id_usuario) 
VALUES ('Analista de Sistemas', 6000.00, 6), 
       ('Desenvolvedor Full Stack', 4500.00, 7),
       ('Analista de Suporte', 4000.00, 8),
       ('Estagiário de TI', 2500.00, 9),
       ('Estagiário de TI', 2500.00, 10),
       ('Estagiária de Marketing', 2500.00, 11);


-- Inserir autores
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Colleen Hoover', 'Colleen Hoover é uma escritora norte-americana que escreve principalmente romances nos gêneros romântico e ficção para jovens adultos. Muitos de seus trabalhos foram autopublicados antes de serem adquiridos por uma editora.', 'colleen_hoover.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Ali Hazelwood', 'Ali Hazelwood é uma autora italiana, que viveu em diversos países antes de se mudar para os Estados Unidos para se doutorar em Neurociência. Que conquistou o mundo da literatura com seus romances de ficção científica que combinam humor, inteligência e romance', 'ali_hazelwood.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Augusto Cury', 'Augusto Jorge Cury é um psiquiatra, professor e escritor brasileiro. Augusto é autor da Teoria da Inteligência Multifocal e seus livros foram publicados em mais de 70 países, com mais de 25 milhões de livros vendidos somente no Brasil.', 'augusto_cury.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Nicholas Sparks', 'Nicholas Charles Sparks é um escritor norte-americano. Ele é conhecido por suas novelas românticas, muitas das quais se passam em Carolina do Norte, onde Sparks cresceu. Suas obras incluem O Diário da Nossa Paixão, Um Amor Para Recordar e Querido John.', 'nicholas_sparks.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('J.K. Rowling', 'Joanne Rowling, mais conhecida pelo pseudônimo J.K. Rowling, é uma escritora, roteirista e produtora cinematográfica britânica, mundialmente famosa pela série de livros Harry Potter.', 'jk_rowling.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('George Orwell', 'George Orwell foi um escritor e jornalista inglês. Sua obra é marcada por uma inteligência perspicaz e uma consciência profunda da injustiça social. Suas obras mais famosas incluem 1984 e A Revolução dos Bichos.', 'george_orwell.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Virginia Woolf', 'Virginia Woolf foi uma escritora britânica e uma das figuras mais importantes do modernismo literário. Suas obras mais conhecidas incluem Mrs. Dalloway e Ao Farol.', 'virginia_woolf.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Isabel Allende', 'Isabel Allende é uma escritora chilena-americana conhecida por seus romances de realismo mágico. Entre suas obras mais famosas estão A Casa dos Espíritos e Eva Luna.', 'isabel_allende.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('J.R.R. Tolkien', 'J.R.R. Tolkien foi um escritor, professor e filólogo britânico, mundialmente conhecido por sua trilogia O Senhor dos Anéis e O Hobbit, que definiram o gênero de fantasia.', 'jrr_tolkien.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Margaret Atwood', 'Margaret Atwood é uma escritora canadense conhecida por suas obras de ficção especulativa e distopia feminista. Suas obras mais notáveis incluem O Conto da Aia e Oryx e Crake.', 'margaret_atwood.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Machado de Assis', 'Machado de Assis foi um escritor brasileiro e é considerado um dos maiores nomes da literatura brasileira. Suas obras mais famosas incluem Memórias Póstumas de Brás Cubas e Dom Casmurro.', 'machado_de_assis.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Jane Austen', 'Jane Austen foi uma escritora inglesa cujas obras abordam a condição das mulheres na sociedade inglesa do século XVIII. Seus romances mais conhecidos incluem Orgulho e Preconceito, Razão e Sensibilidade e Emma.', 'jane_austen.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Gabriel García Márquez', 'Gabriel García Márquez foi um escritor, jornalista, editor e ativista colombiano. Recebeu o Prêmio Nobel de Literatura em 1982 e é autor de Cem Anos de Solidão e O Amor nos Tempos do Cólera.', 'gabriel_garcia_marquez.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Stephen King', 'Stephen King é um escritor norte-americano conhecido por suas obras de terror, suspense e fantasia. Muitos de seus livros foram adaptados para o cinema, como O Iluminado, Carrie e A Espera de um Milagre.', 'stephen_king.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Chimamanda Ngozi Adichie', 'Chimamanda Ngozi Adichie é uma escritora e feminista nigeriana. Suas obras abordam temas como identidade cultural e questões de gênero, sendo autora de obras como Hibisco Roxo e Americanah.', 'chimamanda_ngozi_adichie.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Clarice Lispector', 'Clarice Lispector foi uma escritora e jornalista brasileira, conhecida por sua prosa introspectiva e poética. Entre suas obras mais aclamadas estão A Hora da Estrela e A Paixão Segundo G.H.', 'clarice_lispector.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Leo Tolstoy', 'Leo Tolstoy foi um escritor russo amplamente considerado um dos maiores romancistas de todos os tempos. Suas obras mais conhecidas incluem Guerra e Paz e Anna Karenina.','Leo_Tolstoy.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Ernest Hemingway', 'Ernest Hemingway foi um escritor e jornalista norte-americano, conhecido por seu estilo econômico e minimalista. Suas principais obras incluem O Velho e o Mar, Por Quem os Sinos Dobram e Adeus às Armas.','Ernest_Hemingway.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Agatha Christie', 'Agatha Christie foi uma escritora britânica conhecida por seus romances policiais, especialmente aqueles estrelados por Hercule Poirot e Miss Marple. É uma das autoras mais vendidas de todos os tempos.','Agatha_Christie.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Harper Lee', 'Harper Lee foi uma escritora norte-americana conhecida por seu romance clássico O Sol é Para Todos, que aborda temas de justiça social, racismo e infância no sul dos Estados Unidos.','Harper_Lee.jpg');
INSERT INTO autor (nome, biografia, nomeImagem) VALUES ('Fyodor Dostoevsky', 'Fyodor Dostoevsky foi um escritor e filósofo russo. Ele explorou temas complexos de psicologia e moralidade em seus livros, como Crime e Castigo e Os Irmãos Karamazov.','Fyodor_Dostoevsky.jpg');

-- Inserir gênero
INSERT INTO genero (nome, descricao) VALUES ('Romance', 'Livros que enfocam em relacionamentos amorosos e desenvolvimento emocional dos personagens.');
INSERT INTO genero (nome, descricao) VALUES ('Ficção Científica', 'Gênero literário que lida principalmente com cenários futuristas, tecnologia avançada e outras ciências e tecnologias imaginárias.');
INSERT INTO genero (nome, descricao) VALUES ('Suspense', 'Gênero literário que cria um sentimento de excitação ou tensão emocional no leitor, frequentemente gerado por uma sequência de eventos inesperados.');
INSERT INTO genero (nome, descricao) VALUES ('Fantasia', 'Gênero literário que envolve elementos sobrenaturais, como magia, criaturas místicas e mundos imaginários.');
INSERT INTO genero (nome, descricao) VALUES ('Mistério', 'Gênero literário que envolve enigmas, investigações e situações inexplicáveis que desafiam a compreensão do leitor.');
INSERT INTO genero (nome, descricao) VALUES ('Aventura', 'Gênero literário que narra histórias emocionantes e cheias de ação, muitas vezes envolvendo viagens, descobertas e desafios perigosos.');
INSERT INTO genero (nome, descricao) VALUES ('Drama', 'Gênero literário que enfoca temas sérios e realistas, explorando emoções e conflitos profundos dos personagens.');
INSERT INTO genero (nome, descricao) VALUES ('Horror', 'Gênero literário que busca evocar medo e suspense, muitas vezes com elementos sobrenaturais ou grotescos.');
INSERT INTO genero (nome, descricao) VALUES ('Histórico', 'Gênero literário que se passa em épocas passadas e se baseia em eventos históricos reais ou fictícios.');
INSERT INTO genero (nome, descricao) VALUES ('Biografia', 'Gênero literário que narra a vida de uma pessoa real, focando em eventos, realizações e desafios de sua trajetória.');
INSERT INTO genero (nome, descricao) VALUES ('Autoajuda', 'Gênero literário que oferece conselhos e orientações para o desenvolvimento pessoal e aprimoramento da vida do leitor.');
INSERT INTO genero (nome, descricao) VALUES ('Distopia', 'Gênero literário que explora sociedades futuristas com elementos autoritários e opressores, frequentemente para fins de crítica social.');
INSERT INTO genero (nome, descricao) VALUES ('Poesia', 'Gênero literário que utiliza linguagem figurada, ritmo e métrica para expressar emoções e ideias de forma artística.');
INSERT INTO genero (nome, descricao) VALUES ('Ensaios', 'Gênero literário que consiste em textos curtos e reflexivos, discutindo temas variados com uma abordagem pessoal ou crítica.');
INSERT INTO genero (nome, descricao) VALUES ('Realismo Mágico', 'Gênero literário que mistura elementos fantásticos com descrições realistas do cotidiano.');
INSERT INTO genero (nome, descricao) VALUES ('Literatura Infantil', 'Gênero literário voltado para crianças, muitas vezes com temas educativos, aventuras e mensagens sobre moralidade.');
INSERT INTO genero (nome, descricao) VALUES ('Jovem Adulto', 'Gênero literário voltado para jovens adultos, abordando temas como autodescoberta, amizade, amor e desafios da adolescência.');
INSERT INTO genero (nome, descricao) VALUES ('Policial', 'Gênero literário centrado em crimes e investigações, geralmente protagonizado por detetives ou policiais.');
INSERT INTO genero (nome, descricao) VALUES ('Humor', 'Gênero literário que utiliza situações cômicas, sátiras e ironia para entreter e fazer o leitor rir.');
INSERT INTO genero (nome, descricao) VALUES ('Épico', 'Gênero literário que narra feitos heroicos e aventuras grandiosas, geralmente em contextos mitológicos ou históricos.');

-- Inserir fornecedores
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Loja Moderna Ltda', '11.222.333/0001-99', '123456789', 'moderna@gmail.com', 'Av. Paulista, 1000 - Bela Vista', '01311-000', 'São Paulo', 'São Paulo', 300, 12);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Companhia das Letras Ltda', '55.444.666/0001-88', '987654321', 'letras@gmail.com', 'Rua Major Maragliano, 466 - Vila Mariana', '04015-001', 'São Paulo', 'São Paulo', 400, 13);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Sextante Ltda', '99.777.333/0001-55', '123654987', 'sextante@gmail.com', 'Rua Voluntários da Pátria, 41 - Botafogo', '22270-000', 'Rio de Janeiro', 'Rio de Janeiro', 350, 14);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livraria Cultura Ltda', '88.999.777/0001-66', '456123789', 'cultura@gmail.com', 'Av. Paulista, 2300 - Bela Vista', '01310-300', 'São Paulo', 'São Paulo', 500, 15);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Saraiva S.A.', '77.666.555/0001-44', '789456123', 'saraiva@gmail.com', 'Rua Henrique Schaumann, 270 - Pinheiros', '05413-000', 'São Paulo', 'São Paulo', 450, 16);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Editora Abril Ltda', '66.555.444/0001-33', '654987321', 'abril@gmail.com', 'Av. das Nações Unidas, 7221 - Pinheiros', '05425-070', 'São Paulo', 'São Paulo', 550, 17);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livros do Brasil Ltda', '98.765.432/0001-10', '998877665', 'livrosbr@gmail.com', 'Av. Ipiranga, 200 - Centro', '01046-010', 'São Paulo', 'São Paulo', 250, 19);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livraria Martins Fontes Ltda', '44.555.666/0001-33', '445566778', 'martinsfontes@gmail.com', 'Av. Paulista, 509 - Bela Vista', '01311-100', 'São Paulo', 'São Paulo', 420, 21);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Editora Planeta Ltda', '22.333.444/0001-11', '223344556', 'planeta@gmail.com', 'Rua dos Três Irmãos, 230 - Butantã', '05571-020', 'São Paulo', 'São Paulo', 310, 22);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Editora Melhoramentos Ltda', '66.777.888/0001-55', '667788990', 'melhoramentos@gmail.com', 'Rua Tito, 479 - Vila Romana', '05051-000', 'São Paulo', 'São Paulo', 290, 24);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Livraria Nobel Ltda', '77.888.999/0001-66', '778899001', 'nobel@gmail.com', 'Rua Augusta, 1500 - Consolação', '01304-001', 'São Paulo', 'São Paulo', 280, 25);
INSERT INTO fornecedor (nome, cnpj, inscricaoEstadual, email, endereco, cep, estado, cidade, quantLivrosFornecido, id_telefone) VALUES ('Distribuidora de Livros RJ Ltda', '88.999.111/0001-77', '889911223', 'livrosrj@gmail.com', 'Rua da Passagem, 180 - Botafogo', '22290-030', 'Rio de Janeiro', 'Rio de Janeiro', 330, 26);

-- Inserir editora
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Atria Books', 'atriabooks@gmail.com', 'rua 10', 'nova york', 18);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Globo Livros', 'globolivros@gmail.com', 'Av. Sete de Setembro, 550 - Centro', 'Rio de Janeiro', 19);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Intrínseca', 'intrinseca@gmail.com', 'Rua Marquês de São Vicente, 99 - Gávea', 'Rio de Janeiro', 20);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Rocco', 'rocco@gmail.com', 'Rua Argentina, 171 - São Cristóvão', 'Rio de Janeiro', 21);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Companhia das Letras', 'letras@gmail.com', 'Rua Major Maragliano, 466 - Vila Mariana', 'São Paulo', 13);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Sextante', 'sextante@gmail.com', 'Rua Voluntários da Pátria, 41 - Botafogo', 'Rio de Janeiro', 14);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Abril', 'abril@gmail.com', 'Av. das Nações Unidas, 7221 - Pinheiros', 'São Paulo', 17);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Melhoramentos', 'melhoramentos@gmail.com', 'Rua Tito, 479 - Vila Romana', 'São Paulo', 24);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Penguin Random House', 'penguinrandomhouse@gmail.com', '1745 Broadway', 'Nova York', 28);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('HarperCollins', 'harpercollins@gmail.com', '195 Broadway', 'Nova York', 29);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Simon & Schuster', 'simonandschuster@gmail.com', '1230 Avenue of the Americas', 'Nova York', 30);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Macmillan Publishers', 'macmillan@gmail.com', '120 Broadway', 'Nova York', 31);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Houghton Mifflin Harcourt', 'hmh@gmail.com', '125 High Street', 'Boston', 32);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Planeta do Brasil', 'planeta@gmail.com', 'Rua dos Três Irmãos, 230 - Butantã', 'São Paulo', 22);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('Editora Record', 'record@gmail.com', 'Rua Argentina, 171 - São Cristóvão', 'Rio de Janeiro', 33);
INSERT INTO editora (nome, email, endereco, estado, id_telefone) VALUES ('DarkSide Books', 'darkside@gmail.com', 'Rua Estados Unidos, 2109 - Jardim América', 'São Paulo', 34);

-- Inserir livro
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('Confess', 100.00, 50, '9781501176838', '10-03-2015', 'Confess é um romance contemporâneo escrito por Colleen Hoover. O livro foi publicado em 2015 e é centrado em Auburn Reed e Owen Gentry. Auburn tem um passado difícil e encontra Owen, um artista misterioso, enquanto trabalha em uma galeria de arte. Juntos, eles embarcam em uma jornada emocional, desvendando segredos e enfrentando desafios que testam seu amor.', 6, 1, 1, 'confess.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('A Hipotese do Amor', 29.99, 100, '9780593336823', '14-09-2021', 'The Love Hypothesis é um romance contemporâneo escrito por Ali Hazelwood. O livro narra a história de Olive Smith, uma estudante de pós-graduação determinada a provar uma teoria científica sobre o amor. Com a ajuda de seu charmoso professor, eles embarcam em uma jornada de descoberta científica e pessoal.', 5, 2, 2, 'a_hipotese_do_amor.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('O Vendedor de Sonhos', 34.90, 80, '9788575429039', '01-09-2008', 'O Vendedor de Sonhos é um romance psicológico escrito por Augusto Cury. O livro conta a história de um homem misterioso que salva a vida de um suicida e o convence a acompanhar em uma jornada para mudar a sociedade através de sonhos e reflexões profundas sobre a vida.', 1, 1, 2, 'o_vendedor_de_sonhos.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('Harry Potter e a Pedra Filosofal', 49.90, 100, '9788532530802', '26-06-1997', 'Harry Potter é uma série de sete romances de fantasia escrita pela autora britânica J.K. Rowling. Os livros narram as aventuras de um jovem bruxo, Harry Potter, e seus amigos Hermione Granger e Ron Weasley, todos estudantes na Escola de Magia e Bruxaria de Hogwarts.', 4, 4, 4, 'harry_potter_e_a_pedra_filosofal.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('1984', 35.00, 80, '9788532530803', '08-06-1949', '1984 é um romance distópico escrito por George Orwell em 1948 e publicado em 1949. A obra é um dos maiores clássicos da literatura mundial e uma das mais influentes e importantes do século XX.', 4, 6, 3, '1984.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem) 
VALUES ('O Diário da Nossa Paixão', 29.90, 70, '9788532511666', '01-10-1996', 'O Diário da Nossa Paixão é um romance do escritor norte-americano Nicholas Sparks, que relata a história de amor entre Noah Calhoun e Allie Nelson, que se conhecem e se apaixonam durante um verão.', 3, 5, 2, 'o_diário_da_nossa_paixao.jpg');

-- Colleen Hoover
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('É assim que acaba', 39.90, 40, '9781501110368', '02-08-2016', 'Romance poderoso sobre sobrevivência e a complexidade das relações familiares. A história segue Lily Bloom e seu relacionamento com Ryle e o reencontro com seu primeiro amor, Atlas.', 5, 1, 1, 'e_assim_que_acaba.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Verity', 44.90, 30, '9781791392796', '07-12-2018', 'Thriller psicológico e romance. Lowen Ashleigh é convidada a terminar os livros de Verity, uma escritora famosa em coma. Ao descobrir segredos perturbadores, ela se vê envolvida em uma trama de suspense e amor.', 5, 1, 1, 'verity.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Ugly Love', 36.90, 25, '9781476753188', '05-08-2014', 'Romance sobre o relacionamento complicado entre Tate Collins e o piloto Miles Archer. Ambos decidem ter uma relação sem compromisso, mas sentimentos começam a surgir, testando os limites do acordo.', 4, 1, 1, 'ugly_love.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Maybe Someday', 42.90, 20, '9781476753171', '18-03-2014', 'A história de Sydney e Ridge, que se apaixonam através da música. Ambos têm que lidar com os desafios de amar alguém que não podem ter.', 5, 1, 1, 'maybe_someday.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Reminders of Him', 45.90, 50, '9781542025607', '18-01-2022', 'Após cumprir pena na prisão, Kenna Rowan tenta reconectar-se com sua filha e se redimir por seus erros do passado. Um romance sobre perdão, reconciliação e segundas chances.', 5, 1, 1, 'reminders_of_him.jpg');

-- Ali Hazelwood
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('The Love Hypothesis', 47.90, 35, '9780593336823', '14-09-2021', 'Comédia romântica no ambiente acadêmico. Olive, uma estudante de PhD, finge um relacionamento com o professor Adam Carlsen para evitar constrangimento social, mas as coisas começam a se complicar.', 5, 1, 2, 'the_love_hypothesis.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Love on the Brain', 46.50, 40, '9780593336847', '23-08-2022', 'Romance e comédia no mundo científico. Bee Königswasser precisa trabalhar com seu rival Levi Ward em um projeto da NASA, e sentimentos conflitantes começam a surgir.', 5, 1, 2, 'love_on_the_brain.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Under One Roof', 35.90, 25, '9780593501887', '03-05-2022', 'Uma novela de comédia romântica que aborda a vida de uma jovem cientista que inesperadamente se vê dividindo casa com seu arqui-inimigo.', 4, 1, 2, 'under_one_roof.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Stuck with You', 35.90, 20, '9780593502853', '07-06-2022', 'Em uma história divertida e com toques de romance, dois engenheiros são obrigados a passar um tempo juntos em um ambiente claustrofóbico, o que os obriga a confrontar seus sentimentos.', 4, 1, 2, 'stuck_with_you.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Below Zero', 36.50, 20, '9780593502860', '05-07-2022', 'História romântica entre dois cientistas em uma expedição perigosa ao Ártico. Eles descobrem que há mais do que apenas trabalho os unindo.', 4, 1, 2, 'below_zero.jpg');

-- Augusto Cury
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Ansiedade - Como Enfrentar o Mal do Século', 41.50, 30, '9788543105322', '15-05-2013', 'Neste livro, Cury oferece estratégias para gerenciar a ansiedade e conquistar uma mente mais tranquila e resiliente.', 5, 1, 3, 'ansiedade_como_enfrentar_o_mal_do_seculo.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Colecionador de Lágrimas', 42.90, 30, '9788575427919', '10-08-2012', 'Romance que mescla história e ficção. Um professor de história viaja ao passado e vive experiências relacionadas à Segunda Guerra Mundial, aprendendo sobre o valor da vida.', 5, 1, 3, 'o_colecionador_de_lagrimas.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Homem Mais Inteligente da História', 43.90, 40, '9788543107395', '12-10-2016', 'Uma história sobre autoconhecimento e o poder da mente, onde um psiquiatra tenta entender a mente de Jesus Cristo.', 5, 1, 3, 'o_homem_mais_inteligente_da_historia.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Treinando a Emoção Para Ser Feliz', 39.90, 30, '9788575426134', '20-06-2008', 'Augusto Cury ensina como gerenciar emoções, a fim de alcançar a felicidade e equilíbrio emocional.', 4, 1, 3, 'treinando_a_emocao_para_ser_feliz.jpg');

-- Nicholas Sparks
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Um Amor para Recordar', 37.90, 40, '9788580413950', '01-10-1999', 'Jamie e Landon se apaixonam inesperadamente em uma história de amor e perda.', 5, 1, 1, 'um_amor_para_recordar.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Querido John', 38.90, 45, '9788580412984', '01-10-2006', 'Soldado John Tyree e Savannah Curtis enfrentam os desafios de um relacionamento à distância durante a guerra.', 5, 1, 1, 'querido_john.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Última Música', 42.50, 35, '9788580410157', '01-09-2009', 'Ronnie, uma adolescente rebelde, passa o verão com seu pai e redescobre a importância do amor familiar.', 5, 1, 1, 'a_ultima_musica.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Noites de Tormenta', 39.90, 30, '9788580410447', '01-09-2002', 'Adrienne e Paul compartilham um breve, mas intenso, romance que muda suas vidas para sempre.', 4, 1, 1, 'noites_de_tormenta.jpg');

-- J.K. Rowling
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Harry Potter e a Câmara Secreta', 42.90, 55, '9780747538486', '02-07-1998', 'Harry retorna para o segundo ano em Hogwarts e descobre a Câmara Secreta, enfrentando perigos com seus amigos.', 5, 1, 2, 'harry_potter_e_a_camara_secreta.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Harry Potter e o Prisioneiro de Azkaban', 44.90, 50, '9780747542155', '08-07-1999', 'Harry descobre o passado de seus pais e enfrenta Sirius Black, que escapou de Azkaban.', 5, 1, 2, 'harry_potter_e_o_prisioneiro_de_askaban.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Harry Potter e o Cálice de Fogo', 49.90, 45, '9780747546245', '08-07-2000', 'Harry é misteriosamente inscrito no Torneio Tribruxo e enfrenta desafios perigosos em sua quarta aventura.', 5, 1, 2, 'harry_potter_e_o_calice_de_fogo.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Harry Potter e a Ordem da Fênix', 54.90, 40, '9780747551003', '21-06-2003', 'Harry lidera um grupo de estudantes para resistir ao retorno de Voldemort e a opressão do Ministério da Magia.', 5, 1, 2, 'harry_potter_e_a_ordem_da_fenix.jpg');

-- George Orwell
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Revolução dos Bichos', 34.90, 45, '9780451526342', '17-08-1945', 'Uma fábula satírica onde os animais de uma fazenda se revoltam contra seus donos humanos, simbolizando regimes autoritários.', 5, 1, 3, 'a_revolucao_dos_bichos.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Dias na Birmânia', 37.90, 30, '9780156148504', '01-10-1934', 'Romance que explora o colonialismo britânico na Birmânia e seus efeitos na sociedade local e nos colonizadores.', 4, 1, 3, 'dias_na_birmania.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Lutando na Espanha', 41.50, 25, '9780156551625', '01-01-1938', 'Orwell relata suas experiências na Guerra Civil Espanhola, explorando as ideologias e conflitos que presenciou.', 4, 1, 3, 'lutando_na_espanha.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Caminho para Wigan Pier', 36.90, 20, '9780156886529', '01-03-1937', 'Orwell descreve a vida da classe trabalhadora britânica e critica as desigualdades sociais da época.', 4, 1, 3, 'o_caminho_para_wigan_pier.jpg');

-- Virginia Woolf
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Mrs. Dalloway', 39.90, 50, '9780156628709', '14-05-1925', 'Romance que acompanha um dia na vida de Clarissa Dalloway em Londres, explorando temas de tempo e identidade.', 5, 1, 1, 'mrs_dalloway.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Ao Farol', 34.90, 40, '9780156907392', '05-05-1927', 'Um romance introspectivo que explora as complexidades da dinâmica familiar e o papel do tempo.', 5, 1, 1, 'ao_farol.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Orlando', 36.50, 35, '9780156701600', '11-10-1928', 'A história de Orlando, que vive através dos séculos e muda de gênero, desafiando as normas da época.', 4, 1, 1, 'orlando.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('As Ondas', 38.90, 30, '9780156949606', '08-10-1931', 'Explora as vidas de seis amigos e suas experiências, representando as emoções humanas em um estilo poético.', 5, 1, 1, 'as_ondas.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Um Teto Todo Seu', 31.90, 25, '9780156787339', '24-10-1929', 'Um ensaio sobre o papel das mulheres na literatura e a importância da liberdade financeira e criativa.', 4, 1, 1, 'um_teto_todo_seu.jpg');

-- Isabel Allende
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Casa dos Espíritos', 42.90, 45, '9788535902772', '01-10-1982', 'Saga familiar que mistura realismo mágico e elementos históricos do Chile.', 5, 1, 1, 'a_casa_dos_espiritos.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Eva Luna', 39.90, 40, '9780060833303', '01-11-1987', 'Romance sobre Eva, uma contadora de histórias, que explora o amor e a luta social na América Latina.', 5, 1, 1, 'eva_luna.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('De Amor e de Sombra', 37.90, 35, '9780061120258', '01-10-1984', 'História de amor em tempos de ditadura, explorando os temas de resistência e coragem.', 5, 1, 1, 'de_amor_e_de_sombra.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Paula', 31.90, 30, '9780061564908', '01-10-1994', 'Memórias da autora escritas enquanto sua filha, Paula, estava em coma.', 5, 1, 1, 'paula.jpg');

-- J.R.R. Tolkien
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Hobbit', 39.90, 50, '9780261102217', '21-09-1937', 'Bilbo Bolseiro embarca em uma aventura épica na Terra Média.', 5, 1, 1, 'o_hobbit.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Sociedade do Anel', 44.90, 60, '9780261103573', '29-07-1954', 'Primeiro volume de O Senhor dos Anéis, onde Frodo começa sua jornada para destruir o Um Anel.', 5, 1, 1, 'a_sociedade_do_anel.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('As Duas Torres', 44.90, 55, '9780261103580', '11-11-1954', 'Segundo volume de O Senhor dos Anéis, onde a Irmandade se separa e enfrenta novos perigos.', 5, 1, 1, 'as_duas_torres.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Retorno do Rei', 46.90, 50, '9780261103597', '20-10-1955', 'Último volume de O Senhor dos Anéis, onde a guerra pela Terra Média atinge seu clímax.', 5, 1, 1, 'o_retorno_do_rei.jpg');

-- Margaret Atwood
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Conto da Aia', 35.90, 50, '9780385490818', '17-03-1985', 'Distopia em que mulheres são tratadas como propriedade do estado em uma sociedade teocrática.', 5, 1, 1, 'o_conto_da_aia.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Oryx e Crake', 38.90, 45, '9780385721677', '01-05-2003', 'Explora temas de bioética e biotecnologia em um mundo pós-apocalíptico.', 5, 1, 1, 'oryx_e_crake.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Alias Grace', 36.90, 40, '9780385490443', '01-09-1996', 'Baseado em uma história real, explora temas de culpa e injustiça no Canadá do século XIX.', 5, 1, 1, 'alias_grace.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Ano do Dilúvio', 34.90, 35, '9780307455475', '08-09-2009', 'Romance de ficção científica que se passa em um mundo pós-apocalíptico devastado por desastres ambientais.', 5, 1, 1, 'o_ano_do_diluvio.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('MaddAddão', 37.90, 30, '9780385538947', '29-08-2013', 'Conclusão da trilogia distópica iniciada com Oryx e Crake, explorando os últimos remanescentes da humanidade.', 5, 1, 1, 'maddaddao.jpg');

-- Machado de Assis
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Quincas Borba', 29.90, 35, '9780195106831', '01-01-1891', 'A história de Rubião, discípulo do filósofo Quincas Borba, que herda sua fortuna e busca seu lugar na sociedade.', 5, 1, 1,'quincas_borba.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Esaú e Jacó', 30.90, 30, '9780195106848', '01-01-1904', 'Romance que explora temas de rivalidade fraternal e instabilidade política no Brasil.', 5, 1, 1, 'esau_e_jaco.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Memorial de Aires', 28.90, 28, '9780195106855', '01-01-1908', 'Último romance de Machado de Assis, narrado pelo diplomata Aires, que reflete sobre a vida e as relações humanas.', 5, 1, 1, 'memorial_de_aires.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Memórias Póstumas de Brás Cubas', 30.90, 40, '9780140448078', '01-01-1881', 'Narrado por um defunto, explora temas como ironia e crítica à sociedade.', 5, 1, 1, 'memorias_postumas_de_bras_cubas.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Dom Casmurro', 32.90, 45, '9780195106817', '01-01-1899', 'Romance que explora ciúmes, traição e dúvidas existenciais.', 5, 1, 1, 'dom_casmurro.jpg');

-- Jane Austen
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Orgulho e Preconceito', 25.90, 40, '9780141439518', '28-01-1813', 'A clássica história de amor entre Elizabeth Bennet e o sr. Darcy, abordando temas de orgulho, preconceito e moralidade.', 5, 1, 1, 'orgulho_e_preconceito.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Razão e Sensibilidade', 27.90, 35, '9780141439822', '30-10-1811', 'Segue a vida de duas irmãs, Elinor e Marianne Dashwood, e suas buscas por amor e segurança.', 5, 1, 1,'razao_e_sensibilidade.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Emma', 28.90, 30, '9780141439587', '23-12-1815', 'Emma Woodhouse, uma jovem rica e esnobe, encontra desafios ao tentar manipular as vidas amorosas dos outros.', 5, 1, 1, 'emma.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Persuasão', 26.90, 25, '9780141439686', '20-12-1817', 'O romance conta a história de Anne Elliot, uma mulher que reencontra um antigo amor perdido.', 5, 1, 1, 'persuasao.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Mansfield Park', 27.50, 20, '9780141439808', '09-07-1814', 'Conta a história de Fanny Price e suas relações familiares em uma crítica social à elite britânica.', 5, 1, 1, 'mansfield_park.jpg');

-- Gabriel García Márquez
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Cem Anos de Solidão', 34.90, 40, '9780307474728', '30-05-1967', 'História épica da família Buendía em uma aldeia fictícia da Colômbia, com elementos de realismo mágico.', 5, 1, 1, 'cem_anos_de_solidao.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Amor nos Tempos do Cólera', 32.90, 35, '9780307389732', '05-06-1985', 'Romance sobre um amor que perdura ao longo de décadas, em um cenário latino-americano.', 5, 1, 1, 'o_amor_nos_tempos_do_colera.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Crônica de uma Morte Anunciada', 28.50, 30, '9780307388810', '01-01-1981', 'Relata o assassinato de Santiago Nasar em uma vila costeira, explorando o destino e o poder da comunidade.', 5, 1, 1, 'cronica_de_uma_morte_anunciada.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Ninguém Escreve ao Coronel', 26.50, 25, '9780060751579', '01-01-1961', 'O drama de um coronel esperando por sua pensão e refletindo sobre as promessas do governo.', 5, 1, 1, 'ninguem_escreve_ao_coronel.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O General em seu Labirinto', 30.90, 25, '9780307388940', '01-01-1989', 'Ficção histórica sobre Simón Bolívar e sua última jornada pela América Latina.', 5, 1, 1, 'o_general_em_seu_labirinto.jpg');

-- Stephen King
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('O Iluminado', 35.90, 50, '9780307743657', '28-01-1977', 'Jack Torrance e sua família mudam-se para o hotel Overlook, onde forças sobrenaturais revelam seu terror.', 5, 1, 1, 'o_iluminado.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('Carrie', 29.90, 45, '9780307743664', '05-04-1974', 'Uma jovem com poderes telecinéticos busca vingança contra colegas abusivos.', 5, 1, 1, 'carrie.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Espera de um Milagre', 32.90, 35, '9780671035785', '01-01-1996', 'Um condenado à morte em uma prisão dos EUA possui poderes misteriosos que desafiam os guardas.', 5, 1, 1, 'a_espera_de_um_milagre.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('It: A Coisa', 39.90, 30, '9781501182099', '15-09-1986', 'Um grupo de crianças enfrenta uma criatura demoníaca que assume várias formas e retorna a cada 27 anos.', 5, 1, 1, 'it_a_coisa.jpg');
INSERT INTO livro (titulo, preco, quantidadeEstoque, isbn, dataLancamento, descricao, classificacao, id_fornecedor, id_editora, nomeImagem)
VALUES ('A Zona Morta', 30.90, 28, '9781501192241', '01-08-1979', 'Um homem desperta de um coma e descobre que tem poderes premonitórios, o que o coloca em dilemas morais.', 5, 1, 1, 'a_zona_morta.jpg');


-- Inserir relacionamento entre livro e autor
INSERT INTO livro_autor (idlivro, idautor) VALUES (1, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (1, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (2, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (3, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (4, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (5, 6);
INSERT INTO livro_autor (idlivro, idautor) VALUES (6, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (7, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (8, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (9, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (10, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (11, 1);
INSERT INTO livro_autor (idlivro, idautor) VALUES (12, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (13, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (14, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (15, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (16, 2);
INSERT INTO livro_autor (idlivro, idautor) VALUES (17, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (18, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (19, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (20, 3);
INSERT INTO livro_autor (idlivro, idautor) VALUES (21, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (22, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (23, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (24, 4);
INSERT INTO livro_autor (idlivro, idautor) VALUES (25, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (26, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (27, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (28, 5);
INSERT INTO livro_autor (idlivro, idautor) VALUES (29, 6);
INSERT INTO livro_autor (idlivro, idautor) VALUES (30, 6);
INSERT INTO livro_autor (idlivro, idautor) VALUES (31, 6);
INSERT INTO livro_autor (idlivro, idautor) VALUES (32, 6);
INSERT INTO livro_autor (idlivro, idautor) VALUES (33, 7);
INSERT INTO livro_autor (idlivro, idautor) VALUES (34, 7);
INSERT INTO livro_autor (idlivro, idautor) VALUES (35, 7);
INSERT INTO livro_autor (idlivro, idautor) VALUES (36, 7);
INSERT INTO livro_autor (idlivro, idautor) VALUES (37, 7);
INSERT INTO livro_autor (idlivro, idautor) VALUES (38, 8);
INSERT INTO livro_autor (idlivro, idautor) VALUES (39, 8);
INSERT INTO livro_autor (idlivro, idautor) VALUES (40, 8);
INSERT INTO livro_autor (idlivro, idautor) VALUES (41, 8);
INSERT INTO livro_autor (idlivro, idautor) VALUES (42, 9);
INSERT INTO livro_autor (idlivro, idautor) VALUES (43, 9);
INSERT INTO livro_autor (idlivro, idautor) VALUES (44, 9);
INSERT INTO livro_autor (idlivro, idautor) VALUES (45, 9);
INSERT INTO livro_autor (idlivro, idautor) VALUES (46, 10);
INSERT INTO livro_autor (idlivro, idautor) VALUES (47, 10);
INSERT INTO livro_autor (idlivro, idautor) VALUES (48, 10);
INSERT INTO livro_autor (idlivro, idautor) VALUES (49, 10);
INSERT INTO livro_autor (idlivro, idautor) VALUES (50, 10);
INSERT INTO livro_autor (idlivro, idautor) VALUES (51, 11);
INSERT INTO livro_autor (idlivro, idautor) VALUES (52, 11);
INSERT INTO livro_autor (idlivro, idautor) VALUES (53, 11);
INSERT INTO livro_autor (idlivro, idautor) VALUES (54, 11);
INSERT INTO livro_autor (idlivro, idautor) VALUES (55, 11);
INSERT INTO livro_autor (idlivro, idautor) VALUES (56, 12);
INSERT INTO livro_autor (idlivro, idautor) VALUES (57, 12);
INSERT INTO livro_autor (idlivro, idautor) VALUES (58, 12);
INSERT INTO livro_autor (idlivro, idautor) VALUES (59, 12);
INSERT INTO livro_autor (idlivro, idautor) VALUES (60, 12);
INSERT INTO livro_autor (idlivro, idautor) VALUES (61, 13);
INSERT INTO livro_autor (idlivro, idautor) VALUES (62, 13);
INSERT INTO livro_autor (idlivro, idautor) VALUES (63, 13);
INSERT INTO livro_autor (idlivro, idautor) VALUES (64, 13);
INSERT INTO livro_autor (idlivro, idautor) VALUES (65, 13);
INSERT INTO livro_autor (idlivro, idautor) VALUES (66, 14);
INSERT INTO livro_autor (idlivro, idautor) VALUES (67, 14);
INSERT INTO livro_autor (idlivro, idautor) VALUES (68, 14);
INSERT INTO livro_autor (idlivro, idautor) VALUES (69, 14);
INSERT INTO livro_autor (idlivro, idautor) VALUES (70, 14);

-- Inserir relacionamento entre livro e gênero
INSERT INTO livro_genero (idlivro, idgenero) VALUES (1, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (2, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (3, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (4, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (5, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (6, 1);

-- Colleen Hoover
INSERT INTO livro_genero (idlivro, idgenero) VALUES (7, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (8, 3);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (9, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (10, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (11, 1);

-- Ali Hazelwood
INSERT INTO livro_genero (idlivro, idgenero) VALUES (12, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (12, 17);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (13, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (13, 2);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (14, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (15, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (16, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (16, 2);

-- Augusto Cury
INSERT INTO livro_genero (idlivro, idgenero) VALUES (17, 11);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (18, 3);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (18, 9);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (19, 11);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (20, 11);

-- Nicholas Sparks
INSERT INTO livro_genero (idlivro, idgenero) VALUES (21, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (22, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (23, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (24, 1);

-- J.K. Rowling
INSERT INTO livro_genero (idlivro, idgenero) VALUES (25, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (26, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (27, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (28, 4);

-- George Orweell
INSERT INTO livro_genero (idlivro, idgenero) VALUES (29, 12);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (30, 9);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (31, 9);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (32, 15);

-- Virginia Woolf
INSERT INTO livro_genero (idlivro, idgenero) VALUES (33, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (34, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (35, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (36, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (37, 15);

-- Isabel Allende
INSERT INTO livro_genero (idlivro, idgenero) VALUES (38, 16);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (39, 16);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (40, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (41, 10);

-- J.R.R Tolkien
INSERT INTO livro_genero (idlivro, idgenero) VALUES (42, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (43, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (44, 4);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (45, 4);

-- Margaret Atwood
INSERT INTO livro_genero (idlivro, idgenero) VALUES (46, 12);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (47, 12);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (48, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (49, 12);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (50, 12);

-- Machado de Assis
INSERT INTO livro_genero (idlivro, idgenero) VALUES (51, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (52, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (53, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (54, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (55, 7);

-- Jane Austen
INSERT INTO livro_genero (idlivro, idgenero) VALUES (56, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (57, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (58, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (59, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (60, 1);

-- Gabriel Garcia Márquez
INSERT INTO livro_genero (idlivro, idgenero) VALUES (61, 16);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (62, 16);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (63, 1);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (64, 7);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (65, 9);

-- Stephen King
INSERT INTO livro_genero (idlivro, idgenero) VALUES (66, 8);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (67, 8);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (68, 8);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (69, 8);
INSERT INTO livro_genero (idlivro, idgenero) VALUES (70, 8);

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

-- Inserindo dados corretos na tabela caixaLivro
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('O Senhor dos Anéis - A Trilogia Completa', 
'Contém a saga inteira de O Senhor dos Anéis, incluindo A Sociedade do Anel, As Duas Torres, e O Retorno do Rei.', 
79.90, 10, 1, 1, 1, 'box_O Senhor_dos_Aneis.jpg');

INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('O Hobbit + Senhor dos Aneis', 'Aventuras de Bilbo Bolseiro em busca do tesouro guardado por Smaug, o dragão.', 137.99, 22, 2, 2, 2, 'box_O_Hobbit.jpg');

INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('A História da Terra-média - Box 1', 'A história do mundo criado por J.R.R. Tolkien antes dos eventos de O Senhor dos Anéis.', 80.80, 33, 3, 3, 3, 'box_terra_media_1.jpg');

-- Colleen Hoover - Romance
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção Colleen Hoover - Romance', 'Esta caixa contém os livros "É Assim que Acaba", "Verity" e "Um Caso Perdido", abordando temas profundos de amor, trauma e superação.', 129.90, 15, 2, 1, 1, 'box_colleenHover.jpg');

-- Ali Hazelwood - Romance / Ficção Científica
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção Ali Hazelwood', 'Esta caixa inclui os livros "A Hipótese do Amor", "A Equação do Amor" e "Um Amor Científico", combinando romance com temas de ficção científica e acadêmicos.', 149.99, 18, 3, 2, 2, 'box_AliHazelwood.jpg');

-- Augusto Cury - Desenvolvimento Pessoal / Ficção
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção Augusto Cury - Desenvolvimento Pessoal', 'Esta caixa contém os livros "O Vendedor de Sonhos", "Ansiedade - Como Enfrentar o Mal do Século" e "O Futuro da Humanidade", explorando temas de psicologia e superação pessoal.', 119.99, 25, 4, 3, 3, 'box_AugustoCury.jpg');

-- Nicholas Sparks - Romance
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção Nicholas Sparks - Romance', 'Esta caixa inclui os livros "O Diário de Uma Paixão", "Um Amor para Recordar" e "Querido John", histórias emocionantes de amor e perda.', 139.90, 12, 1, 2, 1, 'box_NicholasSparks_Romance.jpg');

-- J.K. Rowling - Fantasia
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção Harry Potter - J.K. Rowling', 'Esta caixa inclui os três primeiros livros da série: "Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta" e "Harry Potter e o Prisioneiro de Azkaban".', 199.90, 30, 1, 1, 4, 'box_HarryPotter.jpg');

-- George Orwell - Distopia / Ficção Científica
INSERT INTO caixaLivro (nome, descricao, preco, quantidadeEmEstoque, id_fornecedor, id_editora, classificacao, nomeImagem)
VALUES ('Coleção George Orwell - Distopia', 'Esta caixa contém os livros "1984", "A Revolução dos Bichos" e "Dias na Birmânia", obras clássicas de Orwell que exploram temas de poder, controle e injustiça social.', 89.99, 20, 5, 3, 2, 'box_GeorgeOrwell_Distopia.jpg');

-- Inserir relacionamento entre livro e autor
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (1, 9);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (2, 9);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (3, 9);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (4, 1);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (5, 2);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (6, 3);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (7, 4);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (8, 5);
INSERT INTO caixa_autor (idcaixa, idautor) VALUES (9, 6);

-- -- Inserir relacionamento entre livro e gênero
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (1, 4);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (1, 20);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (1, 6);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (2, 2);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (2, 6);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (2, 16);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (3, 4);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (3, 20);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (3, 9);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (3, 6);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (4, 1);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (4, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (4, 17);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (5, 1);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (5, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (5, 17);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (6, 11);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (6, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (6, 13);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (7, 1);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (7, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (7, 6);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (8, 4);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (8, 6);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (8, 17);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (8, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (8, 5);

INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (9, 12);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (9, 9);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (9, 7);
INSERT INTO caixa_genero (idcaixa, idgenero) VALUES (9, 11);

-- Inserir sugestões associadas aos clientes
INSERT INTO Sugestao (sugestao, dataSugestao, id_cliente) VALUES
('Sugestão 1 do Cliente 1', '2023-06-15', 1),
('Sugestão 2 do Cliente 1', '2023-06-15', 1),
('Sugestão 1 do Cliente 2', '2023-06-15', 2);


INSERT INTO cupom (nomeCupom, desconto) VALUES ('CUPOM10', 0.90);
INSERT INTO cupom (nomeCupom, desconto) VALUES ('CUPOM20', 0.80);
INSERT INTO cupom (nomeCupom, desconto) VALUES ('CUPOM50', 0.50);
