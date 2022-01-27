package arg.hero.luisvegana.service;

import java.util.List;

import java.util.Optional;

import arg.hero.luisvegana.dto.RecipeDto;
import arg.hero.luisvegana.model.Recipe;

public interface IRecipeService {
	
	Recipe save(RecipeDto recipeDto);
	List<RecipeDto> findAll();
	Optional<RecipeDto> findById(Long id);
	Recipe updateById(Long id, RecipeDto recipeDto);
	void deleteById(Long id);
	
}
