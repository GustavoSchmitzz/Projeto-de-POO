package com.assistencia.entity;


public abstract class Pessoa {
    private String nome;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome nao pode ser nulo ou vazio.");
        }
        if (nome.length() > 100) {
            throw new IllegalArgumentException("nome nao pode ter mais de 100 caracteres.");
        }
        this.nome = nome.trim().toLowerCase();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.trim().matches("^[0-9]{10,11}$")) {
            throw new IllegalArgumentException("telefone nao pode ser nulo, vazio ou ter mais de 11 caracteres.");
        }
        this.telefone = telefone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.trim().matches("^[a-zA-Z0-9À-ÿ._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("email nao pode ser nulo ou invalido.");
        }
        this.email = email.trim().toLowerCase();
    }
}
