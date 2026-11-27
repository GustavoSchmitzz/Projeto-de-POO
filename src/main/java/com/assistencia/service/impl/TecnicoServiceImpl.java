package com.assistencia.service.impl;

import com.assistencia.entity.Tecnico;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.persistencia.repository.TecnicoRepository;
import com.assistencia.service.TecnicoService;
import com.assistencia.service.dto.TecnicoDto;

import java.util.List;

public class TecnicoServiceImpl implements TecnicoService {
    private final TecnicoRepository tecnicoRepository = RepositoryAbstractFactory.criarTecnicoRepository();

    @Override
    public Tecnico buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor ou igual a zero.");
        }
        Tecnico tecnico = tecnicoRepository.buscar(id);
        if (tecnico == null) {
            throw new IllegalArgumentException("Tecnico nao encontrado.");
        }
        return tecnico;
    }

    @Override
    public Tecnico cadastraTecnico(TecnicoDto dto) {
        validar(dto);

        Tecnico tecnico = new Tecnico();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            tecnico.setId(Integer.parseInt(dto.getId().trim()));
        }
        tecnico.setNome(dto.getNome().trim().toLowerCase());
        tecnico.setEspecialidade(dto.getEspecialidade().trim().toLowerCase());
        tecnico.setTelefone(dto.getTelefone().trim());
        if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
            tecnico.setEmail(dto.getEmail().trim());
        }

        return tecnicoRepository.criar(tecnico);
    }

    @Override
    public boolean deletaTecnico(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor ou igual a zero.");
        }
        Tecnico tecnico = tecnicoRepository.buscar(id);
        if (tecnico == null) {
            throw new IllegalArgumentException("Tecnico nao encontrado.");
        }

        return tecnicoRepository.deletar(id);
    }

    @Override
    public boolean atualizaTecnico(TecnicoDto dto) {
        validar(dto);
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Id nao pode ser nulo.");
        }
        int id = Integer.parseInt(dto.getId().trim());
        if (tecnicoRepository.buscar(id) == null) {
            throw new RuntimeException("Tecnico nao encontrado.");
        }

        Tecnico tecnico = new Tecnico();
        tecnico.setId(id);
        tecnico.setNome(dto.getNome().trim().toLowerCase());
        tecnico.setEspecialidade(dto.getEspecialidade().trim().toLowerCase());
        tecnico.setTelefone(dto.getTelefone().trim());
        if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
            tecnico.setEmail(dto.getEmail().trim());
        }

        return tecnicoRepository.atualizar(tecnico);
    }

    @Override
    public List<TecnicoDto> listarTodos() {
        List<Tecnico> lista = tecnicoRepository.buscarTodos();

        List<TecnicoDto> dtos = lista.stream().map(this::toDto).toList();

        return dtos;
    }

    private void validar(TecnicoDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Tecnico nao pode ser nulo.");
        }
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome nao pode ser vazio.");
        }
        if (dto.getEspecialidade() == null || dto.getEspecialidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade nao pode ser vazio.");
        }
        if (dto.getTelefone() == null || !dto.getTelefone().trim().matches("^[0-9]{10,11}$")) {
            throw new IllegalArgumentException("Telefone nao pode ser vazio ou com mais de 11 digitos.");
        }
    }

    private TecnicoDto toDto(Tecnico tecnico) {
        TecnicoDto dto = new TecnicoDto();

        dto.setId(tecnico.getId() + "");
        dto.setNome(tecnico.getNome());
        dto.setTelefone(tecnico.getTelefone());
        dto.setEmail(tecnico.getEmail());
        dto.setEspecialidade(tecnico.getEspecialidade());

        return dto;
    }
}
