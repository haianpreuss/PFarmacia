-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 01-Jul-2019 às 00:54
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trabalhofinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--
CREATE SCHEMA trabalhofinal;
USE trabalhofinal;


CREATE TABLE cliente (
  `cod_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(150) NOT NULL,
  `cpf_cliente` varchar(14) NOT NULL,
  `telefone_cliente` varchar(14) NOT NULL,
  `sexo_cliente` varchar(10) NOT NULL,
  `data_nascimento_cliente` date NOT NULL,
  `endereco_cod_endereco` int(11) NOT NULL,
  `deletado_cliente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `nome_cliente`, `cpf_cliente`, `telefone_cliente`, `sexo_cliente`, `data_nascimento_cliente`, `endereco_cod_endereco`, `deletado_cliente`) VALUES
(1, 'Sérgio Vinicius', '322.006.276-88', '(98)98634-7548', 'Masculino', '1946-09-22', 3, NULL),
(2, 'Jéssica Tereza Pires', '591.991.177-89', '(81)99254-1730', 'Feminino', '1989-09-07', 4, NULL),
(3, 'dsad', '123.213.123-12', '(32)13123-1231', 'Masculino', '2000-02-21', 7, 'd');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `cod_endereco` int(11) NOT NULL,
  `rua_endereco` varchar(100) NOT NULL,
  `numero_endereco` varchar(6) NOT NULL,
  `complemento_endereco` varchar(100) NOT NULL,
  `cep_endereco` varchar(9) NOT NULL,
  `cidade_endereco` varchar(100) NOT NULL,
  `uf_endereco` char(2) NOT NULL,
  `bairro_endereco` varchar(100) NOT NULL,
  `deletado_endereco` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`cod_endereco`, `rua_endereco`, `numero_endereco`, `complemento_endereco`, `cep_endereco`, `cidade_endereco`, `uf_endereco`, `bairro_endereco`, `deletado_endereco`) VALUES
(1, 'Rua São Bento', '691', 'casa', '69315-669', 'Boa Vista', 'RR', 'São Bento', NULL),
(2, 'Rua São Bento', '691', 'casa', '69315-669', 'Boa Vista', 'RR', 'São Bento', NULL),
(3, 'Rua 16 D', '320', 'casa', '65058-044', 'São Luíz', 'MA', 'Cidade Operária', NULL),
(4, 'Rua Canopus', '673', 'casa', '54160-537', 'Jabotão dos Guararapes', 'PE', 'Santana', NULL),
(5, 'Rua Aires Fernandes da Silva ', '212', 'Prédio one/0', '83402-215', 'Colombo', 'PR', 'Roça Grande', NULL),
(6, 'Rua XX', '894', 'Prédio Branca 32', '64603-110', 'Picos', 'PI', 'Belo Norte', NULL),
(7, 'Rua ABC', '123', 'casa', '12321-321', 'Paradas', 'OP', 'Cidadão', 'd'),
(8, 'Rua B ', '758', 'casa', '77897-798', 'Imperatriz', 'SC', 'Conjunto Nova Vitória', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `cod_estoque` int(11) NOT NULL,
  `quantidade_estoque` int(11) NOT NULL,
  `data_estoque` date NOT NULL,
  `lote_estoque` varchar(8) NOT NULL,
  `produto_cod_produto` int(11) NOT NULL,
  `deletado_estoque` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`cod_estoque`, `quantidade_estoque`, `data_estoque`, `lote_estoque`, `produto_cod_produto`, `deletado_estoque`) VALUES
(1, 20, '2021-06-28', 'xxx-0001', 1, NULL),
(3, 20, '2019-05-05', 'opk-1598', 4, NULL),
(4, 20, '2020-07-08', 'koe-7894', 4, NULL),
(5, 20, '2030-09-09', 'mts-7465', 2, NULL),
(6, 20, '2020-02-19', 'dsa-7894', 3, NULL),
(7, 20, '2023-07-20', 'vcx-4897', 5, NULL),
(8, 20, '2025-04-08', 'vcx-3399', 6, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `cod_fornecedor` int(11) NOT NULL,
  `nome_fornecedor` varchar(150) NOT NULL,
  `cnpj_fornecedor` varchar(19) NOT NULL,
  `telefone_fornecedor` varchar(14) NOT NULL,
  `endereco_cod_endereco` int(11) NOT NULL,
  `deletado_fornecedor` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cod_fornecedor`, `nome_fornecedor`, `cnpj_fornecedor`, `telefone_fornecedor`, `endereco_cod_endereco`, `deletado_fornecedor`) VALUES
(1, 'Medley', '15.974.983/2145-64', '(48)98745-1562', 5, NULL),
(2, 'EMS', '54.698.165/1851-65', '(11)98714-5132', 6, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_funcionario` int(11) NOT NULL,
  `nome_funcionario` varchar(150) NOT NULL,
  `cpf_funcionario` varchar(14) NOT NULL,
  `senha_pessoal_funcionario` varchar(8) DEFAULT NULL,
  `salario_funcionario` decimal(7,2) NOT NULL,
  `telefone_funcionario` varchar(14) NOT NULL,
  `data_nascimento_funcionario` date NOT NULL,
  `endereco_cod_endereco` int(11) NOT NULL,
  `deletado_funcionario` char(1) DEFAULT NULL,
  `nivel_funcionario` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`cod_funcionario`, `nome_funcionario`, `cpf_funcionario`, `senha_pessoal_funcionario`, `salario_funcionario`, `telefone_funcionario`, `data_nascimento_funcionario`, `endereco_cod_endereco`, `deletado_funcionario`, `nivel_funcionario`) VALUES
(1, 'Jennifer Lorena Jesus', '627.812.899-30', '12345678', '3000.00', '(95)99193-7600', '1984-02-17', 2, NULL, 0),
(2, 'Jaqueline Caroline Lorena Figueiredo', '232.128.977-59', '12345678', '2000.00', '(98)99944-3182', '2000-08-10', 8, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `cod_produto` int(11) NOT NULL,
  `descricao_produto` varchar(200) NOT NULL,
  `valor_produto` decimal(6,2) NOT NULL,
  `fornecedor_cod_fornecedor` int(11) NOT NULL,
  `deletado_produto` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`cod_produto`, `descricao_produto`, `valor_produto`, `fornecedor_cod_fornecedor`, `deletado_produto`) VALUES
(1, 'Paracetamol', '13.90', 1, NULL),
(2, 'Permetrina', '49.19', 1, NULL),
(3, 'Dapsona', '4.99', 1, NULL),
(4, 'Sulfadiazina', '21.50', 2, NULL),
(5, 'Ácido Fólico', '18.00', 2, NULL),
(6, 'Atenolol', '15.00', 2, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `cod_venda` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `hora_venda` time NOT NULL,
  `cliente_cod_cliente` int(11) NOT NULL,
  `funcionario_cod_funcionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`cod_venda`, `data_venda`, `hora_venda`, `cliente_cod_cliente`, `funcionario_cod_funcionario`) VALUES
(1, '2019-06-28', '21:05:26', 2, 1),
(3, '2019-06-28', '21:10:43', 1, 1),
(4, '2019-06-28', '21:18:46', 2, 2),
(5, '2019-06-28', '21:23:31', 1, 1),
(6, '2019-06-28', '21:23:47', 1, 1),
(7, '2019-06-28', '21:25:02', 1, 1),
(8, '2019-06-28', '21:28:04', 2, 1),
(9, '2019-06-30', '16:58:34', 1, 1),
(10, '2019-06-30', '18:06:07', 1, 1),
(11, '2019-06-30', '18:06:36', 1, 1),
(12, '2019-06-30', '18:35:24', 1, 1),
(13, '2019-06-30', '18:36:09', 1, 1),
(14, '2019-06-30', '18:37:40', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_produto`
--

CREATE TABLE `venda_produto` (
  `venda_cod_venda` int(11) NOT NULL,
  `produto_cod_produto` int(11) NOT NULL,
  `quantidade_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda_produto`
--

INSERT INTO `venda_produto` (`venda_cod_venda`, `produto_cod_produto`, `quantidade_produto`) VALUES
(1, 1, 3),
(1, 3, 2),
(1, 5, 5),
(3, 1, 4),
(4, 4, 3),
(4, 2, 3),
(4, 6, 3),
(5, 1, 5),
(6, 1, 16),
(7, 1, 16),
(7, 1, 16),
(7, 1, 16),
(7, 1, 16),
(7, 1, 16),
(7, 1, 16),
(7, 1, 16),
(8, 1, 2),
(8, 3, 3),
(8, 5, 4),
(9, 3, 10),
(9, 3, 10),
(9, 3, 10),
(10, 1, 10),
(11, 1, 15),
(12, 1, 20),
(13, 1, 20),
(14, 1, 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`),
  ADD KEY `endereco_cod_endereco` (`endereco_cod_endereco`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`cod_endereco`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`cod_estoque`),
  ADD KEY `produto_cod_produto` (`produto_cod_produto`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`cod_fornecedor`),
  ADD KEY `endereco_cod_endereco` (`endereco_cod_endereco`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`cod_funcionario`),
  ADD KEY `endereco_cod_endereco` (`endereco_cod_endereco`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`cod_produto`),
  ADD KEY `fornecedor_cod_fornecedor` (`fornecedor_cod_fornecedor`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`cod_venda`),
  ADD KEY `cliente_cod_cliente` (`cliente_cod_cliente`),
  ADD KEY `funcionario_cod_funcionario` (`funcionario_cod_funcionario`);

--
-- Indexes for table `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD KEY `venda_cod_venda` (`venda_cod_venda`),
  ADD KEY `produto_cod_produto` (`produto_cod_produto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `cod_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `cod_estoque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `cod_fornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `cod_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `cod_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`endereco_cod_endereco`) REFERENCES `endereco` (`cod_endereco`);

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`produto_cod_produto`) REFERENCES `produto` (`cod_produto`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`endereco_cod_endereco`) REFERENCES `endereco` (`cod_endereco`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`endereco_cod_endereco`) REFERENCES `endereco` (`cod_endereco`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`fornecedor_cod_fornecedor`) REFERENCES `fornecedor` (`cod_fornecedor`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`cliente_cod_cliente`) REFERENCES `cliente` (`cod_cliente`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`funcionario_cod_funcionario`) REFERENCES `funcionario` (`cod_funcionario`);

--
-- Limitadores para a tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD CONSTRAINT `venda_produto_ibfk_1` FOREIGN KEY (`venda_cod_venda`) REFERENCES `venda` (`cod_venda`),
  ADD CONSTRAINT `venda_produto_ibfk_2` FOREIGN KEY (`produto_cod_produto`) REFERENCES `produto` (`cod_produto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
