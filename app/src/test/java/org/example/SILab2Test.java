package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    void testCheckCart_EveryStatement() {
        // Case 1: null list of items
        RuntimeException error1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "9876543210987654")
        );
        assertEquals("allItems list can't be null!", error1.getMessage());

        // Case 2: item with null name
        List<Item> productList2 = List.of(new Item(null, 2, 200, 0));
        RuntimeException error2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(productList2, "9876543210987654")
        );
        assertEquals("Invalid item!", error2.getMessage());

        // Case 3: item with discount applied
        List<Item> productList3 = List.of(new Item("Apple", 3, 350, 0.1));
        double total3 = SILab2.checkCart(productList3, "9876543210987654");
        assertEquals(945, total3); // 350 * 3 = 1050; -10% = 945

        // Case 4: item without discount
        List<Item> productList4 = List.of(new Item("Book", 2, 120, 0));
        double total4 = SILab2.checkCart(productList4, "9876543210987654");
        assertEquals(240, total4);

        // Case 5: invalid character in card number
        List<Item> productList5 = List.of(new Item("Game", 1, 100, 0));
        RuntimeException error5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(productList5, "9876ABCD4321EFGH")
        );
        assertEquals("Invalid character in card number!", error5.getMessage());
    }

    @Test
    void testCheckCart_MultipleCondition() {
        String cardNumber = "9876543210987654";

        // condition: (true || false || false)
        List<Item> list1 = List.of(new Item("Tablet", 1, 350, 0));
        double res1 = SILab2.checkCart(list1, cardNumber);
        assertEquals(320, res1); // Discounted for price >= 300

        // condition: (false || true || false)
        List<Item> list2 = List.of(new Item("Shirt", 1, 100, 0.1));
        double res2 = SILab2.checkCart(list2, cardNumber);
        assertEquals(60, res2); // 100 - 40% = 60

        // condition: (false || false || true)
        List<Item> list3 = List.of(new Item("Socks", 11, 10, 0));
        double res3 = SILab2.checkCart(list3, cardNumber);
        assertEquals(80, res3); // 110 total - 30 = 80

        // condition: (false || false || false)
        List<Item> list4 = List.of(new Item("Notebook", 1, 80, 0));
        double res4 = SILab2.checkCart(list4, cardNumber);
        assertEquals(80, res4); // No discount
    }
}