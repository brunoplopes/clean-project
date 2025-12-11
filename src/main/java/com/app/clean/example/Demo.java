package com.app.clean.example;

import com.example.example.middleware.Middleware;
import com.example.example.middleware.RoleCheckMiddleware;
import com.example.example.middleware.ThrottlingMiddleware;
import com.example.example.middleware.UserExistsMiddleware;
import com.example.example.server.Server;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Demo {
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.

        try {
            Middleware middleware = Middleware.link(
                    new ThrottlingMiddleware(2),
                    new UserExistsMiddleware(server),
                    new RoleCheckMiddleware()
            );

            middleware.check("admin@example.com", "admin_pass");

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(middleware);


            var executors = Executors.newVirtualThreadPerTaskExecutor();
            var executor = Executors.newVirtualThreadPerTaskExecutor();

            List<Callable<String>> tasks = IntStream.range(0, 1000)
                    .mapToObj(i -> (Callable<String>) () -> {
                        Middleware mid = Middleware.link(
                                new ThrottlingMiddleware(i),
                                new UserExistsMiddleware(server),
                                new RoleCheckMiddleware()
                        );
                        try {
                            Random randomMin = new Random();
                            var min = randomMin.nextInt(100)/10;
                            Random randomMax = new Random();
                            var max = randomMax.nextInt(1000)/10 + min;
                            mid.check("admin@example.com", "admin_pass");
                            var segundos = 1000 * (max - min);
                            System.out.println("Executando na thread: " + Thread.currentThread());
                            Thread.sleep(segundos);
                            System.out.println(i + " id - segundos " + segundos/1000 + " min " + min + " max " + max + "");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return "Task " + i + " finalizada";
                    })
                    .toList();
            for (int i = 1; i <= 1000; i++) {
                int id = i;
                final int finalCount = 1000 - id;
                executor.submit(() -> {
                    Middleware mid = Middleware.link(
                            new ThrottlingMiddleware(id),
                            new UserExistsMiddleware(server),
                            new RoleCheckMiddleware()
                    );
                    try {
                        Random randomMin = new Random();
                        var min = (randomMin.nextInt(1020) - (finalCount - id))/10;
                        Random randomMax = new Random();
                        var max = randomMax.nextInt(1000)/10 + min;
                        mid.check("admin@example.com", "admin_pass");
                        var segundos = 1000 * (max - min);
                        System.out.println("Executando na thread: " + Thread.currentThread());
                        Thread.sleep(segundos);
                        System.out.println(id + " id - segundos " + segundos/1000 + " min " + min + " max " + max + " diferenca " + (max - min));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
//            List<Future<String>> futureList = executors.invokeAll(tasks);
//            executors.shutdown();
//            for (Future<String> f : futureList) {
//                f.get();
//            }

//
            executor.shutdown();

            while (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("Aguardando tarefas finalizarem...");
            }
            System.out.println("Finalizou!");
//            executors.awaitTermination(30, TimeUnit.MINUTES);

//            Middleware middlewareObject = mapper.readValue(jsonString, Middleware.class);
//
//            middlewareObject.check("admin@example.com", "admin_pass");
//
//            String jsonStringmiddleware3 = mapper.writeValueAsString(middlewareObject);
//
//            System.out.println(jsonStringmiddleware3);
//
//            server.setMiddleware(middlewareObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        init();
    }
}
