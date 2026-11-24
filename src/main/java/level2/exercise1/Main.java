package level2.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Referencia concreta: acceso total a métodos de Phone, Camera y Clock
        SmartPhone smartPhone1 = new SmartPhone("Apple", "iPhone 13");
        smartPhone1.call("123-456-7890");
        smartPhone1.takePhoto();
        smartPhone1.alarm();

        System.out.println("---");

        // 2. Referencia tipada por interfaz Clock: solo ve el contrato Clock
        Clock clock = new SmartPhone("Samsung", "Galaxy S21");
        clock.alarm();
        // clock.takePhoto(); // ERROR de compilación: Clock no conoce takePhoto()
        // clock.call("123"); // ERROR de compilación: Clock no conoce call()

        // 3. Referencia tipada por interfaz Camera: solo ve el contrato Camera
        Camera camera = new SmartPhone("Google", "Pixel 6");
        camera.takePhoto();

        System.out.println("---");

        // 4. Ventaja real: agrupar objetos distintos por una capacidad común (Polimorfismo)
        List<Camera> photoDevices = new ArrayList<>();
        photoDevices.add(smartPhone1); // Es un SmartPhone, pero cumple el contrato Camera
        photoDevices.add(camera);      // Ya está tipado como Camera

        for (Camera device : photoDevices) {
            device.takePhoto(); // Ejecuta la implementación real de cada objeto en memoria
        }
    }
}