# Proyecto: Implementación de la Clase Fraccion en Java

Este proyecto proporciona una implementación completa y robusta de una fracción matemática en Java.

## Diseño de la Clase (Vista Pública vs. Vista Privada)

### Vista Privada (Estado interno)
*   **Atributos:** `numerador` (int) y `denominador` (int). Serán `private` y `final`.
*   **Métodos auxiliares:** `calcularMCD(int a, int b)` será privado (`private`), ya que es un detalle de implementación interno utilizado exclusivamente para simplificar fracciones y no necesita ser expuesto al usuario de la clase.

### Vista Pública (Interfaz de uso)
*   **Constructores:** Permiten crear fracciones proporcionando ambos valores o creando la fracción nula (0/1). El constructor se asegurará de:
    1.  Validar que el denominador no sea cero.
    2.  Mantener el signo negativo siempre en el numerador.
    3.  Simplificar la fracción automáticamente usando el MCD.
*   **Operaciones Aritméticas:** `sumar`, `restar`, `multiplicar` y `dividir`. Todas retornan una nueva instancia de `Fraccion`.
*   **Utilidades:** `inversa()`, `opuesta()` y `toDouble()`.