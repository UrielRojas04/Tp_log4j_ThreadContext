package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class ThreadContextEjemplo {
    private static final Logger logger = LogManager.getLogger(ThreadContextEjemplo.class);

    public static void main(String[] args) {

        // Añadimos userId al contexto del hilo principal
        ThreadContext.put("userId", "usuarioPrincipal");

        logger.info("Inicio de la operación");

        Thread thread = new Thread(() -> {
            ThreadContext.put("userId", "usuarioHiloSecundario");
            logger.info("Mensaje desde el hilo secundario");
            ThreadContext.clearAll();
        });

        thread.start();

        logger.info("Fin de la operación");

        ThreadContext.clearAll();
    }
}
