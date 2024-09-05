package ch.noseryoung.drinks.drink;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    private static DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink findById(Integer drinkId) {

        return drinkRepository.findById(drinkId).orElse(null);
    }


    public Drink createDrink(Drink drink) {

        return drinkRepository.save(drink);
    }

    public static Drink updateDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public boolean deleteDrink(Integer drinkId) {
        if(drinkRepository.existsById(drinkId)) {
            drinkRepository.deleteById(drinkId);
            return true;
        } else {
            return false;
        }
    }
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }
}
