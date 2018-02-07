/**
 * Dictionary interface for the predictive class
 *
 * @author Connor Wilkes
 * @version 6/2/2018
 */
package predictive;

import java.util.Set;

public interface Dictionary {

    public Set<String> signatureToWords(String signature);
}
