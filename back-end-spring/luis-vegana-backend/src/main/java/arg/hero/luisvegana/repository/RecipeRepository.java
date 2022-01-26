package arg.hero.luisvegana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arg.hero.luisvegana.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
}
