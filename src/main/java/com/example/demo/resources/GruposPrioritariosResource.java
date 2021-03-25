package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.GruposPrioritarios;
import com.example.demo.repository.GruposPrioritariosRepository;


@RestController
@RequestMapping("/grupos")
public class GruposPrioritariosResource {
		
		@Autowired
		private GruposPrioritariosRepository gruposPrioritariosRepository;
		
		@GetMapping
		public List<GruposPrioritarios> listarTodos() {
			return gruposPrioritariosRepository.findAll();
		}
		
		@PostMapping
		public GruposPrioritarios cadastrarGrupo(@RequestBody GruposPrioritarios gruposPrioritarios) {
			return gruposPrioritariosRepository.save(gruposPrioritarios);
		}
		
		@PutMapping("{codigo}")
		public GruposPrioritarios atualizar(@PathVariable("codigo") Long codigo,
				@RequestBody GruposPrioritarios gruposPrioritarios) {
			return gruposPrioritariosRepository.findById(codigo).map(
					record -> {
						record.setDescricao(gruposPrioritarios.getDescricao());
						record.setNome(gruposPrioritarios.getNome());
						return gruposPrioritariosRepository.save(record);
					}).orElse(null);
		}		
		
		@GetMapping("/{codigo}")
		public GruposPrioritarios buscarPeloCodigo(@PathVariable Long codigo) {
			return gruposPrioritariosRepository.findById(codigo).orElse(null);
		}
		
}
