package tietokanta_backend.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import tietokanta_backend.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.11.24 13:48:05 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class AutotTest {


  // Generated by ComTest BEGIN
  /** testAutot11 */
  @Test
  public void testAutot11() {    // Autot: 11
    Autot autot = new Autot(); 
    Auto auto = new Auto(); 
    Auto auto2 = new Auto(); 
   auto.rekisteroi(); 
    auto2.rekisteroi(); 
    autot.lisaaAuto(auto); 
    autot.lisaaAuto(auto2);
    assertEquals("From: Autot line: 19", 2, autot.getLKM()); 
  } // Generated by ComTest END
}