package fr.insalyon.paces.web.serialisation;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zakaria
 */
public abstract class Serialisation {
    
    public abstract void serialiser(HttpServletRequest request, HttpServletResponse response) throws IOException;
     
}
