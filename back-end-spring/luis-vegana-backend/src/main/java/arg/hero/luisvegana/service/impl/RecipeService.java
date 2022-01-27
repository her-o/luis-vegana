package arg.hero.luisvegana.service.impl;

import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import arg.hero.luisvegana.dto.RecipeDto;
import arg.hero.luisvegana.model.Recipe;
import arg.hero.luisvegana.repository.RecipeRepository;
import arg.hero.luisvegana.service.IRecipeService;

@Service
public class RecipeService implements IRecipeService {
	
	@Autowired
	private RecipeRepository repository;
	
	@Override
	public Recipe save(RecipeDto recipeDto) {
		Recipe recipe = convertFromDtoToRecipe(recipeDto);
		return repository.save(recipe);
	}
	

	@Override
	public List<RecipeDto> findAll() {
		return repository.findAll().stream().map(recipe -> convertFromRecipeToDto(recipe))
											.collect(Collectors.toList());
	}

	@Override
	public Optional<RecipeDto> findById(Long id) {
		Recipe recipe = repository.findById(id).get();
		return Optional.ofNullable(convertFromRecipeToDto(recipe));
	}

	@Override
	public Recipe updateById(Long id, RecipeDto updatedRecipeDto) {
		Recipe recipe = repository.findById(id).get();
		updateRecipeData(recipe, updatedRecipeDto);
		return repository.save(recipe);
	}


	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	
	private void updateRecipeData(Recipe oldRecipe, RecipeDto updatedRecipe) {
		oldRecipe.setTitle(updatedRecipe.getTitle());
		oldRecipe.setDescription(updatedRecipe.getDescription());
		oldRecipe.setContent(updatedRecipe.getContent());
		oldRecipe.setDuration(updatedRecipe.getDuration());
		oldRecipe.setPhoto(convertMultiPartFileToString(updatedRecipe.getFile()));
		oldRecipe.setYoutubeLink(updatedRecipe.getYoutubeLink());
	}
	
	private RecipeDto convertFromRecipeToDto(Recipe recipe) {
		RecipeDto dto = new RecipeDto();
		dto.setId(recipe.getId());
		dto.setTitle(recipe.getTitle());
		dto.setDescription(recipe.getDescription());
		dto.setContent(recipe.getContent());
		dto.setDuration(recipe.getDuration());
		dto.setPhoto(recipe.getPhoto());
		dto.setYoutubeLink(recipe.getYoutubeLink());
		dto.setCreatedOn(recipe.getCreatedOn());
		
		return dto;
	}
	
	
	private Recipe convertFromDtoToRecipe(RecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setTitle(recipeDto.getTitle());
		recipe.setDescription(recipeDto.getDescription());
		recipe.setContent(recipeDto.getContent());
		recipe.setDuration(recipeDto.getDuration());
		recipe.setPhoto(convertMultiPartFileToString(recipeDto.getFile()));
		recipe.setYoutubeLink(recipeDto.getYoutubeLink());
		recipe.setCreatedOn(Instant.now());
		return recipe;
	}
	
	private String convertMultiPartFileToString(MultipartFile file) {
		String image = "";
		if(file.getOriginalFilename().contains("..")) {
			System.out.println("Not a valid file.");
			return "";
		}
		try {
			image = Base64.getEncoder().encodeToString(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}


}
