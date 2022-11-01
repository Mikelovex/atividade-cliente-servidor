package com.atividade.atividade.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.atividade.atividade.models.Categoria;
import com.atividade.atividade.models.Livro;
import com.atividade.atividade.repositories.CategoriaRepository;
import com.atividade.atividade.repositories.LivroRepository;

@RestController
public class LivroController {

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	
	@GetMapping
	public ModelAndView telaInicial() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/livros")
	public ModelAndView buscarCategorias() {
	ModelAndView mv = new ModelAndView("listaLivrosPorCategoria");
	Iterable<Categoria> categoria = categoriaRepository.findAll();
	mv.addObject("categorias", categoria);
	return mv;
	}
	


	@GetMapping("/livro/cadastrar")
	public ModelAndView cadastrarLivro() {
	ModelAndView mv = new ModelAndView("cadastrarLivros");
	Iterable<Categoria> categoria = categoriaRepository.findAll();
	mv.addObject("categorias", categoria);
	return mv;
	}
	
	
	
	@GetMapping("/categoria")
	public ModelAndView buscarLivroPorCategoria(@RequestParam String categoria) {
		List<Livro> livros = livroRepository.findByCategoriaContaining(categoria);
		Iterable<Categoria> categorias = categoriaRepository.findAll();

	
		if(livros.size() != 0){
			ModelAndView mv = new ModelAndView("mostrarLivros");
			mv.addObject("categorias", categorias);
			
			mv.addObject("livros", livros);
			
			System.out.println("aqui 2");

			
			return mv;

			
		}else {
			System.out.println("aqui");
			ModelAndView mv = new ModelAndView("naoEncontrado");
			return mv;

		}	

	}
	
	
	@GetMapping("/livros/buscar")
	public ModelAndView buscarlivro() {
	
	
	ModelAndView mv = new ModelAndView("buscarLivro");


	
	return mv;
	}
	
	
	@GetMapping("/livros/codigo")
	public ModelAndView buscarlivroPorCodigo(@RequestParam int codlivro) {
		Optional<Livro> livro = livroRepository.findById(codlivro);
				
		if(!livro.isEmpty()) {
			ModelAndView mv = new ModelAndView("mostrarLivro");
			
			mv.addObject("livros", livro.get());

			return mv;
		}else {
			ModelAndView mv = new ModelAndView("naoEncontrado");
			
			return mv;
		}

	}
	

	@PostMapping("/livros/cadastro")
	public ModelAndView cadastrarLivro(Livro livro) {
		ModelAndView mv = new ModelAndView("index");

		livroRepository.save(livro);
		return mv;
		
	}
	
	@PostMapping("/livros/excluir")
	public ModelAndView excluirLivro(@RequestParam int codlivro) {
		ModelAndView mv = new ModelAndView("livroExcluidoMensagem");

		livroRepository.deleteById(codlivro);
		
		return mv;
	}
	
	
	@PostMapping("/livros/editar")
	public ModelAndView editarLivro(Livro livro) {
		ModelAndView mv = new ModelAndView("livroEditadoMensagem");

		livroRepository.save(livro);
		
		return mv;
	}
	
	
	
}
