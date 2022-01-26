package arg.hero.luisvegana.service;

import java.util.List;
import java.util.Optional;

import arg.hero.luisvegana.model.Recipe;

public interface IRecipeService {
	
	Recipe save(Recipe recipe);
	List<Recipe> findAll();
	Optional<Recipe> findById(Long id);
	Recipe updateById(Long id, Recipe recipe);
	void deleteById(Long id);
}
