package com.algorithmtron.serviceTest;

import com.algorithmtron.service.MinStackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MinStackServiceTest {
    @Test
    void buildStackAndRetrieveTopElement () {
        MinStackService minStackService = new MinStackService();

        minStackService.push(3);
        minStackService.push(2);

        assertEquals(2,minStackService.top());
    }

    @Test
    void buildStackAndGetMin () {
        MinStackService minStackService = new MinStackService();

        minStackService.push(3);
        minStackService.push(1);
        minStackService.push(2);

        assertEquals(1,minStackService.getMin());
    }

    @Test
    void getMinOnEmptyStack () {
        MinStackService minStackService = new MinStackService();

        Assertions.assertEquals(Integer.MIN_VALUE ,minStackService.getMin());
    }

    @Test
    void retrieveTopOnEmptyStack () {
        MinStackService minStackService = new MinStackService();

        Assertions.assertEquals(Integer.MIN_VALUE ,minStackService.top());
    }

    @Test
    void buildStackWithNegativeElemAndGetMin () {
        MinStackService minStackService = new MinStackService();

        minStackService.push(-3);
        minStackService.push(23);

        assertEquals(-3,minStackService.getMin());
    }


    @Test
    void removingAnElementWhenTheStackIsNotEmpty () {
        MinStackService minStackService = new MinStackService();
        minStackService.push(2);
        minStackService.push(3);

        minStackService.pop();

        assertEquals(2, minStackService.top());
    }

    @Test
    void pushOneElementIntoStack () {
        MinStackService minStackService = new MinStackService();
        minStackService.push(2);

        Assertions.assertEquals( 2, minStackService.top());
    }

    @Test
    void pushSecondElementIntoStackThatIsNewMinimum () {
        MinStackService minStackService = new MinStackService();

        minStackService.push(2);
        minStackService.push(-1);

        Assertions.assertEquals(-1, minStackService.getMin());
    }
}
