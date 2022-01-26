package arg.hero.luisvegana.service.impl;

import java.time.Instant;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arg.hero.luisvegana.model.Recipe;
import arg.hero.luisvegana.repository.RecipeRepository;
import arg.hero.luisvegana.service.IRecipeService;

@Service
public class RecipeService implements IRecipeService {
	
	@Autowired
	private RecipeRepository repository;
	
	@Override
	public Recipe save(Recipe recipe) {
		recipe.setCreatedOn(Instant.now());
		return repository.save(recipe);
	}

	@Override
	public List<Recipe> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Recipe> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Recipe updateById(Long id, Recipe updatedRecipe) {
		Recipe recipe = repository.findById(id).get();
		updateRecipeData(recipe, updatedRecipe);
		return repository.save(recipe);
	}


	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
	private void updateRecipeData(Recipe oldRecipe, Recipe updatedRecipe) {
		oldRecipe.setTitle(updatedRecipe.getTitle());
		oldRecipe.setDescription(updatedRecipe.getDescription());
		oldRecipe.setContent(updatedRecipe.getContent());
		oldRecipe.setDuration(updatedRecipe.getDuration());
		oldRecipe.setYoutubeLink(updatedRecipe.getYoutubeLink());
	}


}
