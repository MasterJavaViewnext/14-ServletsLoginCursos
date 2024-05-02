package com.cursojava;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Login {
	private String name;
	private String pass;
	private List<String> cursos;
	
	public Login() {
		this.cursos = new ArrayList<>();
	}
	
	public Login(String name, String pass) {
		this.cursos = new ArrayList<>();
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCurso(String curso) {
		this.cursos.add(curso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(this.name, other.getName()) && Objects.equals(this.pass, other.getPass());
	}

	@Override
	public String toString() {
		
		return this.name;
	}
	
	
	
}
