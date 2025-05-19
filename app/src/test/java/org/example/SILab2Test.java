package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    void testCheckCart_EveryStatement() {
        RuntimeException error1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "9876543210987654")
        );
        assertEquals("allItems list can't be null!", error1.getMessage());

        List<Item> productList2 = List.of(new Item(null, 2, 200, 0));
        RuntimeException error2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(productList2, "9876543210987654")
        );
        assertEquals("Invalid item!", error2.getMessage());

        List<Item> productList3 = List.of(new Item("Apple", 3, 350, 0.1));
        double total3 = SILab2.checkCart(productList3, "9876543210987654");
        assertEquals(945, total3);

        List<Item> productList4 = List.of(new Item("Book", 2, 120, 0));
        double total4 = SILab2.checkCart(productList4, "9876543210987654");
        assertEquals(240, total4);

        List<Item> productList5 = List.of(new Item("Game", 1, 100, 0));
        RuntimeException error5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(productList5, "9876ABCD4321EFGH")
        );
        assertEquals("Invalid character in card number!", error5.getMessage());
    }

    @Test
    void testCheckCart_MultipleCondition() {
        String cardNumber = "9876543210987654";

        List<Item> list1 = List.of(new Item("Tablet", 1, 350, 0));
        double res1 = SILab2.checkCart(list1, cardNumber);
        assertEquals(320, res1);

        List<Item> list2 = List.of(new Item("Shirt", 1, 100, 0.1));
        double res2 = SILab2.checkCart(list2, cardNumber);
        assertEquals(60, res2); 

        List<Item> list3 = List.of(new Item("Socks", 11, 10, 0));
        double res3 = SILab2.checkCart(list3, cardNumber);
        assertEquals(80, res3); 

        List<Item> list4 = List.of(new Item("Notebook", 1, 80, 0));
        double res4 = SILab2.checkCart(list4, cardNumber);
        assertEquals(80, res4); 
    }
}