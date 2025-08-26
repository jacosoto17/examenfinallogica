🍽️ Restaurante La Orquidea – Sistema de Pedidos

Este proyecto es un sistema en Java que simula un restaurante digital.
Permite registrar pedidos, aplicar descuentos automáticos y generar un reporte detallado de la orden.

🚀 Funcionalidades
📜 Menú inicial

Se carga un menú de 6 platos en un HashMap<String, Double>.

Cada plato tiene un nombre (clave) y un precio (valor).

🛒 Registro de pedidos

El usuario escribe los nombres de los platos.

Se pueden ingresar tantos platos como se desee.

El pedido termina cuando se escribe FIN (sin importar mayúsculas/minúsculas).

✅ Validación de platos

Si el plato no existe en el menú, se lanza la excepción personalizada PlatoNoEncontradoException.

Así se garantiza que el pedido siempre sea válido.

⚠️ Manejo de errores

PlatoNoEncontradoException: cuando un plato no está en el menú.

InputMismatchException: cuando el dato ingresado no es válido.

IllegalStateException: si el usuario no pidió ningún plato (pedido vacío).

💰 Cálculo de totales

La función calcularTotal suma el precio de todos los platos del pedido.

🎉 Aplicación de descuentos

Si el total es mayor a 50.000 → 10% de descuento.

Si el total es mayor a 100.000 → 15% de descuento.

La función aplicarDescuento calcula el precio final.

🏆 Plato más pedido

Se identifica el plato con mayor número de repeticiones usando Streams.

También se muestra cuántas veces fue pedido.

📊 Promedio de precios

Se calcula el promedio de precios de los platos seleccionados.

📋 Reporte final

El sistema muestra al final:

📌 El pedido completo.

💵 El total sin descuento.

🎁 El total con descuento.

🥇 El plato más pedido y cuántas veces se pidió.

📊 El promedio de precios de los platos del pedido.

🎯 Beneficios del programa

Garantiza que el usuario solo pueda pedir platos válidos.

Aplica descuentos automáticamente según el monto.

Genera un reporte completo y claro del pedido.

Permite escribir platos en mayúsculas o minúsculas sin problema.

🛠️ Tecnologías utilizadas

Java ☕

HashMap, ArrayList y Streams para manejar datos.

Excepciones personalizadas para mayor control y robustez.

QUE APRENDI DURANTE EL CURSO

Aprendi a manejar java, cosa que no sabia absolutamente nada, aprendi mucho sobre los ciclos, las exepciones y el manejo de listas y diccionarios, la verdad, de todas los modulos que vemos, este es por mucho uno de los mejores 
