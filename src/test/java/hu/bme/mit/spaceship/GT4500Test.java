package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primary;
  private TorpedoStore secondary;

  @Before
  public void init(){
	
	primary = mock(TorpedoStore.class);
	secondary = mock(TorpedoStore.class);
    this.ship = new GT4500(primary, secondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	when(primary.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primary, times(1)).fire(1);
    //assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
	  when(primary.fire(1)).thenReturn(true);
	  when(secondary.fire(1)).thenReturn(true);
    // Act
    ship.fireTorpedo(FiringMode.ALL);
    // Assert
    verify(primary, times(2)).fire(1);
    //verify(secondary, times(1)).fire(1);
    //assertEquals(true, result);
  }

}
