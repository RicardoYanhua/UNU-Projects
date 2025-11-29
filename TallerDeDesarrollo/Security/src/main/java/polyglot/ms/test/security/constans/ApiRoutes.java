package polyglot.ms.test.security.constans;

public class ApiRoutes { 

// Definición de rutas base para las APIs de transacciones
   public static class Seguridad {
        public static final String BASE = "/api/auth";
    
        public static final String ID_INVOICE = "/operation/{id_operation}";

        public static final String LISTAR = "/listar";
        public static final String CREAR = "/crear";
         public static final String AUTH = "/Autentificarse";

        public static final String UPDATE = "/update/{id_operation}";
        public static final String DELETE = "/delete/{id_operation}";
    } 
}