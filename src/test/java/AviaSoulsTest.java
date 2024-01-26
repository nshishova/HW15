import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSearchFromSfoToJFK() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 8, 13);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 10, 15);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 7);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Ticket[] expected = {ticket10, ticket6, ticket2};
        Ticket[] actual = service.search("SFO", "JFK");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchFromGegToAtl() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 8, 13);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 10, 15);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 7);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Ticket[] expected = {ticket3};
        Ticket[] actual = service.search("GEG", "ATL");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchFromLedToJFK() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 8, 13);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 10, 15);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 7);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = service.search("LED", "JFK");
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void duration1EqualDuration2() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("SFO", "JFK", 770, 8, 13);
        Ticket ticket2 = new Ticket("SFO", "JFK", 599, 2, 7);

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void duration1MoreDuration2() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("SFO", "JFK", 770, 8, 18);
        Ticket ticket2 = new Ticket("SFO", "JFK", 599, 2, 7);

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void duration1LessDuration2() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("SFO", "JFK", 770, 8, 9);
        Ticket ticket2 = new Ticket("SFO", "JFK", 599, 2, 7);

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void shouldSearchFromSfoToJFKWithComparator() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 10, 15);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 8, 16);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 6);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket10, ticket2, ticket6};
        Ticket[] actual = service.search("SFO", "JFK", comparator);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchFromGegToAtlWithComparator() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 10, 15);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 8, 16);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 6);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = service.search("GEG", "ATL", comparator);
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchFromLedToJFKWithComparator() {

        AviaSouls service = new AviaSouls();
        Ticket ticket1 = new Ticket("LAX", "MIA", 500, 17, 22);
        Ticket ticket2 = new Ticket("SFO", "JFK", 770, 10, 15);
        Ticket ticket3 = new Ticket("GEG", "ATL", 146, 6, 8);
        Ticket ticket4 = new Ticket("SFO", "TVL", 120, 10, 11);
        Ticket ticket5 = new Ticket("BUF", "MIA", 449, 9, 15);
        Ticket ticket6 = new Ticket("SFO", "JFK", 660, 8, 16);
        Ticket ticket7 = new Ticket("JFK", "MIA", 500, 13, 18);
        Ticket ticket8 = new Ticket("MIA", "SFO", 347, 14, 20);
        Ticket ticket9 = new Ticket("JFK", "SFO", 500, 16, 21);
        Ticket ticket10 = new Ticket("SFO", "JFK", 599, 2, 6);

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);
        service.add(ticket9);
        service.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = service.search("LED", "JFK", comparator);
        Assertions.assertArrayEquals(expected, actual);


    }


}
