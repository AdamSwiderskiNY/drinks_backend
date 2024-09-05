package ch.noseryoung.drinks.drink;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drink")
public class DrinkWeb {
    private DrinkService drinkService;

    @Autowired
    public DrinkWeb(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/{drinkId}")
    @Operation(description = "Gets the drink you want by the Id.", summary = "Shows you the requested drink.")
    public ResponseEntity<Drink> getDrinkById(@PathVariable("drinkId") Integer drinkId) {
        Drink getDrink = (Drink) drinkService.findById(drinkId);
        if (getDrink != null) {
            return ResponseEntity.ok().body(getDrink);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    @Operation(description = "Makes creating new drinks possible.", summary = "Create a new drink")
    public ResponseEntity<Drink> createSupplier(@RequestBody Drink drink) {
        Drink postDrink = drinkService.createDrink(drink);

        return ResponseEntity.ok().body(postDrink);
    }

    @PutMapping("/{drinkId}")
    @Operation(description = "Update the desired drink, change the name or price if incorrect.",
            summary = "Update a drink.")
    public ResponseEntity<Drink> putDrinkById(@PathVariable("drinkId") Integer drinkId, @RequestBody Drink drink) {
        Drink putDrink = DrinkService.updateDrink(drink);

        return ResponseEntity.ok().body(putDrink);
    }

    @DeleteMapping("/{drinkId}")
    @Operation(description = "Delete a drink by using his id.", summary = "Delete a drink.")
    public ResponseEntity<Drink> deleteDrinkById(@PathVariable("drinkId") Integer drinkId) {
        boolean isDeleted = drinkService.deleteDrink(drinkId);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/alldrinks")
    @Operation(description = "Show all of the provided drinks.", summary = "Show all drinks.")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        List<Drink> drinks = drinkService.findAll();
        return ResponseEntity.ok().body(drinks);
    }
}
