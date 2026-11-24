CREATE TABLE IF NOT EXISTS pagamentos (
    id SERIAL PRIMARY KEY,
    forma_pagamento VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS StatusServico (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS garantia (
    id SERIAL PRIMARY KEY,
    dias_de_garantia INT NOT NULL
);

CREATE TABLE IF NOT EXISTS clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS tecnicos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    email VARCHAR(100),
    especialidade VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS fornecedores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS pecas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    valor NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
    estoque INT NOT NULL DEFAULT 0,
    id_fornecedor INT NOT NULL,
    CONSTRAINT fk_pecas_fornecedor FOREIGN KEY (id_fornecedor) 
        REFERENCES fornecedores (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS pecas_com_defeito (
    id SERIAL PRIMARY KEY,
    tipo_peca VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    id_cliente INT NOT NULL,
    CONSTRAINT fk_pecas_defeito_cliente FOREIGN KEY (id_cliente) 
        REFERENCES clientes (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS ordens_de_servico (
    id SERIAL PRIMARY KEY,
    data_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    valor_servico NUMERIC(10, 2) NOT NULL DEFAULT 0.00,
    id_tecnico INT NOT NULL,
    id_peca INT NOT NULL,
    id_status INT NOT NULL,
    id_garantia INT,
    id_pagamento INT,
    CONSTRAINT fk_os_tecnico FOREIGN KEY (id_tecnico) 
        REFERENCES tecnicos (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_os_peca_defeito FOREIGN KEY (id_peca) 
        REFERENCES pecas_com_defeito (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_os_status FOREIGN KEY (id_status) 
        REFERENCES StatusServico (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_os_garantia FOREIGN KEY (id_garantia) 
        REFERENCES garantia (id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_os_pagamento FOREIGN KEY (id_pagamento) 
        REFERENCES pagamentos (id) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS ordem_peca (
    id SERIAL PRIMARY KEY,
    quantidade INT NOT NULL DEFAULT 1,
    id_ordem_servico INT NOT NULL,
    id_peca INT NOT NULL,
    CONSTRAINT fk_ordem_peca_os FOREIGN KEY (id_ordem_servico) 
        REFERENCES ordens_de_servico (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_ordem_peca_peca FOREIGN KEY (id_peca) 
        REFERENCES pecas (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS entrega_ordens_de_servico (
    id SERIAL PRIMARY KEY,
    data_entrega DATE NOT NULL DEFAULT CURRENT_DATE,
    id_ordem_servico INT NOT NULL,
    CONSTRAINT fk_entrega_os FOREIGN KEY (id_ordem_servico) 
        REFERENCES ordens_de_servico (id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO StatusServico (id, status) VALUES
    (1, 'em espera'),
    (2, 'em andamento'),
    (3, 'pronto para entrega'),
    (4, 'entrega concluída')
ON CONFLICT (id) DO NOTHING;

INSERT INTO pagamentos (id, forma_pagamento) VALUES
    (1, 'Dinheiro'),
    (2, 'Cartão de Débito'),
    (3, 'Cartão de Crédito'),
    (4, 'Pix')
ON CONFLICT (id) DO NOTHING;

INSERT INTO garantia (id, dias_de_garantia) VALUES
    (1, 90),
    (2, 180),
    (3, 365)
ON CONFLICT (id) DO NOTHING;
