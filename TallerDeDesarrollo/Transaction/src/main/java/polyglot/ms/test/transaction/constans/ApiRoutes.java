package polyglot.ms.test.transaction.constans;

public class ApiRoutes { 

// Definición de rutas base para las APIs de transacciones
   public static class Transacciones {
        public static final String BASE = "/api/transaction";
        public static final String LISTAR = "/listar";
        public static final String CREAR = "/crear";

        public static final String ID_TRANSACTION = "/id_transaction/{id_transaction}";
        public static final String ID_INVOICE = "/invoice/{id_invoice}";
        public static final String UPDATE = "/update/{id_transaction}";
        public static final String DELETE = "/delete/{id_transaction}";
    } 
}
