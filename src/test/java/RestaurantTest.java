import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restopen;
    @BeforeEach
    public void setup()
    {
        LocalTime openingTime = LocalTime.parse("10:00:00");
        LocalTime closingTime = LocalTime.parse("23:59:00");
        restopen =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restopen.addToMenu("Sweet corn soup",119);
        restopen.addToMenu("Vegetable lasagne", 269);
    }


    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {

        assertEquals(true, restopen.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        LocalTime openingTime = LocalTime.parse("23:30:00");
        LocalTime closingTime = LocalTime.parse("06:00:00");
        restopen =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        assertEquals(false,restopen.isRestaurantOpen());

    }


    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        //removed repeated

        int initialMenuSize = restopen.getMenu().size();
        restopen.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restopen.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        //removed repeated

        int initialMenuSize = restopen.getMenu().size();
        restopen.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restopen.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {


        assertThrows(itemNotFoundException.class,
                ()->restopen.removeFromMenu("French fries"));
    }

}