package tietokanta_backend.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import tietokanta_backend.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2022.11.24 13:50:59 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class LiikkeetTest {



  // Generated by ComTest BEGIN
  /** testLiikkeet19 */
  @Test
  public void testLiikkeet19() {    // Liikkeet: 19
    Liikkeet liikkeet = new Liikkeet(); 
    Liike liike= new Liike(); 
    Liike liike2= new Liike(); 
    liike.rekisteroi(); 
    liike2.rekisteroi(); 
    try {
    liikkeet.lisaa(liike); 
    liikkeet.lisaa(liike2); 
    } catch (SailoException e) {
    e.printStackTrace(); 
    }
  } // Generated by ComTest END
}