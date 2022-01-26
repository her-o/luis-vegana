package arg.hero.luisvegana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arg.hero.luisvegana.model.Recipe;
import arg.hero.luisvegana.service.impl.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@PostMapping
	public ResponseEntity<Recipe> postNewRecipe(@RequestBody Recipe recipe) {
		return new ResponseEntity<Recipe>(service.save(recipe), OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		return new ResponseEntity<List<Recipe>>(service.findAll(), OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id")Long id) {
		return new ResponseEntity<Recipe>(service.findById(id).get(), OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Recipe> updateRecipeById(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
		return new ResponseEntity<Recipe>(service.updateById(id, recipe), OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecipeById(@PathVariable("id")Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(OK);
	}
}
