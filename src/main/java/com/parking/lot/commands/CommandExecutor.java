package com.parking.lot.commands;

import com.parking.lot.OutputPrinter;
import com.parking.lot.model.Command;
import com.parking.lot.service.ParkingLotService;

/**
 * Command executor interface.
 */
public abstract class CommandExecutor {
  protected ParkingLotService parkingLotService;
  protected OutputPrinter outputPrinter;

  public CommandExecutor(final ParkingLotService parkingLotService,
      final OutputPrinter outputPrinter) {
    this.parkingLotService = parkingLotService;
    this.outputPrinter = outputPrinter;
  }

  /**
   * Validates that whether a command is valid to be executed or not.
   *
   * @param command Command to be validated.
   * @return Boolean indicating whether command is valid or not.
   */
  public abstract boolean validate(Command command);

  /**
   * Executes the command.
   *
   * @param command Command to be executed.
   */
  public abstract void execute(Command command);
}
