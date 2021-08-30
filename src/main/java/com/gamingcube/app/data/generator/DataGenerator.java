package com.gamingcube.app.data.generator;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.gamingcube.app.data.Role;
import com.gamingcube.app.data.entity.SampleFoodProduct;
import com.gamingcube.app.data.entity.User;
import com.gamingcube.app.data.service.SampleFoodProductRepository;
import com.gamingcube.app.data.service.UserRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class DataGenerator {

  @Bean
  public CommandLineRunner loadDataxxx(SampleFoodProductRepository sampleFoodProductRepository,
      UserRepository userRepository) {
    return args -> {
      Logger logger = LoggerFactory.getLogger(getClass());
      if (sampleFoodProductRepository.count() != 0L) {
        logger.info("Using existing database");
        return;
      }
      int seed = 123;

      logger.info("Generating demo data");

      DataType<Set<Role>> roles = new DataType<Set<Role>>() {

        @Override
        public Set<Role> getValue(Random random, int seed, LocalDateTime referenceTime) {
          // TODO Auto-generated method stub
          return Set.of(Role.ADMIN);
        }
      };

      logger.info("... generating 100 Sample Food Product entities...");
      ExampleDataGenerator<SampleFoodProduct> sampleFoodProductRepositoryGenerator = new ExampleDataGenerator<>(
          SampleFoodProduct.class, LocalDateTime.of(2021, 8, 29, 0, 0, 0));
      sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setId, DataType.ID);
      sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setImage, DataType.FOOD_PRODUCT_IMAGE);
      sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setName, DataType.FOOD_PRODUCT_NAME);
      sampleFoodProductRepositoryGenerator.setData(SampleFoodProduct::setEanCode, DataType.FOOD_PRODUCT_EAN);
      sampleFoodProductRepository.saveAll(sampleFoodProductRepositoryGenerator.create(100, seed));

      logger.info("... generating 100 User entities...");
      ExampleDataGenerator<User> userRepositoryGenerator = new ExampleDataGenerator<>(User.class,
          LocalDateTime.of(2021, 8, 29, 0, 0, 0));
      userRepositoryGenerator.setData(User::setId, DataType.ID);
      userRepositoryGenerator.setData(User::setUsername, DataType.FIRST_NAME);
      userRepositoryGenerator.setData(User::setName, DataType.FULL_NAME);
      userRepositoryGenerator.setData(User::setHashedPassword, DataType.TWO_WORDS);
      userRepositoryGenerator.setData(User::setRoles, roles);
      userRepositoryGenerator.setData(User::setProfilePictureUrl, DataType.PROFILE_PICTURE_URL);
      userRepository.saveAll(userRepositoryGenerator.create(100, seed));

      logger.info("Generated demo data");

    };
  }

}