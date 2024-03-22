
package neville;

import javax.swing.JOptionPane;

public class neville {
    public static void main(String[] args) {
        float[][] Q;
        int num, op = 0;

        JOptionPane.showMessageDialog(null, "METODO DE NEVILLE");

        do {
            String numInput = JOptionPane.showInputDialog(null, "Indique numero de puntos (x,f(x)) a interpolar:");
            try {
                num = Integer.parseInt(numInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un numero válido.");
                continue;
            }

            if (num <= 0) {
                JOptionPane.showMessageDialog(null, "Error: El numero de puntos debe ser mayor que cero.");
                continue;
            }

            Q = new float[num][num];
            float[] vectx = new float[num];

            String xInput = JOptionPane.showInputDialog(null, "Dame el valor de X a interpolar:");
            float x;
            try {
                x = Float.parseFloat(xInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un valor valido para X.");
                continue;
            }

            StringBuilder message = new StringBuilder("VALORES DE X Y F(X):\n");
            for (int i = 0; i < num; i++) {
                String xValue = JOptionPane.showInputDialog(null, "Ingrese valor de X" + i + ":");
                float a;
                try {
                    a = Float.parseFloat(xValue);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un valor valido para X" + i + ".");
                    i--; 
                    continue;
                }
                vectx[i] = a;

                String fxValue = JOptionPane.showInputDialog(null, "Ingrese valor de F(X" + i + "):");
                float b;
                try {
                    b = Float.parseFloat(fxValue);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Por favor, ingrese un valor valido para F(X" + i + ").");
                    i--; 
                    continue;
                }
                Q[i][0] = b;
                message.append("X").append(i).append(": ").append(a).append(", F(X").append(i).append("): ").append(b).append("\n");
            }

            for (int o = 1; o < num; o++) {
                for (int p = o; p < num; p++) {
                    Q[p][o] = ((x - vectx[p - o]) * Q[p][o - 1] - (x - vectx[p]) * Q[p - 1][o - 1]) / (vectx[p] - vectx[p - o]);
                }
            }

            message.append("\nEN LA ULTIMA COLUMNA SE ENCONTRARA LA APROXIMACION\n");
            message.append("\nLa tabla de aproximaciones es la siguiente:\n");
            for (int i = 0; i < num; i++) {
                for (int j = 0; j <= i; j++) {
                    message.append(String.format("%10.6f  ", Q[i][j]));
                }
                message.append("\n");
            }

            JOptionPane.showMessageDialog(null, message.toString());
            op = JOptionPane.showConfirmDialog(null, "¿Desea hacer otro calculo?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        } while (op == JOptionPane.YES_OPTION);
    }
}
