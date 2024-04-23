package com.parking.lot.commands;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.parking.lot.model.Command;
import com.parking.lot.service.ParkingLotService;
import com.parking.lot.exception.InvalidCommandException;
import org.junit.Before;
import org.junit.Test;

public class CommandExecutorFactoryTest {

  private CommandExecutorFactory factory;

  @Before
  public void setUp() throws Exception {
    final ParkingLotService parkingLotService = mock(ParkingLotService.class);
    factory = new CommandExecutorFactory(parkingLotService);
  }

  @Test
  public void testFetchingExecutorForValidCommand() {
    final CommandExecutor commandExecutor = factory.getCommandExecutor(new Command("leave 1"));
    assertNotNull(commandExecutor);
    assertTrue(commandExecutor instanceof LeaveCommandExecutor);
  }

  @Test(expected = InvalidCommandException.class)
  public void testFetchingExecutorForInvalidCommand() {
    factory.getCommandExecutor(new Command("some-random-command random-param1 random-param2"));
  }
}
