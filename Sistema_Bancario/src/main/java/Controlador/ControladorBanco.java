/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cuenta;
import Modelo.CuentaAhorros;
import Modelo.CuentaCorriente;
import Modelo.Fecha;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorBanco {

    private ArrayList<Cuenta> cuentas;

    public ControladorBanco() {
        cuentas = new ArrayList<>();
    }

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public boolean crearCuentaAhorros(String numero, String titular, Fecha fecha, double saldoInicial) {
        if (buscarCuenta(numero) != null) {
            return false;
        }
        cuentas.add(new CuentaAhorros(numero, titular, fecha, saldoInicial));
        return true;
    }

    public boolean crearCuentaCorriente(String numero, String titular, Fecha fecha, double saldoInicial, double cupoSobregiro) {
        if (buscarCuenta(numero) != null) {
            return false;
        }
        cuentas.add(new CuentaCorriente(numero, titular, fecha, saldoInicial, cupoSobregiro));
        return true;
    }

    public boolean consignar(String numero, double valor) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) {
            return false;
        }
        return c.consignar(valor);
    }

    public boolean retirar(String numero, double valor) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) {
            return false;
        }
        return c.retirar(valor);
    }

    public String consultarSaldo(String numero) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) {
            return null;
        }
        return c.mostrarDatos(true);
    }

    public String consultarDatos(String numero) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) {
            return null;
        }
        return c.mostrarDatos();
    }
}