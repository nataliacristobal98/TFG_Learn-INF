package es.natalia.proyecto_final.configuracion;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.krazo.Properties;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("mvc")
public class MvcConfig extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String,Object> viewExtension = new HashMap<>();
        viewExtension.put(Properties.DEFAULT_VIEW_FILE_EXTENSION, "jsp");
        return viewExtension;
    }
}

