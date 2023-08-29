-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 31-Jan-2022 às 23:53
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `loja_de_veiculos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_caminhoes`
--

CREATE TABLE `tab_caminhoes` (
  `id` int(11) NOT NULL,
  `modelo` varchar(25) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `placa` varchar(8) DEFAULT NULL,
  `renavam` varchar(11) DEFAULT NULL,
  `chassi` varchar(17) DEFAULT NULL,
  `ano` smallint(4) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tracao` varchar(20) DEFAULT NULL,
  `cambio` varchar(20) DEFAULT NULL,
  `hp` smallint(5) DEFAULT NULL,
  `capacidade_de_carga` int(6) DEFAULT NULL,
  `disponivel` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_caminhoes`
--

INSERT INTO `tab_caminhoes` (`id`, `modelo`, `marca`, `placa`, `renavam`, `chassi`, `ano`, `preco`, `tracao`, `cambio`, `hp`, `capacidade_de_carga`, `disponivel`) VALUES
(1, 'caminhão1', 'mercedes', '123wdwd', '23123123w', '123123123', 2010, 30000, 'dianteira', 'manual', 600, 10000, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_carros`
--

CREATE TABLE `tab_carros` (
  `id` int(11) NOT NULL,
  `modelo` varchar(25) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `placa` varchar(8) DEFAULT NULL,
  `renavam` varchar(11) DEFAULT NULL,
  `chassi` varchar(17) DEFAULT NULL,
  `ano` smallint(4) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tracao` varchar(20) DEFAULT NULL,
  `cambio` varchar(20) DEFAULT NULL,
  `hp` smallint(5) DEFAULT NULL,
  `disponivel` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_carros`
--

INSERT INTO `tab_carros` (`id`, `modelo`, `marca`, `placa`, `renavam`, `chassi`, `ano`, `preco`, `tracao`, `cambio`, `hp`, `disponivel`) VALUES
(1, 'Fusca', 'wolks', '123AD12', '1212asda12', '212easda12', 1970, 10000, 'traseira', 'manual', 150, 1),
(2, 'Honda Civic', 'honda', '1231qwd', '12312312', '1231233', 2019, 70000, 'dianteira', 'automatico', 300, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_clientes`
--

CREATE TABLE `tab_clientes` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `cnh` varchar(11) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_clientes`
--

INSERT INTO `tab_clientes` (`id`, `nome`, `email`, `cpf`, `sexo`, `nascimento`, `tel`, `cnh`, `cep`, `ativo`) VALUES
(1, 'Maria', 'mah@gmail.com', '123.432.234-21', 'f', '1997-04-12', '(21) 93746-5634', '21321321312', '12312-313', 1),
(2, 'João', 'jj@gmail.com', '123.123.233-21', 'm', '1990-12-23', '(21) 93342-3423', '12323123444', '23213-131', 0),
(3, 'Juliana', 'juju@hotmail.com', '231.234.342-35', 'f', '1997-09-12', '(21) 99994-4434', '12312312313', '22321-313', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_funcionarios`
--

CREATE TABLE `tab_funcionarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `titulo_de_eleitor` varchar(15) DEFAULT NULL,
  `certificado_de_reservista` varchar(15) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_funcionarios`
--

INSERT INTO `tab_funcionarios` (`id`, `nome`, `email`, `cpf`, `login`, `senha`, `sexo`, `tel`, `nascimento`, `titulo_de_eleitor`, `certificado_de_reservista`, `cargo`, `ativo`) VALUES
(1, 'root', NULL, NULL, 'root', 'root', NULL, NULL, NULL, NULL, NULL, NULL, 1),
(5, 'Pedro', 'pedo@gmail.com', '123.123.123-21', 'pedrin', '12345', 'm', '(21) 90833-3445', '1998-08-11', '123123123', '123123', 'vendedor', 1),
(6, 'carlos', 'caca@gmail.com', '113.143.123-21', 'carlin', '123456', 'm', '(21) 90233-3445', '1988-04-16', '234242', '123123', 'vendedor', 1),
(7, 'Joao', 'joao@gmail.com', 'joao@gmail.com', 'joaoz', '123456', 'm', '(21) 23323-2331', '1990-12-21', '123123123123', '23.423.434434.3', 'vendedor', 1),
(8, 'Joana', 'jojo@hotmail.com', '123.654.342-12', 'jojo', 'jo321', 'f', '(21) 93234-4997', '1991-07-17', '123123123342', NULL, 'Gerente', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_motos`
--

CREATE TABLE `tab_motos` (
  `id` int(11) NOT NULL,
  `modelo` varchar(25) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `placa` varchar(8) DEFAULT NULL,
  `renavam` varchar(11) DEFAULT NULL,
  `chassi` varchar(17) DEFAULT NULL,
  `ano` smallint(4) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `cilindradas` smallint(5) DEFAULT NULL,
  `disponivel` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_motos`
--

INSERT INTO `tab_motos` (`id`, `modelo`, `marca`, `placa`, `renavam`, `chassi`, `ano`, `preco`, `cilindradas`, `disponivel`) VALUES
(1, 'x23', 'honda', '123dwd2', '2321321ed2', '21312e12', 2018, 10000, 250, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tab_vendas`
--

CREATE TABLE `tab_vendas` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idVeiculo` int(11) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `dataCompra` date DEFAULT NULL,
  `filial` varchar(30) DEFAULT NULL,
  `observacoes` text DEFAULT NULL,
  `pagamento` varchar(25) DEFAULT NULL,
  `tipo_de_veiculo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tab_vendas`
--

INSERT INTO `tab_vendas` (`id`, `idCliente`, `idFuncionario`, `idVeiculo`, `preco`, `dataCompra`, `filial`, `observacoes`, `pagamento`, `tipo_de_veiculo`) VALUES
(2, 1, 1, 2, 70000, '2022-01-30', 'Barra', 'tudo certo', 'Dinheiro', 'Carro'),
(3, 3, 1, 1, 10000, '2022-01-31', 'Tijuca', 'oi', 'Cartao', 'Moto');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tab_caminhoes`
--
ALTER TABLE `tab_caminhoes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tab_carros`
--
ALTER TABLE `tab_carros`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tab_clientes`
--
ALTER TABLE `tab_clientes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tab_funcionarios`
--
ALTER TABLE `tab_funcionarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tab_motos`
--
ALTER TABLE `tab_motos`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tab_vendas`
--
ALTER TABLE `tab_vendas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tab_caminhoes`
--
ALTER TABLE `tab_caminhoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tab_carros`
--
ALTER TABLE `tab_carros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tab_clientes`
--
ALTER TABLE `tab_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tab_funcionarios`
--
ALTER TABLE `tab_funcionarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `tab_motos`
--
ALTER TABLE `tab_motos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tab_vendas`
--
ALTER TABLE `tab_vendas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
