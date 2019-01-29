create table `empresa` (
	`id` bigint(20) not null,
	`cnpf` varchar(255) not null,
	`data_atualizacao` datetime not null,
	`data_criacao` datetime not null,
	`razao_social` varchar(255) not null
) engine=InnoDB default charset=utf8;

create table `funcionario`(
	`id` bigint(20) not null,
	`cpf` varchar(255) not null,
	`data_atualizacao` datetime not null,
	`email` varchar(255) not null,
	`nome` varchar(255) not null,
	`perfil` varchar(255) not null,
	`qtde_horas_almoco` float default null,
	`qtde_horas_trabalho_dia` float default null,
	`senha` varchar(255) not null,
	`valor_hora` decimal(19,2) default null,
	`empresa_id` bigint(20) default null
) engine=InnoDB default charset=utf8;

create table `lancamento`(
	`id` bigint(20) not null,
	`data` datetime not null,
	`data_atualizacao` datetime not null,
	`data_criacao` datetime not null,
	`descricao` varchar(255) default null,
	`localizacao` varchar(255) not null,
	`tipo`varchar(255) not null,
	`funcionario_id` bigint(20) default null
) engine=InnoDB default charset=utf8;

--
-- Indexes for table `empresa`
--
alter table `empresa` add primary key(`id`);

--
-- Indexes for table `funcionario`
--
alter table `funcionario` 
	add primary key(`id`), 
	add key `FK4cm1kg523jlopyexjbmi6y54j` (`empresa_id`);
	
--
-- Indexes for table `lancamento`
--
alter table `lancamento`
	add primary key(`id`), 
	add key `FK46i4k5vl8wah7feutye9kbpi4` (`funcionario_id`);
	
--
-- AUTO_INCREMENT for table `empresa`
--
alter table `empresa`
	modify `id` bigint(20) not null auto_increment;

--
-- AUTO_INCREMENT for table `funcionario`
--
alter table `funcionario`
	modify `id` bigint(20) not null auto_increment;
	
--
-- AUTO_INCREMENT for table `lancamento`
--
alter table `lancamento`
	modify `id` bigint(20) not null auto_increment;

--
-- Constraints for dumped tables
--
	
--
-- Constraints for table `funcionario`
--
alter table `funcionario`
	add constraint `FK4cm1kg523jlopyexjbmi6y54j` foreign key(`empresa_id`) references `empresa` (`id`);

--
-- Constraints for table `lancamento`
--
alter table `lancamento`
	add constraint `FK46i4k5vl8wah7feutye9kbpi4` foreign key(`funcionario_id`) references `funcionario` (`id`);