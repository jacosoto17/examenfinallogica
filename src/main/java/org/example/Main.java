package org.example;

import java.util.*;
import java.util.stream.Collectors;

class PlatoNoEncontradoException extends Exception {
    public PlatoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> menu = new HashMap<>();
        menu.put("Bandeja Paisa", 30000.00);
        menu.put("Changua", 30000.00);
        menu.put("Pollo Asado", 40000.00);
        menu.put("Pescado Frito", 25000.00);
        menu.put("Torta de Limon", 10000.00);
        menu.put("Plato Ejecutivo", 15000.00);

        ArrayList<String> pedido = new ArrayList<>();

        System.out.println("=== Bienvenido al restaurante La Orquidea ===");
        System.out.println("El siguiente es nuestro menú disponible para el dia de hoy: ");
        menu.forEach((Plato, Precio) -> System.out.println(Plato + " - $" + Precio));
        System.out.println("\nIngrese los platos que desea (escriba 'Fin' para terminar):");

        while (true) {
            try {
                String PlatoPedido = scanner.nextLine().trim();

                if (PlatoPedido.equalsIgnoreCase("Fin")) break;

                Optional<String> platoEncontrado = menu.keySet().stream()
                        .filter(p -> p.equalsIgnoreCase(PlatoPedido))
                        .findFirst();

                if (platoEncontrado.isEmpty()) {
                    throw new PlatoNoEncontradoException("El plato " + PlatoPedido + " no existe en el menú");
                }

                // guardamos el nombre original tal como está en el menú
                pedido.add(platoEncontrado.get());

            } catch (PlatoNoEncontradoException e) {
                System.out.println("⚠️ " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("⚠️ No pudo procesarse tu pedido, intenta de nuevo.");
                scanner.next();
            }
        }

        if (pedido.isEmpty()) {
            throw new IllegalStateException("No puede procesarse un pedido vacio, porfavor ingresa un pedido valido.");
        }

        double totalPedido = calcularTotal(pedido, menu);
        double totalConDescuento = aplicarDescuento(totalPedido);

        String platoMasPedido = pedido.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        int cantidadPlatoMasPedido = (int) pedido.stream()
                .filter(p -> p.equals(platoMasPedido))
                .count();

        double promedio = pedido.stream()
                .mapToDouble(p -> menu.get(p))
                .average()
                .orElse(0);

        System.out.println("\n=== PEDIDO FINAL ===");
        System.out.println("Pedido: " + pedido);
        System.out.println("Total sin descuento: $" + totalPedido);
        System.out.println("Total con descuento: $" + totalConDescuento);
        System.out.println("Plato más pedido: " + platoMasPedido + " (" + cantidadPlatoMasPedido + " veces)");
        System.out.printf("Promedio de precios: $%.2f\n", promedio);
    }

    public static double aplicarDescuento(double total) {
        double descuento = 0;

        if (total > 100000) {
            descuento = total * 15/100;
        } else if (total > 50000) {
            descuento = total * 10/100;
        }

        return total - descuento;
    }

    public static double calcularTotal(ArrayList<String> orden, HashMap<String, Double> menu) {
        return orden.stream().mapToDouble(p -> menu.get(p)).sum();
    }
}
